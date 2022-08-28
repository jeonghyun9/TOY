<%--
  Created by IntelliJ IDEA.
  User: ffin9
  Date: 2022-08-27
  Time: 오후 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>게시물 상세보기</title>
</head>
<body>

<h2>게시물 상세보기</h2>

<form id="board" method="get">

    <label>제목</label>
    <input type="text" name="title" value="${board.title }" readonly="readonly"/><br />

    <label>작성자</label>
    <input type="text" name="writer" value="${board.id }" readonly="readonly"/><br />

    <label>내용</label>
    <textarea cols="50" rows="5" name="content" readonly="readonly" >${board.content}</textarea><br />

    <button class="updateBtn" type="button">수정</button>&nbsp;<button class="backBtn" type="reset" >목록</button>&nbsp;<button class="delBtn" type="button" >삭제</button>

</form>

<a href="/board/modify?bno=${board.bno}">수정</a>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
    $(document).ready(function (){

        $(".backBtn").on("click", function () {
           location.href = "list";
        });

        $(".updateBtn").on("click", function () {
            location.href = "modify?bno=${board.bno}";
        });

        $(".delBtn").on("click", function () {

            let form = $("#board");
            form.attr("action", "<c:url value='/board/delete'/>?bno=${board.bno}");
            form.attr("method", "post");
            form.submit();
            alert("★[삭제 완료]★");
        });
    })
</script>

</body>
</html>
