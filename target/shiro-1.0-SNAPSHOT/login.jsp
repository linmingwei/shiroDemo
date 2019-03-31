<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2019/3/30
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Login Page</h4>
<form action="/shiro/login">
    <div class="form-group">
        <label>username:</label>
        <input type="text" name="username">
    </div>
    <div class="form-group">
        <label>password:</label>
        <input type="password" name="password">
    </div>
    <button type="submit">login</button>
</form>
</body>
</html>
