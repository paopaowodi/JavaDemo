package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/19 20:02
 * @Version 1.0
 */
@WebFilter("/*") //访问所有资源之前，都会执行该过滤器
public class FilterDemo01 implements Filter {

    /*
    * 在服务器启动后，会创建filter对象，然后调用init方法，执行一次 加载资源
    *
    * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    /*
    * 每一次请求被拦截资源时，会执行多次
    *
    * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo01被执行了");

        //f放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
    /*
    * 在服务器关闭后，filter对象被销毁，如果服务器是正常关闭，则会执行destroy方法 释放资源
    * 执行一次
    * */
    @Override
    public void destroy() {

    }
}
