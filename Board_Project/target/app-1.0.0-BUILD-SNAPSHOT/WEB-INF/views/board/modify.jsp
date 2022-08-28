<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ffin9
  Date: 2022-08-27
  Time: 오후 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>
</head>
<body>

<h3>게시글 수정</h3>

<form id="board" method="post">

    <label>제목</label>
    <input type="text" name="title" value="${board.title }"/><br />

    <label>작성자</label>
    <input type="text" name="writer" value="${board.writer }" readonly="readonly" /><br />

    <label>내용</label>
    <textarea cols="50" rows="5" name="content" >${board.content }</textarea><br />

    <input type="hidden" name="reg_date" value="${board.reg_date}">

    <button id="updateBtn" type="button">수정</button>&nbsp;<button class="backBtn" type="reset">목록</button>

</form>

</body>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
    $(document).ready(function (){
        $(".backBtn").on("click", function () {
            location.href = "list?bno=${board.bno}";
        })

        $(".updateBtn").on("click", function () {
            $("#board").attr("action", "<c:url value='/board/modify'/>?bno=#{board.bno}");
            $("#board").attr("method", "post");
            $("#board").submit();
            alert("수정 완료");
        })
    })
</script>
</html>