<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2019/3/30
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>List Page</h4>
welcome: <shiro:principal/>
<br>
<shiro:hasRole name="admin">

    <a href="/admin.jsp">Admin</a>
</shiro:hasRole>
<br>
<shiro:hasRole name="user">

    <a href="/user.jsp">User</a>
</shiro:hasRole>
<br>
<a href="/shiro/annotation">test shiro annotation</a>
<br>
<a href="/shiro/logout">logout</a>
</body>
</html>
