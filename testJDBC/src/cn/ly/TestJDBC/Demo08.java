package cn.ly.TestJDBC;

import java.io.*;
import java.sql.*;

/**
 * @Author LiYun
 * @Date 2020/8/24 9:43
 * 测试BLOB 二进制大对象的使用
 */
public class Demo08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT","root","111");

//            ps = conn.prepareStatement("insert into t_user (username,headImg) values (?,?)");
//            ps.setString(1,"保诗");
//
//            ps.setBlob(2,new FileInputStream("d:/picture.png"));
//
//            ps.execute();

            ps = conn.prepareStatement("select  * from t_user where id = ?");
            ps.setObject(1,17);

            rs = ps.executeQuery();
            while(rs.next()){
                Blob b = rs.getBlob("headImg");
                is = b.getBinaryStream();
                os = new FileOutputStream("d:/haha.png");
                int temp = 0;

                while((temp = is.read())!= -1){
                    os.write(temp);
                }
            }

        } catch (SQLException throwables) {
                throwables.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(is != null){
                    is.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if(os != null){
                    os.close();
                }
            }catch (Exception e){
                e.printStackTrace();
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
    }
}
