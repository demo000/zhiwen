<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE >
<html>

<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <%@include file="common/common.jsp"%>

    <script src="/plugins/jquery.twbsPagination.min.js"></script>
    <script src="/plugins/bootstrap3-typeahead.min.js"></script>
    <script language="javascript" type="text/javascript" src="/plugins/My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">
        $(function () {
            var queryForm = $("#queryForm");
            var t_body = $("#tbody");
            var startDate = $("input[name='startDate']");
            var endDate = $("input[name='endDate']");
            var appId = $("input[name='appId']");

            queryForm.ajaxForm(function (data) {

                t_body.hide();
                t_body.html(data);
                t_body.show(500);
            });
//            queryForm.ajaxSubmit();
            /*页面已加载完毕就进行查询*/
            queryForm.submit();

            startDate.on("click", function () {
                WdatePicker({
                    maxDate: new Date()
                });
            });

            endDate.on("click", function () {
                WdatePicker({
                    'minDate': startDate.val(),
                    'maxDate': new Date()

                });
            });

            $("#query").on("click", function () {
                /*高级查询从第一页开始查询*/
                $("#currentPage").val(1);
                queryForm.submit();
            });

            appId.typeahead({
                minLength:3,
                maxItem:8,
                source:function(query, process){
                  $.get("http://localhost:8080/user/queryAppId/"+query,function (data) {
                      if(data.state==200){
                          process(data.data)
                      }
                  })
                },
            });



        })
    </script>
</head>

<body>
<form class="form-inline" action="/user/query" method="POST" id="queryForm">
    <input type="hidden" id="currentPage" name="currentPage" value="1"/>
    <div class="form-group">
        <label>公众号</label>
        <input type="text" name="appId" class="form-control" placeholder="微信号">
    </div>
    <div class="form-group">
        <label>查询时间</label>
        <input class="form-control" type="text" name="startDate"> -
        <input class="form-control" name="endDate" type="text">
    </div>

    <div class="form-group">
        <label>类型</label>
        <select name="genre" class="form-control">
            <option value="0" >---全部---</option>
            <option value="1">关注</option>
            <option value="-1">取消关注</option>
        </select>
    </div>
    <div class="form-group">
        <button type="button" id="query" class="btn btn-primary ">查询</button>
    </div>
</form>
<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>公众号</th>
        <th>关注用户</th>
        <th>关注时间</th>
        <th>操作类型</th>
        <th>用户IP</th>

    </tr>
    </thead>
    <tbody id="tbody">


    </tbody>
</table>
<div style="text-align: center;" id="paginationContance">

</div>
</body>

</html>