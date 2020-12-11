<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 10/12/20
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<html>
<head>
    <title>calculator</title>

</head>
<body>
<form name="#" method="post">
    <input type="date" id="startDate">
    <input type="date" id="endDate">
    <input type="button" id="submit" value="submit">
</form>
<script src="<c:url value='/resources/js/cal.js?v='/>"></script>
</body>
</html>
