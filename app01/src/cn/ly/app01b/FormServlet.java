package cn.ly.app01b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author LiYun
 * @Date 2020/9/22 21:51
 * @Version 1.0
 */
@WebServlet(name = "FormServlet",urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 54L;
    private static final String TITLE = "Order Form";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + TITLE + "</title></head>");
        writer.println("<body><h1>" + TITLE + "</h1>");
        writer.println("<form method='post'>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Name:</td>");
        writer.println("<td><input name='name'/></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Address:</td>");
        writer.println("<td><textarea name='address' "
                + "cols='40' rows='5'></textarea></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Country:</td>");
        writer.println("<td><select name='country'>");
        writer.println("<option>United States</option>");
        writer.println("<option>Canada</option>");
        writer.println("</select></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Delivery Method:</td>");
        writer.println("<td><input type='radio' " +
                "name='deliveryMethod'"
                + " value='First Class'/>First Class");
        writer.println("<input type='radio' " +
                "name='deliveryMethod' "
                + "value='Second Class'/>Second Class</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Shipping Instructions:</td>");
        writer.println("<td><textarea name='instruction' "
                + "cols='40' rows='5'></textarea></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>&nbsp;</td>");
        writer.println("<td><textarea name='instruction' "
                + "cols='40' rows='5'></textarea></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Please send me the latest " +
                "product catalog:</td>");writer.println("<td><input type='checkbox' " +
                "name='catalogRequest'/></td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>&nbsp;</td>");
        writer.println("<td><input type='reset'/>" +
                "<input type='submit'/></td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + TITLE + "</title></head>");
        writer.println("</head>");
        writer.println("<body><h1>" + TITLE + "</h1>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Name:</td>");
        writer.println("<td>" + req.getParameter("name")
                + "</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Address:</td>");
        writer.println("<td>" + req.getParameter("address")
                + "</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Country:</td>");
        writer.println("<td>" + req.getParameter("country")
                + "</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Shipping Instructions:</td>");
        writer.println("<td>");
        String[] instructions = req.getParameterValues("instruction");
        if(instructions != null){
            for(String instruction:instructions){
                writer.println(instruction+"<br/>");
            }
        }
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Delivery Method:</td>");
        writer.println("<td>"+req.getParameter("deliveryMethod")+"</td>");
        writer.println("<td>");
        if(req.getParameter("catalogRequest") == null){
            writer.println("No");
        }else{
            writer.println("Yes");
        }
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("<div style = 'border:1px solid #ddd;"+"margin-top:40px;font-size:90%'>");
        writer.println("Debug Info<br/>");
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            writer.println(paramName+":");
            String[] parameterValues = req.getParameterValues(paramName);
            for(String paramValue:parameterValues){
                writer.println(paramName+"<br/>");
            }
        }
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
