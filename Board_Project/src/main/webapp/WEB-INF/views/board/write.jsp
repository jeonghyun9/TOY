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
    <title>게시물 쓰기</title>
</head>
<body>

<h3>게시물 쓰기</h3>

<form method="post">

    <input type="hidden" value="${board.bno}">
    <label>제목</label>
    <input type="text" name="title" /><br />

    <label>작성자</label>
    <input type="text" name="id" /><br />

    <label>내용</label>
    <textarea cols="50" rows="5" name="content" ></textarea><br />

    <button id="writeBtn" type="submit">작성</button>&nbsp;<button class="backBtn" type="reset">목록</button>

</form>

</body>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
    $(document).ready(function (){
        $(".backBtn").on("click", function () {
            location.href = "list";
        })

        $("#writeBtn").on("click", function () {
            alert("★[등록 완료]★")
            location.href = "list";
        })
    })
</script>
</html>
