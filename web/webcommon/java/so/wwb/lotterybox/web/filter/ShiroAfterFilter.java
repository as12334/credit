package so.wwb.lotterybox.web.filter;

import org.soul.commons.init.context.Operator;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.session.SessionKey;
import org.soul.web.log.audit.AuditLogTool;
import so.wwb.lotterybox.context.LotteryCommonContext;
import so.wwb.lotterybox.context.LotteryContextParam;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShiroAfterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        LotteryContextParam contextParam = LotteryCommonContext.get();
        if (contextParam == null) {
            contextParam = new LotteryContextParam();
            LotteryCommonContext.set(contextParam);
        }

        if (SessionManagerCommon.getSwitchSiteId() != null) {
            contextParam.setSwitchSiteId(SessionManagerCommon.getSwitchSiteId());
        }

        SysUserExtend sysUser = SessionManagerCommon.getSysUserExtend();
        if (sysUser != null) {
            contextParam.setSessionId(request.getSession().getId());
            contextParam.setUserId(sysUser.getId());
            contextParam.setUserOwnerId(sysUser.getOwnerId());
            contextParam.setUserType(sysUser.getUserType());
            contextParam.setSubsysCode(sysUser.getSubsysCode());
            contextParam.setOperator(AuditLogTool.getOperator(request, sysUser));
            contextParam.setPayUri(sysUser.getPayUri());
            contextParam.setHallUri(sysUser.getHallUri());

            // TODO user
//            if(null!=sysUser.getMode() || !"".equals(sysUser.getMode())) {
//                ModeEnum modeEum = EnumTool.enumOf(ModeEnum.class, sysUser.getMode());
//                contextParam.setUserMode(modeEum);
//            }
        }

        Object isIgnoreAudit = SessionManagerCommon.getAttribute(SessionKey.S_IS_IGNORE_AUDIT);
        if (isIgnoreAudit != null) {
            contextParam.setIsIgnoreAudit((Boolean) isIgnoreAudit);
        }
        if (SessionManagerCommon.getAttribute(SessionKey.S_USER_OWN_SITES) != null)
            contextParam.setSiteIds((List<Integer>) SessionManagerCommon.getAttribute(SessionKey.S_USER_OWN_SITES));
        if (contextParam.getOperator() == null) {
            contextParam.setOperator(new Operator());
            contextParam.getOperator().setOperateIp(IpTool.ipv4StringToLong(ServletTool.getIpAddr(request)));
        }

        if (SubSysCodeEnum.MERCHANT.getCode().equalsIgnoreCase(contextParam.getSiteSubsysCode())) {
            setDefaultGroup(contextParam);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private void setDefaultGroup(LotteryContextParam contextParam) {

    }
}