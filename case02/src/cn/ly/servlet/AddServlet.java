package cn.ly.servlet;

import cn.ly.domain.User;
import cn.ly.service.impl.UserServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/18 10:37
 * @Version 1.0
 */
@WebServlet(urlPatterns = {"/addServlet"})
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceIml service = new UserServiceIml();
        User u = new User();
        u.setName(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        service.addUser(u);
        request.getRequestDispatcher("showServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
