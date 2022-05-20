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
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<form action="save" method="post">
    <input type="text" onblur="duplicateCheck()" id="id2" name="id2" placeholder="id2">
    <span id="dup-check-result"></span><br>
    <input type="text" name="pass" placeholder="pass"><br>
    <input type="text" name="name" placeholder="name"><br>
    <input type="text" name="age" placeholder="age"><br>
    <input type="text" name="phone" placeholder="phone"><br>
    <input type="submit" value="전송">
    <button>버튼tag가입</button><!-- form태그 안에서 쓰면 form안에 내용이 submit이 됨 -->
    <input type="button" value="button" id="a" onclick="idCheck()"><!-- form태그 안에서 쓰고 싶으면 이와 같이 사용 -->
</form>
</body>
<script>
    const duplicateCheck = () => {
        const id2 = document.getElementById("id2").value;
        const checkResult = document.getElementById("dup-check-result");
        console.log(id2);
        $.ajax({
            type: "post", // http request method
            url: "duplicate-check", // 요청주소(컨트롤러 주소값)
            data: {"id2": id2,}, // 전송하는 파라미터
            data_type: "text", // 리턴받을 데이터 형식
            success: function (check) {
                if(id2 == "") {
                 checkResult.innerHTML = "아이디를 입력하세요.";
                 checkResult.style.color = "red";
                }else if(check == "ok") {
                    // 사용가능한 아이디
                    checkResult.innerHTML = "사용 가능한 아이디입니다.";
                    checkResult.style.color = "green";
                }else {
                    // 이미 사용중인 아이디
                    checkResult.innerHTML = "이미 사용중인 아이디입니다.";
                    checkResult.style.color = "red";
                }
                // alert("ajax 성공");
            },
            error: function () {
                // alert("오타체크");
            }
        });
    }
    const idCheck = () => {
        const id2 = document.getElementById("id2").value;
        const a = document.getElementById("a");
        $.ajax({
            type: "post", // http request method
            url: "idCheck", // 요청주소(컨트롤러 주소값)
            data: {"id2": id2,}, // 전송하는 파라미터
            data_type: "json", // 리턴받을 데이터 형식
            success: function (data) {
                if(data == "no") {
                    alert("아이디를 다시 입력해 주세요.")
                    id2.innerHTML = "";
                }else {

                }
            },
            error: function () {
                alert("오타체크");
            }
        });
    }
</script>
</html>
