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
    <title>Register-Person</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<center>
    <h1>Register</h1>
    <form action="#" method="post">
        Email:<input type="email" id="email" required>
        Password:<input type="password" name="password" id="password" required>
        Confirm Password:<input type="password" id="confirmpassword" required>
        <div id="error"></div>
        <input type="button" id="submit" value="Register">
    </form>
</center>
</body>
<script>
    $(document).ready(function(){
        $("#submit").click(function(){
                var p=document.getElementById("password").value;
                var c=document.getElementById("confirmpassword").value;
                if (p!=c) {
                    alert(" not match")
                    window.location.href = "http://localhost:8080/demo_war_exploded/registerperson";
                }
                else {
                    let data = {
                        "email": $("#email").val(),
                        "password": $("#password").val()
                    };
                    let defaultHeaders = {
                        "Content-Type": 'application/json;charset=UTF-8',
                        "Accept": "application/json"
                    };
                    $.ajax({
                        url: 'http://localhost:8080/demo_war_exploded/view',
                        type: "POST",
                        headers: defaultHeaders,
                        data: JSON.stringify(data),
                        crossDomain: true,
                        processData: false,
                        contentType: false,
                        cache: false,
                        success: function (res, status, xhr) {
                            //code to enable button
                            window.location = "http://localhost:8080/demo_war_exploded/loginperson";
                        }

                    });
                    // window.location.href = "http://localhost:8080/demo_war_exploded/loginperson";
                }
        });

    });
</script>
</html>
