<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE >
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <%@include file="common/common.jsp" %>
    <script src="/plugins/jquery.twbsPagination.min.js"></script>
    <script src="/plugins/bootstrap3-typeahead.min.js"></script>
    <link rel="stylesheet" href="/css/testPage.css">
</head>
<body>
<span id="sp">${name}</span>
<br>
<button class="btn">重新加载</button>
<script>
    $(function () {
        var num = 0;
        $(".btn").on("click", function () {
            $.get("/test/load", {name: num++}, function (data) {
                console.log(data)
                if (data) {
                    $("#sp").html("加载次数:" + data)
                }
            });

        })
    })
    document.onkeydown = function (e) {
        e = window.event || e;
        var keycode = e.keyCode || e.which;
        if (keycode == 116) {
            var test = window.location.href;
            if(window.event){// ie
                try{e.keyCode = 0;}catch(e){}
                alert(test)
                e.returnValue = false;
            }else{// firefox
                alert(test)
                e.preventDefault();
            }

        }
    }
</script>
</body>
</html>