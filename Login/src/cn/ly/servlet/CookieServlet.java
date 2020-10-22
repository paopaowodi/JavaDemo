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
 * @Date 2020/10/11 20:18
 * Cookie信息校验
 *  判断请求中是否携带正确的Cookie信息
 *  如果有则校验Cookie信息是否正确
 *      如果校验正确则直接响应 主页面 给用户
 *      不正确则响应登陆页面给用户
 *  没有则重定向登陆页面
 */
@WebServlet(name = "CookieServlet",urlPatterns = {"/cookie"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置相应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            String uid = "";
            for(Cookie c:cookies){
                if("uid".equals(c.getName())){
                    uid = c.getValue();
                }
            }
            if("".equals(uid)){
                req.getRequestDispatcher("page").forward(req,resp);
                return;
            }else{
                //校验UID用户信息
                //获取业务层对象
                LoginService ls = new LoginServiceImpl();
                User u = ls.checkLoginService(uid);
                if(u != null){
                    //将用户数据存储到session对象中
                    HttpSession session = req.getSession();
                    session.setAttribute("user",u);
                    //重定向
                    resp.sendRedirect("main");
                    return;
                }else{
                    req.getRequestDispatcher("page").forward(req,resp);
                    return;
                }
            }
        }else{
            req.getRequestDispatcher("page").forward(req,resp);
        }
        //处理
        //响应

    }
}
