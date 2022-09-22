<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>메인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/navigation.jsp"/>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <h2>게시글 : ${totalCount}</h2>

    <a href="/board/save">등록</a>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">선택</th>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">수정자</th>
                <th scope="col">등록일자</th>
                <th scope="col">수정일자</th>
                <th scope="col">분류</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${boards}" var="board">
                <tr>
                    <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
                    <td><c:out value="${board.boardIdx}"></c:out></td>
                    <td><a href="/board/detail?boardIdx=${board.boardIdx}">${board.title}</a></td>
                    <td><c:out value="${board.regUser}"></c:out></td>
                    <td><c:out value="${board.modUser}"></c:out></td>
                    <td><c:out value="${board.regDt}"></c:out></td>
                    <td><c:out value="${board.modDt}"></c:out></td>
                    <td><c:out value="${board.type}"></c:out></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
