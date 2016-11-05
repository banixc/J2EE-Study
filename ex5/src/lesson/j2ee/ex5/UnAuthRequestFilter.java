package lesson.j2ee.ex5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Banixc on 2016/10/31.
 */
public class UnAuthRequestFilter implements Filter{

    private FilterConfig config = null;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpreq = (HttpServletRequest) request;
        HttpServletResponse httprep = (HttpServletResponse) response;

        String redirectPath = httpreq.getContextPath()
                + config.getInitParameter("redirectPath");
        String includeStrings = config.getInitParameter("includeStrings");
        String ignoreString = config.getInitParameter("ignoreStrings");
        String disableFilter = config.getInitParameter("disableFilter");

        String[] includeList = includeStrings.split(";");
        String[] ignoreList = ignoreString.split(";");

        //若请求方法不为GET则直接跳过
        if(!httpreq.getMethod().equalsIgnoreCase("GET")) {
            filterChain.doFilter(request, response);
            return;
        }

        //若关闭该过滤器则不再响应
        if (disableFilter.toUpperCase().equals("Y")) {
            filterChain.doFilter(request, response);
            return;
        }

        //若当前URL在忽略列表中则跳过
        boolean flag = false;
        for (String anIncludeList : ignoreList) {
            if (httpreq.getRequestURI().contains(anIncludeList)) {
                flag = true;
                break;
            }
        }
        if(flag) {
            filterChain.doFilter(request, response);
            return;
        }

        //若当前URL被过滤则重定向
        for (String anIncludeList : includeList) {
            if (httpreq.getRequestURI().contains(anIncludeList)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            httprep.sendRedirect(redirectPath);
        } else {
            filterChain.doFilter(request, response);
        }

    }

    public void destroy() {
        this.config = null;

    }
}
