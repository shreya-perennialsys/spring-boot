<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 08/12/20
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update-Person</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<center>
    <h1>Update</h1>
    <form action="#" method="put">
        <input type="hidden" id="pid" value="${person.pid}">
        Email:<input type="email" id="email" value="${person.email}" required>
        Password:<input type="text" id="password" value="${person.password}" required>
        <input type="button" id="update" value="update">
    </form>
</center>
</body>
<script>
    $(document).ready(function(){
        $("#update").click(function(){
            let data ={
                "pid":$("#pid").val(),
                "email":$("#email").val(),
                "password":$("#password").val(),
            };
            let defaultHeaders ={
                "Content-Type":'application/json;charset=UTF-8',
                "Accept":"application/json"
            };
            $.ajax({
                url : 'http://localhost:8080/demo_war_exploded/updateRecord',
                type : "PUT",
                headers : defaultHeaders,
                data : JSON.stringify(data),
                crossDomain : true,
                processData : false,
                contentType : false,
                cache : false,
                // success : function(res, status, xhr) {
                //     //code to enable button
                //     window.location ="http://localhost:8080/demo_war_exploded/loginperson";
                // }
                statusCode: {
                        200: function (response) {
                            // do your stuff here
                            window.location ="http://localhost:8080/demo_war_exploded/loginperson";
                        },
                        404: function (response) {
                            // do your stuff here
                            window.location ="http://localhost:8080/demo_war_exploded/loginperson";
                        }
                    }

            });
            // window.location.href = "http://localhost:8080/demo_war_exploded/loginperson";
        });
    });
</script>
</html>
