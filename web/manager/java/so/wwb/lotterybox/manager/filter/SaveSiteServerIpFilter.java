package so.wwb.lotterybox.manager.filter;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronnie on 18-6-13.
 */
public class SaveSiteServerIpFilter implements Filter {
    private static final Log LOG = LogFactory.getLog(SaveSiteServerIpFilter.class);
    private static final String SITE_TOKEN = "eb1emnnkfz5iqwf3b222953t2cvkxvqd";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     *根据siteId  servers type保存app外网访问ip
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        String token = request.getParameter("token");
        String siteId = request.getParameter("siteId");
        String servers = request.getParameter("servers");
        String type = request.getParameter("type");
//        WebJson webJson = getWebJson(token, Integer.valueOf(siteId), servers, type);
//        response.getWriter().write(JsonTool.toJson(webJson));
        response.flushBuffer();
        response.getWriter().close();
    }

//    private WebJson getWebJson(String token, Integer siteId, String servers, String type) {
//        Map<String,Object> map = new HashMap<>();
//        if (!SITE_TOKEN.equals(token) || StringTool.isBlank(servers)) {
//            map.put("status",false);
//            return new WebJson(map);
//        }
//        SysSiteVo sysSiteVo = new SysSiteVo();
//        sysSiteVo.getSearch().setId(siteId);
//        SysSiteVo vo = ServiceTool.sysSiteService().get(sysSiteVo);
//        if(vo.getResult() == null){
//            map.put("status",false);
//            return new WebJson(map);
//        }
//        SysSite sysSite = vo.getResult();
//        if("app".equals(type)){
//            sysSite.setAppServers(servers);
//        }else{
//            sysSite.setServers(servers);
//        }
//        vo.setProperties(SysSite.PROP_APP_SERVERS, SysSite.PROP_SERVERS);
//        ServiceTool.sysSiteService().updateOnly(vo);
//        Cache.refreshSysSite();
//        map.put("status",true);
//        return new WebJson(map);
//    }


    @Override
    public void destroy() {

    }
}
