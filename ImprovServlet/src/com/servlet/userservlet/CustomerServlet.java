package com.servlet.userservlet;

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
 * @Date 2020/10/18 18:00
 * @Version 1.0
 */
@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
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

    private void queryEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行查询员工的方法...");
        response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>查询员工的方法</h1>");
        pw.flush();
        pw.close();
    }

    private void addEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行新增员工的方法！！！");
        response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>执行了新增员工的方法。。。</h1>");
        pw.flush();
        pw.close();
    }

    private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行删除员工的方法...");
        response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>删除员工的方法</h1>");
        pw.flush();
        pw.close();
    }

    private void queryEmpList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行查询所有员工的方法...");
        response.setContentType("text/html;charset=utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>查询所有员工的方法</h1>");
        pw.flush();
        pw.close();
    }
}
