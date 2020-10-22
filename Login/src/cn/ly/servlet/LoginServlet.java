package cn.ly.servlet;

import cn.ly.pojo.User;
import cn.ly.service.LoginService;
import cn.ly.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/9/29 19:45
 * //解决主页面用户名显示为Null的问题：
 * 原因：
 * 因为用户登录成功后使用重定向显示主页面，两次请求，而用户信息在第一次请求中，
 * 第二次请求中没有用户数据，所以显示为Null
 * 解决：
 *  使用session
 *
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置相应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname+":"+pwd);
        //处理请求信息
            //获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname,pwd);
        System.out.println(u);
        //相应处理结果
        if(u != null){
            //创建Cookie信息实现三天免登录
            Cookie c  = new Cookie("uid",u.getUid()+"");
            c.setMaxAge(3*24*3600);
            c.setPath("cookie");
            resp.addCookie(c);
            // resp.getWriter().write("登陆成功");
            //请求转发
                //req.getRequestDispatcher("main").forward(req,resp);

            //***将数据存储在session对象中
            HttpSession session = req.getSession();
            session.setAttribute("user",u);

            //重定向
            resp.sendRedirect("main");
            return;
        }else{
            //resp.getWriter().write("登陆失败");
            //使用request对象实现不同Servelt的数据流转
            req.setAttribute("str","用户名或密码错误");

            //使用请求转发
            req.getRequestDispatcher("page").forward(req,resp);
            return ;
        }
    }
}
