<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 확인</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<jsp:include page="../menubar.jsp"></jsp:include>
	
		<div class="row">
	    <div class="col-md-12 text-center">
	      <h1 class="mrng-60-top">탈퇴하기</h1>
	    </div>
		</div>
		
	<form action="EDelete.com" method="post" name="DeleteForm">
		<table>
		<%if(session.getAttribute("id").equals("admin")){ %>
		<h1>관리자 비밀번호</h1>
		<%} else { %>
		<h3>비밀번호 확인</h3>
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