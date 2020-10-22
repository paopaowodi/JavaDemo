package cn.ly.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LiYun
 * @Date 2020/9/15 21:09
 * @Version 1.0
 */
public class Demo03 {
    public static void main(String[] args) {
        test02();
    }
    public static void test01(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Emp emp = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=GMT"
                    ,"root","111");

            ps = conn.prepareStatement("select empname,salary,age from emp where id = ? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"-->"+rs.getDouble(2)+"--->"+rs.getInt(3));
                emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println(emp.getEmpname()+"-"+emp.getSalary()+'-'+emp.getAge());
    }

    public  static void test02(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=GMT"
                    ,"root","111");

            ps = conn.prepareStatement("select empname,salary,age from emp where id > ? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
                list.add(emp);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        for(Emp emp : list){
            System.out.println(emp.getEmpname()+"-"+emp.getSalary()+'-'+emp.getAge());
        }
    }
}
