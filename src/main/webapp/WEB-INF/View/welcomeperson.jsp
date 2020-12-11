<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 08/12/20
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome person</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>Welcome ${person.email}</h1>
Email:${person.email}
Password:${person.password}
<a href="update/${person.pid}">Update</a>
<form method="delete" action="#">
    <input type="button" value="delete" id="delete">
</form>
<%--<a href="delete/${person.pid}" methods="delete">delete</a>--%>
</body>
<script>
    $(document).ready(function(){
        $("#delete").click(function(){

            let defaultHeaders ={
                "Content-Type":'application/json;charset=UTF-8',
                "Accept":"application/json"
            };
            $.ajax({
                url : 'http://localhost:8080/demo_war_exploded/delete/${person.pid}',
                type : "DELETE",
                headers : defaultHeaders,
                crossDomain : true,
                processData : false,
                contentType : false,
                cache : false,
                // success : function(res, status, xhr) {
                //     //code to enable button
                //     window.location ="http://localhost:8080/demo_war_exploded/registerperson";
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
