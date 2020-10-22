package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/10/15 21:20
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

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
                u.setName(rs.getString("name"));
                u.setAddress(rs.getString("address"));
                u.setAge(rs.getInt("age"));
                u.setEmail(rs.getString("email"));
                u.setGender(rs.getString("gender"));
                u.setId(rs.getInt("id"));
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
    public User findUserByNameAndPassword(String username,String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = new User();

        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "select * from user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,username);
            ps.setObject(2,password);
            rs = ps.executeQuery();

            while(rs.next()){
                u.setName(rs.getString("name"));
                u.setAddress(rs.getString("address"));
                u.setAge(rs.getInt("age"));
                u.setEmail(rs.getString("email"));
                u.setGender(rs.getString("gender"));
                u.setId(rs.getInt("id"));
                u.setQq(rs.getString("qq"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }


        return u;
    }

    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
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
    public void delete(int parseInt) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "delete from user where id = " + parseInt;
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }

    }

    @Override
    public User findById(int parseInt) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = new User();
        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "select * from user where id = " + parseInt;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

           while(rs.next()){
               u.setName(rs.getString("name"));
               u.setAddress(rs.getString("address"));
               u.setAge(rs.getInt("age"));
               u.setEmail(rs.getString("email"));
               u.setGender(rs.getString("gender"));
               u.setId(rs.getInt("id"));
               u.setQq(rs.getString("qq"));
               u.setUsername(rs.getString("username"));
               u.setPassword(rs.getString("password"));
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }

        return u;
    }

    @Override
    public void update(User u) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getMysqlConn();
            String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
            ps = conn.prepareStatement(sql);

            ps.setObject(1,u.getName());
            ps.setObject(2,u.getGender());
            ps.setObject(3,u.getAge());
            ps.setObject(4,u.getAddress());
            ps.setObject(5,u.getQq());
            ps.setObject(6,u.getEmail());
            ps.setObject(7,u.getId());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(ps,conn);
        }
    }
}
