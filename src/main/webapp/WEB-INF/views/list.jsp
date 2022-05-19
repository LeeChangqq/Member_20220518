<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<form action="login" method="post">
<table class="table">
        <tr>
            <th>id</th>
            <th>id2</th>
            <th>pass</th>
            <th>name</th>
            <th>age</th>
            <th>phone</th>
            <th>조회</th>
            <th>삭제</th>
            <th>수정</th>
        </tr>
    <c:forEach var="member" items="${memberList}">
        <tr>
            <td>${member.id}</td>
            <td>${member.id2}</td>
            <td>${member.pass}</td>
            <td>${member.name}</td>
            <td>${member.age}</td>
            <td>${member.phone}</td>
            <td><a href="/detail?id=${member.id}">조회</a></td> <!-- ?뒤는 파라미터 -->
            <td><a href="/delete?id=${member.id}">삭제</a></td>
            <td><a href="/update-form?id=${member.id}">수정</a></td>
            <!-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 -->
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
