package cn.ly.servlet;

import cn.ly.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/11 18:47
 * @Version 1.0
 */
@WebServlet(name = "MainServlet",urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置相应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取session
            User u = (User)req.getSession().getAttribute("user");
        //处理
        //响应
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+u.getUname()+"访问</h3>");
        resp.getWriter().write("<hr>");
        resp.getWriter().write("<form action = 'show' method = 'get'>");
        resp.getWriter().write("<input type = 'button' value = '查看个人信息'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
