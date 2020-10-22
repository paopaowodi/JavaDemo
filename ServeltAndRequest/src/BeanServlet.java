import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author LiYun
 * @Date 2020/10/18 16:27
 * @Version 1.0
 */
@WebServlet(urlPatterns = {"/*.do"})
public class BeanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI(); //获得请求的URI信息
        //截取其中的方法名
        String methodName = url.substring(url.indexOf("/") + 1, url.lastIndexOf("."));
        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);

            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void addEmp(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("执行新增员工的方法");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>新增员工的方法</h1>");
        writer.flush();
        writer.close();
    }

    private void deletEmp(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("执行删除员工的方法");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>删除员工的方法</h1>");
        writer.flush();
        writer.close();
    }

    private void queryEmpList(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("执行查询员工的方法");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>查询员工的方法</h1>");
        writer.flush();
        writer.close();
    }
}
