package cn.test01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author LiYun
 * @Date 2020/9/15 21:33
 * @Version 1.0
 */
public class JDBCUtils {
    static Properties pros = null;

    static{
        pros = new Properties();

        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try {
            Class.forName(pros.getProperty("driver"));
            return DriverManager.getConnection(pros.getProperty("url"),pros.getProperty("user"),pros.getProperty("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps ,Connection conn){

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
}
