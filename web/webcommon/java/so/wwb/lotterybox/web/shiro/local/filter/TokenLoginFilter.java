package so.wwb.lotterybox.web.shiro.local.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.passport.vo.PassportVo;
import org.soul.web.shiro.local.PassportResult;
import so.wwb.lotterybox.model.manager.user.vo.TokenPassportVo;
import so.wwb.lotterybox.web.shiro.local.authc.LocalToken;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.MessageFormat;

/**
 * 专注于开放中心登入请求.
 * @author alvin
 * @date 2017.07.07
 */
public class TokenLoginFilter extends LocalLoginFilter {
    private Log LOG = LogFactory.getLog(TokenLoginFilter.class);
    public static final String DEFAULT_API_LOGIN_URL = "/token.html";
    public static final String DEFAULT_NORMAL_URL = "/index.html";
    private String apiLoginUrl=DEFAULT_API_LOGIN_URL;
    private String normalUrl=DEFAULT_NORMAL_URL;

    /**
     * 设置API请求访问地址.
     * @param apiLoginUrl
     */
    public void setApiLoginUrl(String apiLoginUrl) {
        this.apiLoginUrl = apiLoginUrl;
    }

    @Override
    protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
        boolean isLogin = super.isLoginSubmission(request, response);
        return isLogin||pathsMatch(apiLoginUrl, request);
    }
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return super.isLoginRequest(request, response)||pathsMatch(apiLoginUrl, request);
    }
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Integer entranceId = getEntranceType(request);
        LocalToken token = new LocalToken();
        String aToken=request.getQueryString();
        token.setToken(URLDecoder.decode(aToken));
        token.setPassword("a".toCharArray());   // TODO a ?
        token.setUsername("a");
        token.setHost(getHost(request));
        token._setEntrance(entranceId);
        token.setSiteId(CommonContext.get().getSiteId());
        return token;
    }
    @Override
    protected PassportResult isValidToken(HttpServletRequest request, LocalToken token) {
        PassportResult passportResult=new PassportResult();
        passportResult.setSuccess(true);
        return passportResult;
    }
    @Override
    protected PassportVo generatePassportVo(LocalToken localToken)
    {
        TokenPassportVo passportVo=new TokenPassportVo();
        passportVo.setToken(localToken.getToken());
        return passportVo;
    }
    /**
     * 正常请求错误回复
     * @param request
     * @param response
     * @param passportResult
     * @throws IOException
     */
    protected void normalResponse(HttpServletRequest request, HttpServletResponse response, PassportResult passportResult) throws IOException
    {
        String scheme = request.getHeader("X-Forwarded-Scheme");
        String port = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
        }
        String directPage = MessageFormat.format("{0}://{1}:{2}{3}", scheme, request.getServerName(), port, normalUrl);
        LOG.info("验证失败转正常请求:重定向:{0}",directPage);
        response.sendRedirect(directPage);
    }

    /**
     * API.token请求关闭动态验证.
     * @return
     */
    protected boolean isOpenAuthentication() {
        return false;
    }
}
