<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <a href="/save-form">회원가입</a> <br>
  <a href="/login-form">로그인</a> <br>
  <a href="/findAll">회원목록</a>   <br>
  <a href="/response-test">Response Test</a>   <br>
  <a href="/response-test2">Response Test2</a>   <br>
  로그인 회원 정보 : ${member} <br>
  세션에 담은 memberId : ${sessionScope.id}    <br>
  세션에 담은 id : ${sessionScope.loginId} <br>
</body>
</html>
