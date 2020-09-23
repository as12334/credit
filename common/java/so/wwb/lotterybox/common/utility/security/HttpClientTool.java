package so.wwb.lotterybox.common.utility.security;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

public class HttpClientTool {

    private static final Log LOG = LogFactory.getLog(HttpClientTool.class);

    public static String doPut(String url, String params) {
        String res = "";
        try {
            HttpClient httpClient = new HttpClient();
            PutMethod put = new PutMethod(url);
            put.setRequestBody(params);
            put.setRequestHeader(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            put.setRequestHeader("Content-Type","application/json");
            httpClient.executeMethod(put);
            res = put.getResponseBodyAsString();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return res;
    }

}