package cn.ly.app02a.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author LiYun
 * @Date 2020/9/24 21:02
 * @Version 1.0
 */

@WebServlet(name = "PreferenceServlet", urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet {
    private static final long serialVersionUID = 888L;
    public static final String MENU = "<div style='background:#e8e8e8;" + "padding:15px'>"+
            "<a href='cookieClass'>Cookie Class</a>&nbsp;&nbsp;"+
            "<a href='cookieInfo'>Cookie Info</a>&nbsp;&nbsp;"+
            "<a href='preference'>Preference</a>" + "<div>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html><head>"+"<title>Preference</title>"
            +"<style>table {" + "font-size:small;"
                +"background:NavajoWhite }<style>"
                +"</head><body>"
                +MENU
                +"Please select the values below:"
                +"<form method = 'post'>"
                +"<table>"
                +"<tr><td>Title Font Size: </td>"
                +"<td><select name = 'titleFontSize'>"
                +"<option>large</option>"
                + "<option>x-large</option>"
                + "<option>xx-large</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>Title Style & Weight: </td>"
                +"<td><select name='titleStyleAndWeight' multip le>"
                + "<option>italic</option>"
                + "<option>bold</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>Max. Records in Table: </td>"
                + "<td><select name='maxRecords'>"
                + "<option>5</option>"
                + "<option>10</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td rowspan='2'>"
                + "<input type='submit' value='Set'/></td>"
                + "</tr>"+ "</table>" + "</form>" + "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxRecords = req.getParameter("maxRecords");
        String[] titleStyleAndWeights = req.getParameterValues("titleStyleAndWeight");
        String titleFontSize = req.getParameter("titleFontSize");
        resp.addCookie(new Cookie("maxRecords",maxRecords));
        resp.addCookie(new Cookie("titleFontSize",titleFontSize));
        //删除cookie
        //通过把maxAge设置为0
        Cookie cookie = new Cookie("titleFontWeight","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        cookie = new Cookie("titleFontStyle","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        if(titleStyleAndWeights != null){
            for(String style:titleStyleAndWeights){
                if(style.equals("bold")){
                    resp.addCookie(new Cookie("titleFontWeight","bold"));
                }else if(style.equals("italic")){
                    resp.addCookie(new Cookie("titleFontStyle","italic"));
                }
            }
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head>" + "<title>Preference</title>"
                        + "</head><body>" + MENU
                        + "Your preference has been set."
                        + "<br/><br/>Max. Records in Table: " + maxRecords
                        + "<br/>Title Font Size: " + titleFontSize
                        + "<br/>Title Font Style & Weight: ");
// titleStyleAndWeight will be null if none of the options was selected
        if (titleStyleAndWeights != null) {
            writer.println("<ul>");
            for (String style : titleStyleAndWeights) {
                writer.print("<li>" + style + "</li>");
            }writer.println("</ul>");
        }writer.println("</body></html>");
    }
}
