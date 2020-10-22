package cn.ly.app01a;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author LiYun
 * @Date 2020/9/22 20:33
 * @Version 1.0
 */

@WebServlet(name = "MyServlet",urlPatterns = {"/my"})
public class MyServlet implements Servlet {
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletName = getServletConfig().getServletName();
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head>"+"<body>Hello from" + servletName+"</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    @Override
    public void destroy() {

    }
}
