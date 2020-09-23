package so.wwb.lotterybox.web.filter;

import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.string.I18nTool;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/javascript");
        response.getWriter().print("var message =" + I18nTool.getScriptMessageObject(CommonContext.get().getLocale().toString()) + ";");
        response.getWriter().close();
    }

    @Override
    public void destroy() {

    }
}