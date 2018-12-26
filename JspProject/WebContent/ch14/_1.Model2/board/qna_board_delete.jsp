<!--  글 삭제 폼 페이지 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
    //전달받은 파라미터인 삭제할 글 번호를 num변수에 저장합니다.
	int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
 <title>MVC 게시판</title>
 <link href="css/ch14_1.css" rel="stylesheet" type="text/css">
</head>
<body>
 <form name="deleteForm" 
       action="BoardDeleteAction.bo" 
	   method="post">
  <input type="hidden" name="num" value='<%=num %>'>	   
  <table border="1">
   <tr>
	<th>글 비밀번호</th>
	<td>
		<input name="BOARD_PASS" type="password">
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