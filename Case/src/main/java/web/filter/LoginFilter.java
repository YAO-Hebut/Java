package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //0.强制转换 servletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源路径，注意要排除掉验证码/fonts/js/css等资源
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/") || uri.contains("/checkCode")) {
            //包含:用户就是想登录，因此放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //不包含，需要验证用户是否已登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //已经登陆了,放行
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //还没有登陆，跳转页面到login.jsp
                request.setAttribute("login_msg", "尚未登陆，请先登录");
                request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
