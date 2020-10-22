package OK;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author LiYun
 * @Date 2020/9/14 0:12
 * @Version 1.0
 */
public class demo01 {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=GMT");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
