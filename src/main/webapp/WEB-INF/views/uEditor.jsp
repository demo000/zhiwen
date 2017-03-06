<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="en-US">

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title></title>
    <script type="text/javascript" charset="utf-8" src="/plugins/u_editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugins/u_editor/ueditor.all.min.js"></script>
    <style type="text/css">
        body{
            font-size:14px;
        }
    </style>
</head>

<body>
<h2>UEditor提交示例</h2>
<form id="form" method="post" target="_blank">
    <input name="username">
    <script type="text/plain" id="content" name="content">
            <p>欢迎使用UEditor！</p>
    </script>
    <input type="submit" value="通过input的submit提交">
</form>
<p>
    从1.2.6开始，会自动同步数据无需再手动调用sync方法
    <button onclick="document.getElementById('form').submit()">通过js调用submit提交</button>

</p>

<script type="text/javascript">
    var editor_a = UE.getEditor('content',{initialFrameHeight:500, serverUrl: '#'});
    form.action="#";

</script>
</body>

</html>