<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
   <title>KHCC - 회원가입</title>
<!-- <link rel="stylesheet" type="text/css" href="./resources/css/admin2.css">
<link rel="stylesheet" type="text/css" href="./resources/css/member2.css"> -->
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/member4.js"></script>
<style>
.jointitle{
      font-size: 30pt;
      font-weight: bold;
      margin-left: 14%;
      margin-top:15%;
      color: #2ABCB4;
   
       }
.divhr{
          width:1300px;
           height:50px;
           background-color:#2ABCB4;
           border:1px solid lightgray; 
           margin-top:5%;
           margin-left:13%; 
    }
#join_wrap{
/*          border-bottom: 1px solid lightgray;
          border-top:1px solid lightgray; */
          border:1px solid lightgray;
          width:1300px;
          height:660px;
          margin-left:13%;          
          }
#join_t{margin-left:3%;}
.jointh{margin-left:10%; font-size:15pt; height:90px;  width:200px; }
.input_box{width:200px; height:40px;}
.input_select{width:150px; height:40px;}
.input_selectp{width:100px; height:40px;}
.joinbtdiv{margin-left:104%; margin-top:-7%;}
#join_menu{margin-left:40%; margin-top:4%;}
#idcheck{margin-top:2%;}
</style>
</head>
<body>
<%@ include file = "../include/menubar_nologin.jsp" %>
<div class="jointitle">회원가입</div>
<div class="divhr"></div>
<section id="home" style="display:block">

<div id="join_wrap">
      <form name="f" method="post" action="member_join_ok.nhn"
         onsubmit="return check()">
         <table id="join_t">
            <tr>
               <th class="jointh">이메일</th>
               <td>
                  <input name="m_email" id="m_email" class="input_box"> @
                  <input name="m_maildomain" id="m_maildomain"  class="input_box" readonly>
                  <!--readonly는  쓰기, 수정이 불가능하고 읽기만 가능합니다. --> 
                  <select name="mail_list" id="mail_list"  class="input_select" onchange="domain_list()">
                     <option value="">=이메일선택=</option>
                     <option value="daum.net">daum.net</option>
                     <option value="nate.com">nate.com</option>
                     <option value="naver.com">naver.com</option>
                     <option value="hotmail.com">hotmail.com</option>
                     <option value="gmail.com">gmail.com</option>
                     <option value="0">직접입력</option>
                  </select>
                  <div class="joinbtdiv">
                  <input type="button" value="이메일 중복체크" class="btn btn-default"
                        onclick="id_check()">
                  </div>
                  <div id="idcheck"></div>
                  
               </td>
            </tr>

            <tr>
               <th class="jointh">비밀번호</th>
               <td>
                  <input type="password" name="m_password" id="m_pwd1"
                     size="14" class="input_box">
               </td>
            </tr>

            <tr>
               <th class="jointh">비밀번호 확인</th>
               <td class="jointd">
                  <input type="password" name="m_password2" id="m_pwd2"
                     size="14" class="input_box">
               </td>
            </tr>

            <tr>
               <th class="jointh">생년월일</th>
               <td class="jointd">
                  <input name="m_birth" id="m_birth" size="10" class="input_box" 
                        maxlength="8" placeholder="ex)19921104">
               </td>
            </tr>
            
            <tr>
               <th class="jointh">이름</th>
               <td class="jointd">
                  <input name="m_name" id="m_name" size="14" class="input_box">
               </td>
            </tr>

            <tr>
               <th class="jointh">휴대전화번호</th>
               <td class="jointd">
                  <%@ include file="/jsp/include/mypage_include.jsp" %>
                  <select name="m_phone1"  class="input_selectp">
                     <c:forEach var="p" items="${phone}">
                        <option value="${p}">${p}</option>
                     </c:forEach>
                  </select>  -
                  <input name="m_phone2" id="m_phone2" size="4" maxlength="4" class="input_box"> -
                  <input name="m_phone3" id="m_phone3" size="4" maxlength="4" class="input_box">
               </td>
            </tr>
         </table>

         <div id="join_menu">
            <input type="submit" value="회원가입" class="btn btn-default"> &ensp;
            <input type="reset" value="가입취소" class="btn btn-default"
               onclick="$('#m_email').focus();">
               
         </div>
      </form>
   </div>
   <br><Br>
      
   <script type="text/javascript" src="./resources/bootstrap-js/jquery.js"></script> 
   <script type="text/javascript" src="./resources/bootstrap-js/bootstrap.min.js"></script>
   <script type="text/javascript" src="./resources/bootstrap-js/smoothscroll.js"></script> 
   <script type="text/javascript" src="./resources/bootstrap-js/jquery.isotope.min.js"></script>
   <script type="text/javascript" src="./resources/bootstrap-js/jquery.prettyPhoto.js"></script> 
   <script type="text/javascript" src="./resources/bootstrap-js/jquery.parallax.js"></script> 
   <script type="text/javascript" src="./resources/bootstrap-js/main.js"></script> 
</section><!--/#home-->
</body>
</html>
s