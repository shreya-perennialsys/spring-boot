<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 07/12/20
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>

<body>
<center>
<form action="validation">
    <input type="email" name="email" required>
    <input type="password" name="password" required>
    <input type="submit" value="submit">
</form>
<a href="/demo_war_exploded/product/register">Register</a>
</center>
</body>
</html>
