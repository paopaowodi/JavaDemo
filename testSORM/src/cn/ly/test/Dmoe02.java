package cn.ly.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LiYun
 * @Date 2020/9/15 20:46
 * @Version 1.0
 */
public class Dmoe02 {
    //用Map存一行数据
    public static void test01(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Object> row = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=GMT"
                    ,"root","111");

            ps = conn.prepareStatement("select empname,salary,age from emp where id = ? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"-->"+rs.getDouble(2)+"--->"+rs.getInt(3));
                row.put("empname",rs.getObject(1));
                row.put("salary",rs.getObject(2));
                row.put("age",rs.getObject(3));
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

        for(String key : row.keySet()){
            System.out.print(key + "---"+row.get(key)+"\t");
        }
    }

    //用
    public static void test02(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=GMT"
                    ,"root","111");

            ps = conn.prepareStatement("select empname,salary,age from emp where id > ? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString(1)+"-->"+rs.getDouble(2)+"--->"+rs.getInt(3));
                Map<String,Object> row = new HashMap<>();
                row.put("empname",rs.getObject(1));
                row.put("salary",rs.getObject(2));
                row.put("age",rs.getObject(3));

                list.add(row);
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

        for(Map<String,Object> row: list){
            for(String key : row.keySet()){
                System.out.print(key + "---"+row.get(key)+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        test02();
    }
}
