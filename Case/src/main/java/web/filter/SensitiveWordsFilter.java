package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private List<String> list = new ArrayList<>();//敏感词汇集合

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            //1.加载文件
            //获取文件真实路径
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/config/SensitiveWords.txt");
            //2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3.将文件的每一行数据加载到list集合中去
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否为getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(servletRequest, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "**");
                            }
                        }
                    }

                    return value;
                }
                return method.invoke(servletRequest, args);
            }

        });

        //2.放行
        filterChain.doFilter(proxy_request, servletResponse);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
