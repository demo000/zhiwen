<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@include file="common/common.jsp"%>
    <script type="text/javascript" src="/js/LodopFuncs.js"></script>
    <title>Title</title>
</head>
<body>
<div id="div2">

    <style>table,th{border:none;height:18px} td{border: 1px solid #000;height:18px}</style>

    <table border=0 cellSpacing=0 cellPadding=0  width="100%" height="200" bordercolor="#000000" style="border-collapse:collapse">
        <caption><b><font face="黑体" size="4">产品入库汇总清单</font></b><br>(Caption内容只在首页)</caption>
        <thead>
        <tr>
            <th width="33%">日期：</th>
            <th width="67%" colspan="2">部门名称:</th>
        </tr>
        <tr>
            <td width="33%"><b>入库单编号</b></td>
            <td width="33%"><b>产品名称</b></td>
            <td width="32%"><b>数量</b></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td width="33%">1</td>
            <td width="33%">产品A</td>
            <td width="34%">100</td>
        </tr>
        <tr>
            <td width="33%">2</td>
            <td width="33%">产品B</td>
            <td width="34%">200</td>
        </tr>
        <tr>
            <td width="33%">3</td>
            <td width="33%">产品C</td>
            <td width="34%">300</td>
        </tr>
        <tr>
            <td width="33%">4</td>
            <td width="33%">产品D</td>
            <td width="34%">400　</td>
        </tr>
        <tr>
            <td width="33%">5</td>
            <td width="33%">产品E</td>
            <td width="34%">500</td>
        </tr>
        <tr>
            <td width="33%">6</td>
            <td width="33%">产品F</td>
            <td width="34%">600</td>
        </tr>
        <tr>
            <td width="33%">7</td>
            <td width="33%">产品J</td>
            <td width="34%">700</td>
        </tr>
        <tr>
            <td width="33%">8</td>
            <td width="33%">产品H</td>
            <td width="34%">800</td>
        </tr>
        <tr>
            <td width="33%">9</td>
            <td width="33%">产品I</td>
            <td width="34%">900</td>
        </tr>
        <tr>
            <td width="33%">10</td>
            <td width="33%">产品J</td>
            <td width="34%">110</td>
        </tr>
        <tr>
            <td width="33%">11</td>
            <td width="33%">产品K</td>
            <td width="34%">120</td>
        </tr>
        <tr>
            <td width="33%">12</td>
            <td width="33%">产品L</td>
            <td width="34%">130</td>
        </tr>
        <tr>
            <td width="33%">13</td>
            <td width="33%">产品M</td>
            <td width="34%">140</td>
        </tr>
        <tr>
            <td width="33%">14</td>
            <td width="33%">产品N</td>
            <td width="34%">150</td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <th width="100%" colspan="3"><b>经办人：</b></th>
        </tr>
        <tr>
            <th width="100%" colspan="3">　</th>
        </tr>
        <tr>
            <td width="100%" colspan="3"><b>带格线的每页备注：</b></td>
        </tr>
        </tfoot>
    </table>
</div>


<p>
<br/>
    <a style="margin-top: 100px;border-top: 100px" id="printTicket">打印小票</a>
</p>
<script type="text/javascript">
    var LODOP; //声明为全局变量
    $(function(){
        $("#printTicket").on("click",function(){
            $.get("/lodop/getLodopContent",function(htm){
                if(htm){
                    LODOP=getLodop();
                    LODOP.PRINT_INIT("打印小票");
                    LODOP.SET_PREVIEW_WINDOW(0,0,0,0,0,"");
                    LODOP.SET_PRINT_MODE("PRINT_PAGE_PERCENT","Full-Page");
                    LODOP.SET_PRINT_MODE("FULL_WIDTH_FOR_OVERFLOW",true);
                    LODOP.SET_PRINT_MODE("FULL_HEIGHT_FOR_OVERFLOW",true);
                    LODOP.SET_PREVIEW_WINDOW(1,0,0,0,0,"");
                    LODOP.ADD_PRINT_TABLE(5,5,"100%",'100%',htm);
                    LODOP.SET_PRINT_PAGESIZE(3,"88mm",'1.5mm',"打印小票");
                    LODOP.PREVIEW();
                }

            })

        });
    })
</script>
</body>
</html>
