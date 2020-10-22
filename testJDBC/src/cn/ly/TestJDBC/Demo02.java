package cn.ly.TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author LiYun
 * @Date 2020/8/13 17:21
 * 测试Statement接口的用法，执行SQL语句，以及SQL注入问题
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部其实包含了Socket对象，是一个远程的连接。比较耗时！
            // 这是Connection对象管理的一个要点！)
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root","111");
            Statement stmt = conn.createStatement();
            String sql = "insert into t_user (userName,pwd,regTime) values ('粉兔子',12321,now())";
            stmt.execute(sql);



        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}


















