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
 * @Date 2020/10/18 19:12
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        String sql = "insert into user values (null,?,?,?,?,?,?,null,null)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,user.getName());
            ps.setObject(2,user.getGender());
            ps.setObject(3,user.getAge());
            ps.setObject(4,user.getAddress());
            ps.setObject(5,user.getQq());
            ps.setObject(6,user.getEmail());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Override
    public List<User> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setGender(rs.getString("gender"));
                u.setAge(rs.getInt("age"));
                u.setAddress(rs.getString("address"));
                u.setEmail(rs.getString("email"));
                u.setQq(rs.getString("qq"));

                users.add(u);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return users;
    }

    @Override
    public void delUser(int id) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        String sql = "delete from user where id = "+id;
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }

    @Override
    public User findUser(int id) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = new User();
        String sql = "select *from user where id = "+id;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setQq(rs.getString("qq"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }

        return user;
    }

    @Override
    public void update(User user) {
        Connection conn = JDBCUtils.getMysqlConn();
        PreparedStatement ps = null;
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,user.getName());
            ps.setObject(2,user.getGender());
            ps.setObject(3,user.getAge());
            ps.setObject(4,user.getAddress());
            ps.setObject(5,user.getQq());
            ps.setObject(6,user.getEmail());
            ps.setObject(7,user.getId());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }

    }
}
