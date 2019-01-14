<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>로그인</title>
<!-- <link rel="stylesheet" type="text/css" href="./resources/css/admin2.css">
<link rel="stylesheet" type="text/css" href="./resources/css/member2.css"> -->
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/member4.js"></script>
<script>
   function check() {
      if($.trim($("#login_email").val()) == "") {
         alert("이메일을 입력하세요!");
         $("#login_email").val("").focus();
         return false;
      }
      if($.trim($("#login_password").val()) == "") {
         alert("비밀번호를 입력하세요!");
         $("#login_password").val("").focus();
         return false;
      }
   }
   
   /* 비밀번호 찾기 팝업창 */
   function pwd_find() {
      window.open("pwd_find.nhn", "비밀번호 찾기", "width=400, height=300");
      // 자바 스크립트에서 window 객체의  open("팝업창 경로와 파일명", "팝업창 이름", "팝업창 속성");
      // 메서드로 새로운 팝업창을 만듭니다. 
      // 폭이 400, 높이가 300인 새로운 팝업창. 단위는 픽셀
   }
</script>
<style>
#login_wrap{
      width:600px; height:350px;
   margin-top:14%; margin-left:auto; margin-right:auto;
   border:1px solid lightgray;
   border-radius:20px;
   box-shadow:15px 15px 15px lightgray;

}

.login_title{margin-left:40%; margin-top:7%; color:#2ABCB4; font-weight:bold; font-size:30pt;}
.emailth {
    margin-left: 14%;
    font-size: 15pt;
    padding-top: 6%;
}
.passth {
    margin-left: 12%;
    padding-top: 3%;
    font-size: 15pt;
}

.input_box1 {
    width: 250px;
    height: 30px;
    margin-left: 32%;
    margin-top: -4.5%;
}
.input_box2 {
    width: 250px;
    height: 30px;
    margin-left: 32%;
    margin-top: -4.5%;
}
#login_menu {
    padding-left: 21%;
    padding-top: 10%;
}
#login_t{margin-top:5%;}

</style>
</head>
<body>
<c:if test="${!empty login_email}">
<%@ include file = "../include/menubar_login.jsp" %>
</c:if>

<c:if test="${empty login_email}">
<%@ include file = "../include/menubar_nologin.jsp" %>
</c:if>
   <div id="login_wrap">
      <h2 class="login_title">로그인</h2>
      <form method="post" action="khcc_login_ok.nhn" onsubmit="return check()">
         <div id="login_t">
              
               <div class="emailth">이메일</div>
         
                  <input name="login_email" id="login_email" class="input_box1">
      
            
            
               <div class="passth">비밀번호</div>
            
                  <input type="password" name="login_password" id="login_password"
                        class="input_box2">
         
            
         </div>
         <div id="login_menu">
            <input type="submit" value="로그인" class="btn btn-default">
            <a class="btn btn-default" onclick="href='khcc_join.nhn'">회원가입</a>
            <input type="reset" value="취소" class="btn btn-default" 
                  onclick="$('#login_email').focus();">
            <input type="button" value="비밀번호 찾기" class="btn btn-default"
                  onclick="pwd_find()">
         </div>
      </form>
   </div>
</body>
</html>