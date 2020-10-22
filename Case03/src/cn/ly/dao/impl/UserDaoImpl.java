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
 * @Date 2020/10/18 18:15
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
            String sql = "select * from table";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                User u = new User();
                u.setName(rs.getString("name"));
                u.setId(rs.getInt("id"));
                u.setPassword(rs.getString("password"));

                users.add(u);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,conn);
        }


        return users;
    }

}
