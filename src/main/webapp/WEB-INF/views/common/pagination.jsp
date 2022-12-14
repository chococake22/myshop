<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%--페이징--%>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:choose>
            <c:when test="${pagination.prev}">
                <li class="page-item"><a class="page-link" href="/board/list?nowPage=${pagination.nowPage - 1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item disabled"><a class="page-link" href="/board/list?nowPage=${pagination.nowPage - 1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach var="pno" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
            <li class="page-item"><a class="page-link" href="/board/list?nowPage=${pno}">${pno}</a></li>
        </c:forEach>

        <c:choose>
            <c:when test="${pagination.next}">
                <li class="page-item"><a class="page-link" href="/board/list?nowPage=${pagination.nowPage + 1}" >Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item disabled"><a class="page-link" href="/board/list?nowPage=${pagination.nowPage + 1}" >Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
