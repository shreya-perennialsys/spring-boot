<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 08/12/20
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login-person</title>
</head>
<body>
<h1>Login</h1>
<center>
    <form action="validateperson" method="post">
        Email:<input type="email" name="email" required>
        Password:<input type="password" name="password" required>
        <input type="submit" value=" submit ">
    </form>
    <a href="registerperson" methods="get">Register</a>
</center>
</body>
</html>
