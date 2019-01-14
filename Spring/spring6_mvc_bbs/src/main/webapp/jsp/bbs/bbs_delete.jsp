<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>자료실 삭제폼</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/bbs.css" />
<script src="./resources/js/jquery.js"></script>
<script>
 function check(){
	 if($.trim($("#pwd").val())==""){
		 alert("삭제 비번을 입력하세요!");
		 $("#pwd").val("").focus();
		 return false;
	 }
 }
</script>
</head>
<body>
  <div id="del_wrap">
   <h2 class="del_title">자료실 삭제</h2>
   <form method="post" action="bbs_delete_ok.nhn"
   onsubmit="return check()">
   <input type="hidden" name="bbs_num" value="${bbsbean.bbs_num}" />
   <input type="hidden" name="page" value="${page}" />
   
   <table id="del_t">
    <tr>
     <th>비밀번호</th>
     <td>
      <input type="password" name="pwd" id="pwd" size="14"
      class="input_box" />
     </td>
    </tr>
   </table>
   
   <div id="del_menu">
    <input type="submit" value="삭제" class="input_button">
    <input type="reset" value="취소" class="input_button"
    onclick="$('#pwd').focus();" />
   </div>
   </form>
  </div>
</body>
</html>