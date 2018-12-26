<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
<title>Comments - Delete</title>
</head>
<body>
<form name="deleteForm" action="CommentsDeleteAction.co" method="post">
<input type="hidden" name="com_no" value='<%=request.getParameter("com_no") %>'>
<input type="hidden" name="p_id" value='<%=request.getParameter("p_id") %>'>
<table>
	<tr>
		<td>사용자 비밀번호</td>
		<td>
			<input name="p_pw" type="password">
		</td>
	</tr>
	<tr>
		<td colspan=2>
		<a href="javascript:DeleteForm.submit()">삭제</a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">취소</a>
	</td>
	</tr>
</table>
</form>	

</body>
</html>