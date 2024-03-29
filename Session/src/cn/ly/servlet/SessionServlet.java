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
 * @Date 2020/10/11 21:19
 * @Version 1.0
 */
@WebServlet(name = "SeesionServlet",urlPatterns = {"/ss"})
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = "张三";
        //处理请求信息
            //创建session对象
            HttpSession hs = req.getSession();
            //设置session的存储时间
            //hs.setMaxInactiveInterval(5);
        System.out.println(hs.getId());

            //存储数据
            hs.setAttribute("name",name);
        //响应处理结果
            //直接
        resp.getWriter().write("session");
            //请求转发
            //重定向

    }
}
