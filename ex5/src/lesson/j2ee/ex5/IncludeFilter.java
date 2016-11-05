package lesson.j2ee.ex5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Banixc on 2016/11/5.
 */
public class IncludeFilter implements Filter {

    private FilterConfig config = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletResponse newResponse = servletResponse;
        if (servletRequest instanceof HttpServletRequest) {
            newResponse = new CharResponseWrapper(
                    (HttpServletResponse) servletResponse);
        }
        // 执行doFilter方法，注意此处响应对象已经变化
        filterChain.doFilter(servletRequest, newResponse);

        //以下执行响应过滤
        if (newResponse instanceof CharResponseWrapper) {

            String text = newResponse.toString();
            if (text != null) {
                text = "This is an included section!" + text;
                // 将输出的内容传给真正的输出流返回客户端
                servletResponse.getWriter().write(text);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
