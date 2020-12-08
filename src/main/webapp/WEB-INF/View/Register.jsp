<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-Up</title>
</head>
<body>
<center>
<form action="/demo/employees/addUser",method="POST">
    <p style="text-align:center;">
        <br>ID:<input type="text" name="id">
    <br>FirstName:<input type="text" name="firstName">
     <br>LastName:<input type="text" name="lastName">
        <br>Email:<input type="text" name="email">
    <input type="Submit">
    </p>
</form>
</center>
</body>
</html>
