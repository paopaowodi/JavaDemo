package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/15 22:38
 * @Version 1.0
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        //2.将List存入request域
        req.setAttribute("users",users);
        //3.转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
