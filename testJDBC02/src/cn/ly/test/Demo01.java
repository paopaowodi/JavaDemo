package cn.ly.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author LiYun
 * @Date 2020/9/14 18:36
 * 测试和数据库建立连接
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root","111");


            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
