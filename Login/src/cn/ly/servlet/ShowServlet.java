package cn.ly.servlet;

import cn.ly.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/12 19:48
 * @Version 1.0
 */
@WebServlet(name = "ShowServlet",urlPatterns = {"/show"})
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取
        HttpSession session = req.getSession();

        if(session.getAttribute("user") == null){
            //重定向
            resp.sendRedirect("/cookie");
            return;
        }
        User u = (User)session.getAttribute("user");
        //处理
        //响应
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<table border = '1px' >");
        resp.getWriter().write("<table>");
        resp.getWriter().write("<tr>");
        resp.getWriter().write("<td>用户名</td>");
        resp.getWriter().write("<td>“+u.getUname()+”</td>");
        resp.getWriter().write("</tr>");
        resp.getWriter().write("<tr>");
        resp.getWriter().write("<td>密码</td>");
        resp.getWriter().write("<td>“+u.getPwd()+”</td>");
        resp.getWriter().write("</tr>");
        resp.getWriter().write("</table>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
