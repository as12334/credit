package so.wwb.lotterybox.manager.filter;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ronnie on 18-6-13.
 */
public class CheckDomainIpFilter implements Filter {
    private static final Log LOG = LogFactory.getLog(CheckDomainIpFilter.class);
    private static final String SITE_TOKEN = "eb1emnnkfz5iqwf3b222953t2cvkxvqd";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     * 根据域名和ip check当前时候域名ip 状态看是否可以正常使用
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        String token = request.getParameter("token");
        String domain = request.getParameter("domain");
        String ip = request.getParameter("ip");
//        WebJson webJson = checkDomainIpStatus(domain, ip, token);
//        response.getWriter().write(JsonTool.toJson(webJson));
        response.flushBuffer();
        response.getWriter().close();
    }

//    private WebJson checkDomainIpStatus(String domain, String ip, String token) {
//        Map<String,Object> map = new HashMap<>();
//        if (!SITE_TOKEN.equals(token) || StringTool.isBlank(domain) || StringTool.isBlank(ip)) {
//            map.put("status", CodeEnum.PARAM_ERROR.getCode());
//            return new WebJson(map);
//        }
//        SysDomainVo sysDomainVo = new SysDomainVo();
//        sysDomainVo.getSearch().setDomain(domain);
//        sysDomainVo = ServiceTool.sysDomainService().search(sysDomainVo);
//        if (sysDomainVo.getResult() == null){
//            map.put("status",CodeEnum.OTHER_ERROR.getCode());
//            return new WebJson(map);
//        }
//        SysSiteVo sysSiteVo = new SysSiteVo();
//        sysSiteVo.getSearch().setId(sysDomainVo.getResult().getId());
//        sysSiteVo = ServiceTool.sysSiteService().get(sysSiteVo);
//        if(sysSiteVo.getResult() == null){
//            map.put("status",CodeEnum.OTHER_ERROR.getCode());
//            return new WebJson(map);
//        }
//        map.put("domain",sysDomainVo);
//        map.put("site",sysSiteVo);
//        return new WebJson(map);
//    }


    @Override
    public void destroy() {

    }
}
