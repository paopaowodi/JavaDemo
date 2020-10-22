package cn.ly.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author LiYun
 * @Date 2020/9/15 22:11
 * @Version 1.0
 */
public class testUtils {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getMysqlConn();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into emp (empname,salary,age) values (?,?,?)");
            ps.setObject(1,"李声");
            ps.setObject(2,13000);
            ps.setObject(3,19);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
