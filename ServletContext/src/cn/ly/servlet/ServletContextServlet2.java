package cn.ly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/12 20:22
 * @Version 1.0
 */
@WebServlet(name = "ServletContextServlet2",urlPatterns = {"/context2"})
public class ServletContextServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletConfig().getServletContext();
        System.out.println(sc.getAttribute("str"));
    }
}
