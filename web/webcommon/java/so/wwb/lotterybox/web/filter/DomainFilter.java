package so.wwb.lotterybox.web.filter;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.iservice.common.IDomainCacheResolver;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import so.wwb.lotterybox.context.LotteryCommonContext;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.sys.DomainPageUrlEnum;
import so.wwb.lotterybox.model.enums.sys.DomainTypeEnum;
import so.wwb.lotterybox.model.enums.sys.SysSiteStatusEnum;
import so.wwb.lotterybox.model.enums.sys.SystemEnum;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.web.tools.CommonTool;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

/**
 * @author:wilson
 * @function:domain filter for manager and hall
 */
public class DomainFilter implements Filter {
    private static final Log LOG = LogFactory.getLog(DomainFilter.class);
    private List<String> listUrl = new ArrayList();
    private IDomainCacheResolver domainCacheResolver;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String strRequestURI = request.getRequestURI();
        StringBuffer strRequestURL = request.getRequestURL();
        String strServerName = request.getServerName();
        String strContextPath = request.getContextPath();

        ErrorCodeEnum errorCodeEnum = null;
        if (StringTool.isBlank(request.getHeader("User-Agent")) && !strRequestURI.contains(DomainPageUrlEnum.PAY.getCode() + "/")) {
            errorCodeEnum = ErrorCodeEnum.SC_PRIVILEGE;
            this.HandleError(response, request, errorCodeEnum, strServerName, strContextPath);
            return;
        }

        LOG.info("access URI: {0}", strRequestURI);

        if (strRequestURI.toLowerCase().startsWith(strContextPath + "/errors")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (strRequestURI.toLowerCase().startsWith(strContextPath + DomainPageUrlEnum.DETECTION.getCode().toLowerCase())) {
            filterChain.doFilter(request, response);
            return;
        }

        BaseObjectVo objectVo = domainCacheResolver.fromCache(request);
        if (null == objectVo) {
            errorCodeEnum = ErrorCodeEnum.SC_SERVICE_BUSY;
            this.HandleError(response, request, errorCodeEnum, strServerName, strContextPath);
            return;
        }

        VSysSiteDomain sysSiteDomain = (VSysSiteDomain) objectVo.getResult();
        if (null == sysSiteDomain) {
            errorCodeEnum = ErrorCodeEnum.SC_DOMAIN_NO_EXIST;
            this.HandleError(response, request, errorCodeEnum, strServerName, strContextPath);
            return;
        }

        Object userObject=SessionManagerCommon.getAttribute(SessionKey.S_USER);
        //Object userObject=SessionCommonTool.getSessionEx(SessionCommonTool.SESSION_CM_SYS_USER);
        if (null != userObject && !"".equals(userObject.toString())) {
            SysUser sysUser=(SysUser)userObject;
            Integer ownerId = (null == sysUser.getOwnerId()) ? 0 : sysUser.getOwnerId();
            if (!ownerId.equals(sysSiteDomain.getSiteUserId())) {
                errorCodeEnum = ErrorCodeEnum.SC_FORBIDDEN;
                this.HandleError(response, request, errorCodeEnum, strServerName, strContextPath);
                return;
            }
        }

        //region -- pending --
        if (listUrl.contains(strRequestURI.replace(strContextPath, ""))) {
            filterChain.doFilter(request, response);
            return;
        }
        //endregion

        //TODO dick 添加DomainTypeEnum.MERCHANT.getCode()
        if (DomainTypeEnum.MANAGER.getCode().equals(sysSiteDomain.getType()) || DomainTypeEnum.MERCHANT.getCode().equals(sysSiteDomain.getType())) {
            if (!strRequestURI.startsWith(SystemEnum.MANAGER.getCode())) {
                String strUrl = SystemEnum.MANAGER.getCode() + request.getRequestURI();
                response.sendRedirect(strUrl);
                return;
            }

            String strPath = MessageFormat.format("{0}://{1}:{2}{3}", CommonTool.getHttp(request), strServerName, CommonTool.getPort(request), strContextPath);
            if (!strPath.endsWith("/")) strPath = strPath + "/";
            if (strPath.equals(strRequestURL.toString())) {
                strPath = MessageFormat.format("{0}://{1}:{2}{3}", CommonTool.getHttp(request), strServerName, CommonTool.getPort(request), DomainPageUrlEnum.MANAGER.getCode());
                response.sendRedirect(strPath);
                return;
            }
        } else if (DomainTypeEnum.HALL.getCode().equals(sysSiteDomain.getType())) {
            String strPath = MessageFormat.format("{0}://{1}:{2}{3}", CommonTool.getHttp(request), strServerName, CommonTool.getPort(request), strContextPath);
            if (!strPath.endsWith("/")) strPath = strPath + "/";
            if (strPath.equals(strRequestURL.toString())) {
                strPath = MessageFormat.format("{0}://{1}:{2}{3}", CommonTool.getHttp(request), strServerName, CommonTool.getPort(request), DomainPageUrlEnum.HALL.getCode());
                response.sendRedirect(strPath);
                return;
            }
        }
        // 判断是否是支付域名，如果是支付域名，只允许访问onlinePay请上下文的请求
        else if(DomainTypeEnum.PAY.getCode().equals(sysSiteDomain.getType())
                && !strRequestURI.contains(DomainPageUrlEnum.PAY.getCode() + "/")){
            errorCodeEnum = ErrorCodeEnum.SC_FORBIDDEN;
            this.HandleError(response, request, errorCodeEnum, strServerName, strContextPath);
            return;
        }

        if (SubSysCodeEnum.BOSS.equals(LotteryCommonContext.get().getSubSysCodeEnum())) {
            sysSiteDomain.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
        } else if (domainCacheResolver.isSiteDisabled(objectVo)) {
            errorCodeEnum = ErrorCodeEnum.SC_SITE_MAINTAIN;
        } else if (domainCacheResolver.isDomainTempAndTimeOut(objectVo)) {
            errorCodeEnum = ErrorCodeEnum.SC_DOMAIN_TEMP_TIMEOUT;
        }

        if (null == errorCodeEnum) {
            filterChain.doFilter(request, response);
        }
        else {
            this.HandleError(response, request, errorCodeEnum, strServerName, strContextPath);
        }
    }

