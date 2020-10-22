package cn.itcast.web.listener; /**
 * @Author LiYun
 * @Date 2020/10/20 20:36
 * @Version 1.0
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ContextLoaderListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public ContextLoaderListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        //加载资源文件
        //1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        //2.加载资源文件
        servletContext.getInitParameter()
        System.out.println("ServletContext对象被创建了。。。");
    }

    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("ServletContext对象被销毁了。。。");
    }

}
