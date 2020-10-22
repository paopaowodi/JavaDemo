package cn.ly.TestJDBC;

import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/8/13 17:21
 * 测试 批处理
 */
public class Demo05 {
    public static void main(String[] args)  {
        Connection conn = null;
        Statement st = null;
        ResultSet rs =null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root","111");
            conn.setAutoCommit(false);

            st = conn.createStatement();

            for (int i = 0; i < 20000; i++) {
                st.addBatch("insert into t_user (userName,pwd,regTime) values ('li"+i+"',66666,now())");
            }

            st.executeBatch();
            conn.commit();

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
                    if(st != null){
                    st.close();
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























