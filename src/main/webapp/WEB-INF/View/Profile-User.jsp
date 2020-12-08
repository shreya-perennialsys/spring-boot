<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 07/12/20
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
<center>
    <h1 style="color: orangered">Welcome ${user.name}</h1>
    <table>
        <tr>
            <td>Name:</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Account Number:</td>
            <td>${user.accountno}</td>
        </tr>
        <tr>
            <td>Adhara Number:</td>
            <td>${user.adharacard}</td>
        </tr>
        <tr>
            <td>Mobile Number:</td>
            <td>${user.mobileno}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.mail}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${user.city}</td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>${user.password}</td>
        </tr>
    </table>
    <a href="/demo_war_exploded/product/update/${user.uid}">update</a>
    <a href="/demo_war_exploded/product/delete/${user.uid}">delete</a>
</center>
</body>
</html>
