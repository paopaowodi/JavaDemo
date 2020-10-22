package cn.ly.test;

import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/9/14 19:03
 * 测试注入问题
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT","root","111");

            String sql = "insert  into t_user (username,pwd) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"季三");
            ps.setString(2,"12333");

            System.out.println("插入一行记录");
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
