<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

    table,th{border:none;height:auto;}
    td{border:0px solid #000;height:auto;text-align: center; word-break:break-all}
    td,caption{padding: 5px 0;}
    .line{
        width: 100%;
        position: absolute;
        bottom: 0;
        height: 1px;
        background: #000;
    }
</style>

<table border=1 cellSpacing=0 cellPadding=0  width="100%"  bordercolor="#000000" style="border-collapse:collapse">
    <caption style="position: relative;"><b><font face="宋体" size="5">产品入库汇总</font></b>
    <thead>
    <tr>
        <td width="15%"><b>编号</b></td>
        <td width="45%"><b>商品名称</b></td>
        <td width="20%"><b>数量</b></td>
        <td width="20%"><b>金额</b></td>
    </tr>
    <tr>
        <td width="100%" colspan="4" style="position: relative;">
            <div class="line"></div>
        </td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td width="15%">01</td>
        <td width="45%">新秀丽（Samsonite）双肩包背包 商务休闲书包笔记本包</td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">02</td>
        <td width="45%">Apple iPad mini 4 平板电脑 7.9英寸（128G WLAN版/A8芯</td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">03</td>
        <td width="45%">华硕（ASUS)超薄游戏笔记本电脑14英寸A456UR7200酷睿I5</td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">04</td>
        <td width="45%">飞科(FLYCO)电吹风机家用FH6273大功率吹风筒负离子</td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">05</td>
        <td width="45%">奥克斯空调柜机 </td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">05</td>
        <td width="45%">奥克斯空调柜机 </td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">05</td>
        <td width="45%">奥克斯空调柜机 </td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">05</td>
        <td width="45%">奥克斯空调柜机 </td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    <tr>
        <td width="15%">05</td>
        <td width="45%">奥克斯空调柜机 </td>
        <td width="20%">1</td>
        <td width="20%">1000</td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
        <td width="100%" colspan="4" style="position: relative;">
            <div class="line"></div>
        </td>
    </tr>
    <tr>
        <td width="60%" colspan="2" style="text-align: left"><b>经办人：xxxx</b></td>
        <td width="15%" style="text-align: right"><b>合计:</b></td>
        <td width="15%"  style="text-align: center"><b>100000</b></td>
    </tr>
    <tr>
        <td width="100%" colspan="4" style="text-align: left">打印时间:2017-03-14 22:13</td>
    </tr>
    </tfoot>
</table>