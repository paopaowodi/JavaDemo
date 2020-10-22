package cn.ly.TestJDBC;

import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/8/13 17:21
 * 测试PreparedStatement的基本用法
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部其实包含了Socket对象，是一个远程的连接。比较耗时！
            // 这是Connection对象管理的一个要点！)
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root","111");
            String sql = "insert into t_user (userName,pwd,regTime) values(?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            //传参 使用setObject()方法
            ps.setString(1,"雪碧");
            ps.setString(2,"123412");
            ps.setObject(3,new java.sql.Date(System.currentTimeMillis()));

            ps.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}


















