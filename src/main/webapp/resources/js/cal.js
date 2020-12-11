$(document).ready(function () {
    $("#submit").click(function () {
        let data = {
            "startDate": $("#startDate").val(),
            "endDate": $("#endDate").val()
        };
        let defaultHeaders = {
            "Content-Type": 'application/json;charset=UTF-8',
            "Accept": "application/json"
        };
        $.ajax({
            url: 'http://localhost:8080/demo_war_exploded/calculate',
            type: "POST",
            headers: defaultHeaders,
            data: JSON.stringify(data),
            crossDomain: true,
            processData: false,
            contentType: false,
            cache: false,
            success: function (res, status, xhr) {
                //code to enable button
                window.location = "http://localhost:8080/demo_war_exploded/result";
            }

        });
        // window.location.href = "http://localhost:8080/demo_war_exploded/loginperson";
    });

});