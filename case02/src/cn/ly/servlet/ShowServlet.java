package cn.ly.servlet;

import cn.ly.domain.User;
import cn.ly.service.UserService;
import cn.ly.service.impl.UserServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 9:34
 * @Version 1.0
 */
@WebServlet(urlPatterns = {"/showServlet"})
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService service = new UserServiceIml();
        List<User> list = service.findAll();
        request.setAttribute("user",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
