package cn.ly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiYun
 * @Date 2020/10/12 20:10
 * @Version 1.0
 */
@WebServlet(name = "ServeltContextServlet",urlPatterns = {"/context"})
public class ServeltContextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
            //1.
        ServletContext sc = this.getServletContext();
            //2.
        ServletContext sc2 = this.getServletConfig().getServletContext();
            //3.
        ServletContext sc3 = req.getSession().getServletContext();
        System.out.println(sc == sc2);
        System.out.println(sc == sc3);
        //使用ServletContext对象完成数据共享
        //数据存储
        sc.setAttribute("str","ServletContext对象学习");
    }
}
