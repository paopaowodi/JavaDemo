package cn.ly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/12 18:52
 * @Version 1.0
 */
@WebServlet(name = "SessionServlet2",urlPatterns = {"/ss2"})
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("SessionServlet2.service()"+session.getId());
        System.out.println(session.getAttribute("name"));
    }
}
