<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-21
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 这里request获取的是html中调用该jsp的name对应的值而非id对应的
    // 此处name对应的值分别为user和password
    String username = request.getParameter("user");
    String password = request.getParameter("password");

    if(username.equals(password))
    {
        session.setAttribute("user", username);
        response.sendRedirect("ok.jsp");
    }
    else
    {
        response.sendRedirect("error.html");
    }
%>
</body>
</html>
