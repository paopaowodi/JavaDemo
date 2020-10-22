package cn.ly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/11 19:30
 * @Version 1.0
 */
@WebServlet(name = "CookieServlet",urlPatterns = {"/cookie"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求编码格式
        req.setCharacterEncoding("utf-8");
        //响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息

        //响应处理结果
            //使用Cookie进行浏览器端口的数据存储
                //创建Cookie对象
                Cookie c = new Cookie("mouse","thinkpad");
                //响应Cookie信息
                resp.addCookie(c);
            //直接
                resp.getWriter().write("Cookie学习");
            //请求转发
            //重定向
    }
}
