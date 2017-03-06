<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:choose>
    <c:when test="${pageResult.totalCount>0}">
        <c:forEach items="${pageResult.result}" var="user">

            <tr >
                <td>${user.id}</td>
                <td>${user.appId}</td>
                <td>${user.userId}</td>
                <td>${user.createDate}

                </td>
                <td><c:choose>
                    <c:when test="${user.genre==1}"> 关注</c:when>
                    <c:otherwise> 取消关注</c:otherwise>
                </c:choose>
                </td>
                <td>${user.ip}</td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr class="danger">
            <td colspan="6" align="center">没有查询到数据</td>
        </tr>
    </c:otherwise>
</c:choose>




<script type="text/javascript">
    $(function () {
        $("#paginationContance").empty().append('<ui id="pagination" class="pagination"></ui>');
        /*设置分页条*/
        $('#pagination').twbsPagination({
            totalPages: ${pageResult.totalPage},
            visiblePages: 5,
            startPage:${pageResult.currentPage},
            first: '首页',
            next: '下一页',
            prev: '上一页',
            last: '尾页',
            onPageClick: function (event, page) {
                $("#currentPage").val(page);
                $("#queryForm").submit();
            }
        });
    })
</script>