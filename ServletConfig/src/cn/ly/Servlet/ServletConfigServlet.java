package cn.ly.Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/13 20:04
 * @Version 1.0
 */
@WebServlet(name = "ServletConfigServlet",urlPatterns = {"/sg"})
public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletConfig对象
        ServletConfig sc = this.getServletConfig();
        String initParameter = sc.getInitParameter("");
    }
}
