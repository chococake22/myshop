<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>글쓰기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/navigation.jsp"/>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <h1>글쓰기</h1>
    <form action="/board/save" method="post">
        제목 : <input type="text" name="title" id="title" > <br>
        내용 : <input type="text" name="content" id="content" > <br>
        노출 여부 :
        <div class="form-check">
            <input class="form-check-input" type="radio" name="blindYn" id="blind_type_y" value="y">
            <label class="form-check-label" for="blind_type_y">
                미노출
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="blindYn" id="blind_type_n" value="n" checked>
            <label class="form-check-label" for="blind_type_n">
                노출
            </label>
        </div>  <br>

        분류 :
        <div class="form-check">
            <input class="form-check-input" type="radio" name="type" id="type_text" value="text">
            <label class="form-check-label" for="blind_type_y">
                텍스트
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="type" id="type_image" value="image" checked>
            <label class="form-check-label" for="blind_type_n">
                이미지
            </label>
        </div>  <br>


        <button type="submit" value="등록">등록</button>
    </form>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
