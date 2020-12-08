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
    <form action="${pageContext.request.contextPath}/product/registeruser">
        id:<input type="text" name="uid" value="${user.uid}">
        Name:<input type="text" name="name" required value="${user.name}"><br/>
        Mobile No:<input type="text" name="mobileno" required value="${user.mobileno}"><br/>
        City:<input type="text" name="city" required value="${user.city}"><br/>
        Adhara Card:<input type="text" name="adharacard" required value="${user.adharacard}"><br/>
        Account No:<input type="text" name="accountno" required value="${user.accountno}"><br/>
        Email:<input type="email" name="mail" required value="${user.mail}"><br/>
        Password:<input type="text" name="password" required value="${user.password}"><br/>
        <input type="submit" value="submit">
    </form>
</center>
</body>
</html>
