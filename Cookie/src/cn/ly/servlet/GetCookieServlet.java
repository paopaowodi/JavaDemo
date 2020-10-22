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
 * @Date 2020/10/11 20:00
 * @Version 1.0
 */
@WebServlet(name = "GetCookieServlet",urlPatterns = {"/gc"})
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置相应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取Cookie信息
            Cookie[] cookies = req.getCookies();
            if(cookies != null){
                for(Cookie c:cookies){
                    String name = c.getName();
                    String value = c.getValue();
                    System.out.println(name+":"+value);
                }
            }
        //获取用户信息
        //处理请求信息
        //响应处理结果
            //直接响应
            //请求转发
            //重定向
    }
}