    private void HandleError(HttpServletResponse response, HttpServletRequest request, ErrorCodeEnum errorCodeEnum, String strServerName, String strContextPath) {
        LOG.error("domain name:[{2}],error code:[{0}],error desc:[{1}]", errorCodeEnum.getCode(), errorCodeEnum.getTrans(), strServerName);
        Integer code = Integer.parseInt(errorCodeEnum.getCode());
        response.setStatus(code);
        response.setHeader(CUSTOM_HEADER_STATUS, code.toString());
        //CommonTool.responseWriteWeb(response, errorCodeEnum);
        if (StringTool.isNotBlank(errorCodeEnum.getUrl()) && !ServletTool.isAjaxRequest(request)) {
            //CommonCtxLoaderListener.ContextPath
            String directPage = MessageFormat.format("{0}://{1}:{2}{3}", CommonTool.getHttp(request), strServerName, CommonTool.getPort(request), strContextPath + errorCodeEnum.getUrl() + ".html");
            try {
                response.sendRedirect(directPage);
            } catch (IOException e) {
                LOG.error("Handle Error-end Redirect-IO Exception:", e);
            }
        }
    }

    public void setDomainCacheResolver(IDomainCacheResolver domainCacheResolver) {
        this.domainCacheResolver = domainCacheResolver;
    }

    public void setFilterUrl(String filterUrl) {
        String[] utlStr = StringTool.split(filterUrl, ",");
        for (String str : utlStr) {
            listUrl.add(str);
        }
    }

    @Override
    public void destroy() {

    }
}