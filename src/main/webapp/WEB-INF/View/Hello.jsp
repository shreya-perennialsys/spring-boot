<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 27/11/20
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<html>
<head>
    <title>Video form</title>
</head>
<body>
<center>
    <form action="addproduct" method="post" enctype="multipart/form-data">
        Name of prpduct:<input type="text" name="Product_name" required><br/><br/>
        UploadImage<input type="file" name="product_Image" required>
        Price:<input type="password" name="Product_prize" required><br/><br/>
        <input type="submit" value="add">
    </form>
</center>
</body>
</html>
