<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>비번찾기</title>
<!-- <link rel="stylesheet" type="text/css" href="./resources/css/admin.css">
<link rel="stylesheet" type="text/css" href="./resources/css/member.css"> -->
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/member4.js"></script>
<script>
   function check() {
      if ($.trim($("#id").val()) == "") {
         alert("아이디를 입력하세요!");
         $("#id").val("").focus();
         return false;
      }
      if ($.trim($("#name").val()) == "") {
         alert("회원이름을 입력하세요!");
         $("#name").val("").focus();
         return false;
      }
   }
</script>
<style>
.pwd_title{margin-left:3%; margin-left:35%; font-size:20pt; font-weight:bold;}
#pwd_t{margin-left:9%; margin-top:10%;  border:1px solid lightgray; width: 320px; background: whitesmoke;}
th{font-size:15pt; height:50px; width:130px;}
#pwd_menu{margin-left:17%; margin-top:5%;}
.input_box{width:150px; height:18px;}
.input_button{
     color: #333;
    background-color: #fff;
    border-color: #ccc;
    display: inline-block;
    padding: 6px 12px;
    margin-bottom: 0;
    font-size: 14px;
    font-weight: normal;
    line-height: 1.428571429;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    background-image: none;
    border: 1px solid lightgray;
    border-radius: 4px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    -o-user-select: none;
    user-select: none;
    width:80px;
    }
</style>
</head>
<body>
   <c:if test="${empty pwdok}">
      <h2 class="pwd_title">비번찾기</h2>
      <form method="post" action="pwd_find_ok.nhn" onsubmit="return check()">
         <table id="pwd_t">
            <tr>
               <th>아이디</th>
               <td><input name="id" id="id"  class="input_box"></td>
            </tr>

            <tr>
               <th>회원이름</th>
               <td><input name="name" id="name"  class="input_box"></td>
            </tr>
         </table>
         <div id="pwd_menu">
            <input type="submit" value="찾기" class="input_button">
             <input type="reset" value="취소" class="input_button" onclick="$('#id').focus();">
            <input type="button" value="닫기" class="input_button" onclick="self.close();">
            <!-- close()메서드로 공지창을 닫는다. self.close()는 자바스크립트이다. -->
         </div>
      </form>
   </c:if>

   <c:if test="${!empty pwdok}">
      <h2 class="pwd_title2">비번찾기 결과</h2>
      <table id="pwd_t2">
         <tr>
            <th>검색한 비번:</th>
            <td>${pwdok}</td>
         </tr>
      </table>
      <div id="pwd_close2">
         <input type="button" value="닫기" class="input_button"
            onclick="self.close();">
         <!-- close()메서드로 공지창을 닫는다. self.close()는 자바스크립트이다. -->
      </div>
   </c:if>
</body>
</html>