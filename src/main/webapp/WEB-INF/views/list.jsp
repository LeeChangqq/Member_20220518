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
</head>
<body>
    <c:forEach var="member" items="${memberList}">
        ${member.id}
        ${member.id2}
        ${member.pass}
        ${member.name}
        ${member.age}
        ${member.phone} <br>
    </c:forEach>
</body>
</html>
