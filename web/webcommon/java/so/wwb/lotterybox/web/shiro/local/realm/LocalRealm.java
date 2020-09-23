package so.wwb.lotterybox.web.shiro.local.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.soul.model.passport.vo.PassportVo;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import org.soul.web.shiro.common.autho.AuthorizationRefresher;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.context.LotteryCommonContext;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.web.shiro.local.authc.LocalToken;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import java.util.HashSet;
import java.util.Set;

public class LocalRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return null;
        }

        SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
        Set<String> permissions = findPermissions(sysUser);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions == null ? new HashSet<String>(0) : permissions);
        return simpleAuthorizationInfo;
    }

    private Set<String> findPermissions(SysUser sysUser) {
        PassportVo passportVo = new PassportVo();
        passportVo.getSearch().setUsername(sysUser.getUsername());
        passportVo.getSearch().setUserType(sysUser.getUserType());
        passportVo.getSearch().setSiteId(sysUser.getSiteId());
        if (LotteryCommonContext.get().getVirtualSiteId() != null)
            passportVo.getSearch().setSiteId(LotteryCommonContext.get().getVirtualSiteId());
        passportVo.getSearch().setSubsysCode(sysUser.getSubsysCode());
        return ServiceTool.passportService().findPermissions(passportVo);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LocalToken localToken = (LocalToken) token;
        if(localToken.getAuthenticationException()!=null){
            throw localToken.getAuthenticationException();
        }else {
            String password = new String(localToken.getPassword());
            return new SimpleAuthenticationInfo(localToken.getPrincipal(), password, getName());
        }
    }

    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        //warning: final key would be: auth:z:1:21:water:11848
        return AuthorizationRefresher.AUTHORIZATION + CacheKey.CACHE_KEY_SEPERATOR + principals.getPrimaryPrincipal().toString();
    }
}
