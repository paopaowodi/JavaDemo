package cn.ly.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类 使用Durid连接池
 */
public class JDBCUtils {

    static Properties pros = null; //帮助读取资源文件信息

    static{ //加载JDBCUtil类的时候调用
        pros = new Properties();

        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties"));

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
