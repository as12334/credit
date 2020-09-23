package so.wwb.lotterybox.manager.filter;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ronnie on 18-6-13.
 */
public class GetDomainFilter implements Filter {
    private static final Log LOG = LogFactory.getLog(GetDomainFilter.class);
    private static final String DOMAIN_TOKEN = "ux3zkfhdrs2gix8ddu2j1gozgqecmebz";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     *获取所有可以正常使用的的域名
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        String token = request.getParameter("token");
//        WebJson domain = getDomain(token);
//        response.getWriter().write(JsonTool.toJson(domain.getData()));
        response.flushBuffer();
        response.getWriter().close();
    }

//    private WebJson getDomain(String token) {
//        if (!DOMAIN_TOKEN.equals(token)) {
//            return new WebJson(CodeEnum.PARAM_ERROR);
//        }
//
//        Map<String, VSysSiteDomain> map = Cache.getSiteDomain();
//        List<VSysSiteDomain> domains = new ArrayList<>();
//        map.forEach((k, v) -> {
//            if (ResolveStatusEnum.SUCCESS.getCode().equals(v.getResolveStatus())) {
//                domains.add(v);
//            }
//        });
//        Object result = FastJsonTool.includeProperties(domains, VSysSiteDomain.PROP_DOMAIN, VSysSiteDomain.PROP_SITE_SUBSYS_CODE,
//                VSysSiteDomain.PROP_SITE_ID, VSysSiteDomain.PROP_PAGE_URL);
//        return new WebJson(result);
//    }


    @Override
    public void destroy() {

    }
}
