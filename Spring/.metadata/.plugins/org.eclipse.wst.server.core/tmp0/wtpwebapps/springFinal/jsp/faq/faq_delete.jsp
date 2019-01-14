<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>자료실 삭제폼</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/qa.css" />
<script src="./resources/js/jquery-3.2.1.js"></script>
<script>
 function check(){
	 if($.trim($("#pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#pwd").val("").focus();
		 return false;
	 }
 }
</script>
</head>
<body>
  <div id="del_wrap">
   <h2 class="del_title">FAQ 삭제</h2>
   <form method="post" action="faq_delete_ok.nhn"
   onsubmit="return check()">
   <input type="hidden" name="faq_num" value="${faqbean.faq_num}" />
   <input type="hidden" name="page" value="${page}" />
   
   <table id="del_t">
    <tr>
     <th>PW</th>
     <td>
      <input type="password" name="pwd" id="pwd" size="14"
      class="input_box" />
     </td>
    </tr>
   </table>
   
   <div id="del_menu">
    <input type="submit" value="삭제" class="input_button"
    style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"/>
    <input type="reset" value="취소" class="input_button"
    style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"
    onclick="history.back();" />
   </div>
   </form>
  </div>
</body>
</html>