<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-18
  Time: 오후 4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="save" method="post">
    <input type="text" id="id2" name="id2" placeholder="id2"><br>
    <input type="text" name="pass" placeholder="pass"><br>
    <input type="text" name="name" placeholder="name"><br>
    <input type="text" name="age" placeholder="age"><br>
    <input type="text" name="phone" placeholder="phone"><br>
    <input type="submit" value="전송" onclick="id2Check()">
    <button>버튼tag가입</button><!-- form태그 안에서 쓰면 form안에 내용이 submit이 됨 -->
    <input type="button" value="button타입"><!-- form태그 안에서 쓰고 싶으면 이와 같이 사용 -->
</form>
</body>
<script>
    function id2Check() {
        const id2 = document.getElementById("id2").value;
        const exp = /^[a-z]{5,10}$/;
        if(id2.match(exp)) {

        }else {
            alert("형식에 맞게 적어");
        }
    }
</script>
</html>
