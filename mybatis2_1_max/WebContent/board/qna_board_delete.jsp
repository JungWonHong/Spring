<!--  글 삭제 폼 페이지 -->
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
 <title>MVC 게시판</title>
 <link href="css/ch14_1.css" rel="stylesheet" type="text/css">
</head>
<body>
 <form name="deleteForm" 
       action="BoardDeleteAction.bo?num=${param.num }" 
	   method="post">
  <input type="hidden" name="page" value='${param.page }'>	   
  <table border="1">
   <tr>
	<th>글 비밀번호</th>
	<td>
		<input name="BOARD_PASS" id="board_pass" type="password">
	</td>
   </tr>
   <tr>
	<td colspan=2 class="h30 center lime">
	    <!-- 삭제 버튼을 클릭하면 폼을 submit 합니다. -->
		<a href="javascript:deleteForm.submit()">삭제</a>
		&nbsp;&nbsp;
		<!-- 돌아가기를 클릭하면 이전 페이지로 이동합니다. -->
		<a href="javascript:history.go(-1)">돌아가기</a>
	</td>
</tr>
</table>
</form>
</body>
</html>