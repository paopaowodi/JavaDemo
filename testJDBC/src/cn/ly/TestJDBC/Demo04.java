package cn.ly.TestJDBC;

import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/8/13 17:21
 * 测试 ResultSet结果集的基本用法
 */
public class Demo04 {
    public static void main(String[] args)  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部其实包含了Socket对象，是一个远程的连接。比较耗时！
            // 这是Connection对象管理的一个要点！)
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root","111");
            String sql = "select id,userName,pwd from t_user where id > ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,2); //把id>2的记录都取出来
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+
                        "---"+rs.getString(3));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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























