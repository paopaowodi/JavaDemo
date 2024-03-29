package cn.ly.app01a;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author LiYun
 * @Date 2020/9/22 20:53
 * @Version 1.0
 */

@WebServlet(name = "ServletConfigDemoServlet",urlPatterns = {"/servletConfigDemo"},
        initParams = {
              @WebInitParam(name = "admin", value = "Harry Taciak"),
              @WebInitParam(name = "email",value = "admin@example.com")
        }
      )
public class ServletConfigDemoServlet implements Servlet {

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
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head><body>"+"Admin:"+admin+"<br/>Email:"+email+
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "ServletConfig demo";
    }

    @Override
    public void destroy() {

    }
}
