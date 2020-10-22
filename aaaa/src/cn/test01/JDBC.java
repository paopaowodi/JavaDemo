package cn.test01;

import java.nio.channels.ClosedSelectorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Author LiYun
 * @Date 2020/9/15 21:26
 * @Version 1.0
 */
public class JDBC {
    public static void main(String[] args) throws SQLException {
        add();
//        delete();
        updata();

    }

    public static void add() {
        Connection conn = JDBCUtils.getConn();
        PreparedStatement ps = null;
        Date date = new Date();

        try {
            ps = conn.prepareStatement("insert into user (username,password,createtime) values (?,?,?)");
            ps.setObject(1, "李生");
            ps.setObject(2, "111");
            ps.setObject(3, date);

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
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

    public static void delete() {
        Connection conn = JDBCUtils.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("delete from user where user.username = '李生' ");
            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void updata() throws SQLException {
        Connection conn = JDBCUtils.getConn();

        PreparedStatement ps = conn.prepareStatement("update user set user.username = '周冷' where user_id = 7 ");
        ps.executeUpdate();

        ps.close();
        conn.close();

    }
}