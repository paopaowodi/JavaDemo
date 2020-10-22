import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author LiYun
 * @Date 2020/10/18 11:12
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3g?serverTimezone=GMT",
                    "root", "111");
            String sql = "insert into user (username,password) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1,"ly");
            ps.setObject(2,"12345");
            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
