<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>REVIEW 삭제</title>
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
<style>
.del_title{margin-left:7%; margin-top:10%; font-size:20pt; font-weight: bold;}
.passth{margin-left:7%;}
.pwd_bt{padding:8px; margin-left:2%}
#del_t{margin-top:7%}
.qa_delbt{    
    width: 70px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;}
.qadel_back{
	width: 70px;
	height: 30px; 
	background: lightgray;
	border: 0px;
}
#del_menu{margin-left:23%; margin-top:5%}
</style>
</head>
<body>
  <div id="del_wrap">
 <div class="del_title">삭제하시겠습니까?</div>
   <form method="post" action="qa_delete_ok.nhn"
   onsubmit="return check()">
   <input type="hidden" name="qa_num" value="${qabean.qa_num}" />
   <input type="hidden" name="page" value="${page}" />
   
   <table id="del_t">
    <tr>
     <th class="passth">비밀번호</th>
     <td>
      <input type="password" name="pwd" id="pwd" size="14"
      class="pwd_bt" />
     </td>
    </tr>
   </table>
   
   <div id="del_menu">
     <input type="hidden" name="qa_num" value="${qabean.qa_num}" />
   <input type="hidden" name="page" value="${page}" />
    <input type="submit" value="삭제" class="qa_delbt"/>
    <input type="reset" value="취소" class="qadel_back"  onclick="history.back();" />
   </div>
   </form>
  </div>
</body>
</html>