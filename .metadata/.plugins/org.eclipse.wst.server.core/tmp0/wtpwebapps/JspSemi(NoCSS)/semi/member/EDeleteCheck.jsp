<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 확인</title>
</head>
<body>
	<form action="EDelete.com" method="post" name="DeleteForm">
		<table>
		<%if(session.getAttribute("id").equals("admin")){ %>
		<h1>관리자 비밀번호</h1>
		<%} else { %>
		<h1>비밀번호 확인.</h1>
		<%} %>
			<tr>
				<td>PW</td>
				<td>
					<input type="password" name="e_pw">
					<input type="hidden" name="e_id" value=<%=request.getParameter("e_id") %>>
				</td>
			</tr>
			<tr>
			<td>
		<a href="javascript:DeleteForm.submit()" >[탈퇴]</a>&nbsp;&nbsp;
			</td>
			</tr>
		</table>
	</form>
</body>
</html>