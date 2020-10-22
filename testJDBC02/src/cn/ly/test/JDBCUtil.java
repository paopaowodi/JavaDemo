package cn.ly.test;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author LiYun
 * @Date 2020/8/25 15:49
 * @Version 1.0
 */
public class JDBCUtil {

    static Properties pros = null; //帮助读取资源文件信息

    static{ //加载JDBCUtil类的时候调用
        pros = new Properties();

        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static  Connection getMysqlConn() {
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("mysqlURL"),
                    pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void close (ResultSet rs, Statement ps, Connection conn){

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

        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close ( Statement ps, Connection conn){

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

    public static void close ( Connection conn){


        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
