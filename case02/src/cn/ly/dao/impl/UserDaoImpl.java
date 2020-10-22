package cn.ly.dao.impl;

import cn.ly.dao.UserDao;
import cn.ly.domain.User;
import cn.ly.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/18 9:28
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
        return list;
    }

    @Override
    public void addUser(User user) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        try {
            String sql = "insert into user(username,password) values (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,user.getName());
            ps.setObject(2,user.getPassword());

            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Override
    public void delUser(int id) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        String sql = "delete from user where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Override
    public User findID(int id) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select from user where id = id";
        try {
            ps = conn.prepareStatement(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }


}
