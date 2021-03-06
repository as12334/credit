package so.wwb.lotterybox.web.shiro.common.filter.autho;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.soul.commons.bean.Pair;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.security.privilege.po.SysResource;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.model.session.SessionKey;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class AuthorizationFilter extends org.apache.shiro.web.filter.authz.AuthorizationFilter {

    private static final Log LOG = LogFactory.getLog(AuthorizationFilter.class);
    private Map<String, Map<String, Pair<String, Boolean>>> permissionMapping = new HashMap<>();
    private Map<String, Map<String, Pair<String, Boolean>>> patternPermissionMapping = new HashMap<>();

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return false;
        }
        Map<String, Pair<String, Boolean>> userPermissionMapping = (Map<String, Pair<String, Boolean>>) SessionManagerCommon.getAttribute(SessionKey.S_USER_PERMISSIONS);
        SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
        if (permissionMapping.get(sysUser.getSubsysCode()) == null) {
            getPerimssionMapping(sysUser);
        }
        if (patternPermissionMapping == null) {
            getPatternPermissionMapping(userPermissionMapping);
        }
        boolean isPermitted= isPermitted(userPermissionMapping, request, subject);
        if(!isPermitted && ServletTool.isAjaxRequest(request)){
            Integer code = Integer.parseInt(ErrorCodeEnum.SC_FORBIDDEN.getCode());
            response.setStatus(code);
            response.setHeader(CUSTOM_HEADER_STATUS, code.toString());//
        }
        return isPermitted;
    }

    private boolean isPermitted(Map<String, Pair<String, Boolean>> userPermissionMapping, HttpServletRequest request, Subject subject) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String requestPath = requestURI.replaceFirst(contextPath + "/", "");
        Pair<String, Boolean> pair = userPermissionMapping.get(requestPath);
        String permission = null;
        if (pair == null) {
            pair = isPatternMatch(requestPath);
        }
        if (pair != null) {
            permission = pair.getKey();
            request.setAttribute(SessionKey.R_URL_PRIVILEGE, pair.getValue());
        }

        //用户权限不包含当前请求url时，需要判断该url是否需要权限才可访问
        if (StringTool.isBlank(permission)) {
            SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
            Map<String, Pair<String, Boolean>> map = permissionMapping.get(sysUser.getSubsysCode());
            pair = map.get(requestPath);
            if (pair != null) {
                LOG.warn("权限:({0})[禁止访问],请求地址:{1}", permission, requestURI);
                return false;
            }
            LOG.warn("权限:permission为空![允许访问],请求地址:{0}", requestURI);
            LOG.warn("当前权限[{0}],地址[{1}]", JsonTool.toJson(permission), requestPath);
            return true;
        }
        boolean rs = subject.isPermitted(permission);
        if (!rs) {
            LOG.warn("权限:({0})[禁止访问],请求地址:{1}", permission, requestURI);
        }
        return rs;
    }

    /**
     * 是否符合正则表达式匹配
     *
     * @param requestPath
     * @return
     */
    private Pair<String, Boolean> isPatternMatch(String requestPath) {
        SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
        Map<String, Pair<String, Boolean>> map = patternPermissionMapping.get(sysUser.getSubsysCode());
        if (MapTool.isNotEmpty(map)) {
            for (Map.Entry<String, Pair<String, Boolean>> entry : map.entrySet()) {
                if (requestPath.matches(entry.getKey())) {
                    Pair<String, Boolean> pair2 = entry.getValue();
                    return pair2;
                }
            }
        }
        return null;
    }

    /**
     * 获取URL所对应的所有权限列表
     *
     * @param user
     */
    private void getPerimssionMapping(SysUser user) {
        Map permissionMapping = new HashMap();
        SysResourceVo vo = new SysResourceVo();
        //warning: 如果页面存在不同的subsysCode用户,访问一个web应用时,逻辑有误
        vo.getSearch().setSubsysCode(user.getSubsysCode());
        List<SysResource> sysResources = ServiceTool.sysResourceService().bySubSysCode(vo);
        for (SysResource sysResource : sysResources) {
            if (StringTool.isNotBlank(sysResource.getUrl())) {
                permissionMapping.put(sysResource.getUrl(), new Pair(sysResource.getPermission(), sysResource.getPrivilege()));
            }
        }
        if (permissionMapping.size() > 0)
            this.permissionMapping.put(user.getSubsysCode(), permissionMapping);
    }

    /**
     * 获取用户权限中需要替换的特殊字符
     *
     * @param userPermissionMapping
     */
    private void getPatternPermissionMapping(Map<String, Pair<String, Boolean>> userPermissionMapping) {
        Map patternPermissionMapping = new HashMap();
        if (userPermissionMapping == null) {
            return;
        }
        for (Map.Entry<String, Pair<String, Boolean>> entry : userPermissionMapping.entrySet()) {
            String url = entry.getKey();
            if (StringTool.isNotBlank(url) && url.contains("{")) {
                patternPermissionMapping.put(url.replaceAll("\\{\\w+\\}", "\\\\w+"), entry.getValue());
            }
        }
        if (patternPermissionMapping.size() > 0) {
            SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
            this.patternPermissionMapping.put(sysUser.getSubsysCode(), patternPermissionMapping);
        }
    }

}
