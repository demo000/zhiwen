<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${pageResult.totalCount>0}">
        <c:forEach items="${pageResult.result}" var="page">
            <dl class="comment_content">
                <dt>${page.userName}</dt>
                <dd>${page.content}</dd>
                <dd class="date">${page.createDate}</dd>
            </dl>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <dl class="comment_content">
            赶快来抢沙发吧...
        </dl>
    </c:otherwise>

</c:choose>

