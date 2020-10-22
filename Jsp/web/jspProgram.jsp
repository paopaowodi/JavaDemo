<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/10/13
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>jsp基本语法学习</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h3>jsp基本语法学习</h3>
    <hr/>
    <%
        //声明java代码域
        int a = 4;
        if(a >3){
    %>
    <b>学习</b>
<%
    }
%>
<!-- jsp的静态引入 -->
<%@include file="1.jsp"%>
<!-- jsp的动态引入-->
<jsp:include page="1.jsp"></jsp:include>
<!-- jsp的forward转发标签-->
<jsp:forward page="1.jsp">
    <jsp:param name="str" value="aaa"/>
</jsp:forward>
<!--九大内置对象-->
<% request.getParameter()%>
</body>
</html>
