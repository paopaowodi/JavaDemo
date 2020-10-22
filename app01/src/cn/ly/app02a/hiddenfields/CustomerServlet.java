package cn.ly.app02a.hiddenfields;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/9/25 21:05
 * @Version 1.0
 */

@WebServlet( name ="CustomerServlet",urlPatterns = {"/customer","/editCustomer","/updateCustomer"})
public class CustomerServlet  extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private List<Customer> customers = new ArrayList<>();

}
