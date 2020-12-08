<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 04/12/20
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="registeruser">
        id:<input type="text" name="uid">
        Name:<input type="text" name="name" required><br/>
        Mobile No:<input type="text" name="mobileno" required><br/>
        City:<input type="text" name="city" required><br/>
        Adhara Card:<input type="text" name="adharacard" required><br/>
        Account No:<input type="text" name="accountno" required><br/>
        Email:<input type="email" name="mail" required><br/>
        Password:<input type="password" name="password" required><br/>
        <input type="submit" value="submit">
    </form>
</center>
</body>
</html>
