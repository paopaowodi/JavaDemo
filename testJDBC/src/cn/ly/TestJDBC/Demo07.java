package cn.ly.TestJDBC;

import java.io.*;
import java.sql.*;


/**
 * @Author LiYun
 * @Date 2020/8/13 17:21
 * 测试 CLOB 文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段、将CLOB字段值取出来的操作。
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reader r = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT",
                    "root", "111");
//            ps = conn.prepareStatement("insert into t_user (username,myinfo)values (?,?)");
//            ps.setObject(1,"小瓶几");
//            ps.setClob(2,new FileReader(new File("d:/a.txt"))); //将文本文件直接输入到数据库中
            //将程序的字符串输入到数据库中的CLOB字段中
//            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("这就可以了？".getBytes()))));

            ps = conn.prepareStatement("select * from t_user where  id = ?");

            ps.setObject(1,0014);

            rs = ps.executeQuery();
            while (rs.next()){
                Clob c = rs.getClob("myinfo");
                r = c.getCharacterStream();
                int temp = 0;
                while( (temp = r.read()) != -1){
                    System.out.print((char)temp);
                }
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback(); //回滚
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            if(r != null){
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

























