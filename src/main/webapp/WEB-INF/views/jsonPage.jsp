<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>getJSON获取数据</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body>
<div id="data"></div>
<div id="select">${selectStr}</div>
<div id="gsonList">${gsonList}</div>
<div>
    <label>省份</label>
    <select id="province">
        <option value="0">--请选择--</option>
    </select>
    <label>城市</label>
    <select id="city">
        <option value="0">--请选择--</option>
    </select>
   <%-- <label>城区</label>
    <select id="county">
        <option value="0">--请选择--</option>
    </select>
    <select id="town">
        <option value="0">--请选择--</option>
    </select>--%>
</div>

<div class="city">
    <input name="" type="checkbox" value="111">
    <table border="1px" width="100%">
        <thead>
        <tr>
            <th style="width: 20%">区域</th>
            <th style="width: 80%">街道</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <tr>
            <td>天河区</td>
            <td>街道1,街道2,街道3</td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2">
                <button id="submit">确定</button>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script type="text/javascript">
    var country;//国家
    var city;//具体城市
    var county;//区
    var town;//具体街道镇
    var $city = $("#city");
    var $county = $("#county");
    var $province = $("#province");
    $.getJSON("street.json", function (data) {
        country = data;
        $.each(data, function (index, p) {
            $province.append("<option value='" +p['id']+ "'"+ "<c:if test="${city==index}"></c:if>"+" >"+ p['name'] + "</option>");

        })

    });
    //选中原有数据
    function checkInput() {
        var json = $("#gsonList").text();
        json = $.parseJSON(json);
        $.each(json, function (index, val) {
            var $class = val['name'];
            var street = val['street'];
            $.each(street, function (index, val) {
                $("." + $class).addClass("active");
                $("." + $class).find("input[value='" + val + "']").attr("checked", true);
            })
        })
    }
    function createStreet() {
        $("#tbody").empty();
        $.each(county, function (index, cx) {
            $county.append("<option value='" + cx['id'] + "'>" + cx['name'] + "</option>");
            var streets = [];
            var town = cx['town'];
            if (town) {
                $.each(town, function (i, st) {
                    streets.push("<input type='checkbox' class='street' name='street' " + "' value='" + st['name'] + "'  >" + st['name']);
                })
                $("#tbody").append("<tr class='" + cx['name'] + "'>" +
                    "<td>" + cx["name"] + "</td>" +
                    "<td>" + streets + "</td>" +
                    "</tr>");
            }
        })
        $(".street").on("click", function () {
            $(this).closest("tr").addClass("active");
        })
    }
    $(function () {

        //选择省份
        $province.on("change", function () {
            var pid = $("#province option:selected").val();
            $("#tbody").empty();
            $city.empty();
           // $city.append("<option value='0'>--请选择--</option>");
            city = '[]';
            $.each(country, function (index, p) {
                if (p['id'] == pid) {
                    city = p["city"];
                    $.each(city, function (index, c) {
                       //展示省会城市
                        if(index==0){
                            $.each(city, function (index2, ct) {
                                county = ct["county"];
                                if (index2==0) {
                                    //创建区域[街道]
                                    createStreet();
                                    checkInput();
                                }
                            });
                        }

                        $city.append("<option value='" + c['id'] + "'>" + c['name'] + "</option>");
                    })
                }
            });
            //选中省会城市
            $("#city option:first").prop("selected", 'selected');
        })
        //选择城市
        $city.on("change", function () {
            var cid = $("#city option:selected").val();

            $.each(city, function (index, c) {
                county = c["county"];
                if (c["id"] == cid) {
                    //创建区域[街道]表格
                    createStreet();

                }
            });
            //选中旧数据
            checkInput();

        });

        $(".street").on("click",function(){
            alert(111)
        })

        $("#submit").on("click",function(){
            var active = $("tr.active");
            alert(active.length)
           /* var chk_value=[];
            $('input[name="street"]:checked').each(function(){
                chk_value.push($(this).val());
            });
            alert(chk_value)*/

        })

    })
</script>
</body>
</html>