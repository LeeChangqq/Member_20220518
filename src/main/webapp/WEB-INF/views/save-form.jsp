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
    <input type="submit" value="전송">
</form>
</body>
<script>
    const id2 = document.getElementById("id2").value;
    $uid= $_GET["id2"];  //GET으로 넘긴 userid
    $sql= "SELECT * FROM member where login_id='$uid'";
    function idCheck() {
        if(id2.isEqualNode($uid)) {
            alert("중복");
        }
    }
</script>
</html>
