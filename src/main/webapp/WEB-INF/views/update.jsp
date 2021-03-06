<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-19
  Time: 오후 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<form action="/update" method="post" name="updateForm">
    id: <input type="text" class="form-control mb-2" name="id" value="${updateMember.id}" readonly>
    아이디: <input type="text" class="form-control mb-2" name="id2" value="${updateMember.id2}" readonly>
    비밀번호: <input type="text" class="form-control mb-2" name="pass" id="pwConfirm" placeholder="비밀번호">
    이름: <input type="text" class="form-control mb-2" name="name" value="${updateMember.name}" readonly>
    나이: <input type="text" class="form-control mb-2" name="age" value="${updateMember.age}" readonly>
    전화번호 <input type="text" class="form-control mb-2" name="phone" value="${updateMember.phone}">
    <input class="btn btn-primary" type="button" value="정보수정" onclick="update()">
</form>
</body>
<script>
    const  update = () => {
        // 사용자가 입력한 비밀번호 값 가져오기
        const pass = document.getElementById("pwConfirm").value;
        // DB에서 가져온 비밀번호 가져오기
        const passDB = "${updateMember.pass}";
        // 비밀번호 일치하면 form태그에 입력한 내용을 컨트롤러로 요청.
        // 일치하지 않으면 alert으로 비밀번호 틀리다고 보여줌.
        if(pass == passDB) {
            updateForm.submit(); // 해당 폼을 submit 하는 js함수
        }else {
            alert("비밀번호가 틀립니다.");
        }
    }
</script>
</html>
