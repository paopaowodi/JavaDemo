package cn.ly.test;

import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/9/14 19:22
 * resultSet
 */
public class Demo03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root","111");

            String sql = "select * from t_user where id > ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,300);

            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"---"+rs.getString(3));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
    }
}
