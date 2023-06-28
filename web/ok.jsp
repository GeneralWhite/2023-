<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-21
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("欢迎你" + session.getAttribute("user"));
%>
</body>
</html>
