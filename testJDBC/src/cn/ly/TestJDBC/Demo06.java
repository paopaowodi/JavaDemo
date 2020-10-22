package cn.ly.TestJDBC;

import java.sql.*;


/**
 * @Author LiYun
 * @Date 2020/8/13 17:21
 * 测试 事务的基本用法和概念
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root", "111");

            conn.setAutoCommit(false); //JDBC默认自动提交事务


            ps1 = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,?)");
            ps1.setObject(1, "小台灯");
            ps1.setObject(2, "111222");
            ps1.setObject(3, new java.sql.Date(System.currentTimeMillis()));
            ps1.execute();
            System.out.println("插入一个用户");

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ps2 = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,?)");
            ps2.setObject(1, "老杨");
            ps2.setObject(2, "111222");
            ps2.setObject(3, new java.sql.Date(System.currentTimeMillis()));
            ps2.execute();

            conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback(); //回滚
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                if (ps1 != null) {
                    ps1.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if (ps2 != null) {
                    ps2.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

























