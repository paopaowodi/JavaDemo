package cn.ly.TestJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author LiYun
 * @Date 2020/8/25 16:18
 * 测试使用JDBCUtil工具类来简化JDBC
 */
public class Demo09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();

            ps = conn.prepareStatement("insert into t_user");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
}
