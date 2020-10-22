package cn.ly.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Date;

/**
 * @Author LiYun
 * @Date 2020/9/21 21:57
 */
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("My First Web Project");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
