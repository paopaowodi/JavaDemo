package cn.ly.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/9/15 20:14
 * 测试使用Object[]封装一条记录
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=GMT"
                    ,"root","111");

            ps = conn.prepareStatement("select empname,salary,age from emp where id = ? ");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                Object[] objs = new Object[3];   //一个object数组封装了一条消息记录
//              System.out.println(rs.getString(1)+"-->"+rs.getDouble(2)+"--->"+rs.getInt(3));
                objs[0] = rs.getString(1);
                objs[1] = rs.getDouble(2);
                objs[2] = rs.getInt(3);

                list.add(objs);
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

        for(Object[] obj:list){
            System.out.println(""+obj[0]+obj[1]+obj[2]);
        }

    }
}
