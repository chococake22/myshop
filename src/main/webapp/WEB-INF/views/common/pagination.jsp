<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%--페이징--%>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${pagination.prev}">
            <li class="page-item"><a class="page-link" href="Javascript:void(0)">PreviousOk</a></li>
        </c:if>

        <c:forEach var="pno" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
            <li class="page-item"><a class="page-link" href="/board/list?nowPage=${pno}">${pno}</a></li>
        </c:forEach>

        <c:if test="${pagination.next}">
            <li class="page-item"><a class="page-link" href="Javascript:void(0)" >NextNo</a></li>
        </c:if>
    </ul>
</nav>
