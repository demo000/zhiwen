<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>知问前端</title>
    <script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugins/uEditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugins/uEditor/ueditor.all.min.js"></script>
    <script type="text/javascript" src="/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="/plugins/jquery.bootstrap.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-ui/js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico"/>
    <link rel="stylesheet" href="/plugins/jquery-ui/css/smoothness/jquery-ui.min.css" type="text/css"/>
    <link rel="stylesheet" href="/css/style.css" type="text/css"/>


</head>

<body>


<div id="header">
    <div class="header_main">
        <h1>知问</h1>
        <div class="header_search">
            <form id="search_form">
                <input type="text" name="keywords" class="search"/>
            </form>
        </div>

        <div class="header_button">
            <button id="search_button">搜索</button>
            <button id="question_button">提问</button>
        </div>
        <div class="header_member">
            <a href="##" id="reg_a">注册</a> <a href="javascript:void(0)" id="user_a">用户</a> |
            <a href="###" id="login_a">登陆</a> <a href="##" id="logout">退出</a>
            <a href="/weixin_login" >微信登陆</a>
        </div>


    </div>
</div>


<div id="main">
    <div class="main_left">

        <div id="tabs">
            <ul>
                <li><a href="/page/tab1">user</a></li>
                <li><a href="/page/tab1">tab1</a></li>
                <li><a href="/page/tab1">tab3</a></li>
            </ul>
        </div>
        <div class="content">


        </div>

    </div>
    <div class="main_right">
        <div id="accordion">
            <h1>菜单1</h1>
            <div>内容1</div>
            <h1>菜单2</h1>
            <div>内容2</div>
            <h1>菜单3</h1>
            <div>内容3</div>
        </div>
    </div>
</div>


<div id="reg">
    <!--用来包裹错误信息-->
    <ol class="myerror"></ol>
    <form id="regForm">

        <p>
            <label for="userName" class="_title">用户名:</label>
            <input name="userName" type="text" class="text" id="userName"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="passWord" class="_title">密&nbsp;&nbsp;码:</label>
            <input name="passWord" class="text" type="password" id="passWord"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="repassWord" class="_title">确认密码:</label>
            <input class="text" name="repassWord" type="password" id="repassWord"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="email" class="_title">邮&nbsp;&nbsp;箱:</label>
            <input name="email" class="text" type="email" id="email"/>
            <span class="star">*</span>
        </p>
        <p>
            <label class="_title">性&nbsp;&nbsp;别:</label>
            <input type="radio" name="sex" value="male" checked="checked">男</input>
            <input type="radio" name="sex" value="female">女</input>
        </p>
        <p>
            <label for="birthDay" class="_title">生&nbsp;&nbsp;日:</label>
            <input type="text" name="birthDay" readonly="readonly" class="text" id="birthDay"/>
        </p>
    </form>
</div>

<div id="loading">
    正在提交...
</div>

<div id="error">
    请登录后操作...
</div>
<div id="login_div">
    <form id="login_form">
        <p>
            <label for="userName" class="_title">用户名:</label>
            <input name="userName" type="text" class="text"/>
            <span class="star">*</span>
        </p>
        <p>
            <label for="passWord" class="_title">密&nbsp;&nbsp;码:</label>
            <input name="passWord" class="text" type="password"/>
            <span class="star">*</span>
        </p>
        <p>
            <input type="checkbox" name="expires" id="expires" checked="checked"/><label class="expires" for="expires">登录后有效期一周</label>
        </p>
    </form>
</div>
<div id="question">
    <form id="question_form" title="提问">

        <p>
            <label for="title">问题名称：</label>
            <input type="text" name="title" class="text" style="width:430px;" id="title"/>
            <span class="star"></span>
        </p>
        <script type="text/plain" id="content" name="content" style="width:550px;height:520px">
            <p>欢迎使用UEditor！</p>

        </script>
    </form>
</div>

</body>

</html>