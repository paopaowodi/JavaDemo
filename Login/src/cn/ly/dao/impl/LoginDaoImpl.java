package cn.ly.dao.impl;

import cn.ly.dao.LoginDao;
import cn.ly.pojo.User;

import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/9/29 20:02
 * @Version 1.0
 */
public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        //声明数据存储对象
        User u = null;
        try{
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3g?serverTimezone=GMT",
                    "root","111");
            //创建Sql命令
            String sql = "select * from t_user where uname=? and pwd = ?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setObject(1,uname);
            ps.setObject(2,pwd);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
            //关闭资源
            //返回

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        return u;
    }
    //根据UID获取用户信息
    @Override
    public User checkUidDao(String uid) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        //声明数据存储对象
        User u = null;
        try{
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3g?serverTimezone=GMT",
                    "root","111");
            //创建Sql命令
            String sql = "select * from t_user where uid = ?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setObject(1,uid);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
            //关闭资源
            //返回

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        return u;
    }
}
