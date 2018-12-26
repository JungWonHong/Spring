<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JOBS - Login</title>
<link href="./css/login.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>

	<form action="loginProcess.com" method="post">
		<div class="row">
	    <div class="col-md-12 text-center">
	      <h1 class="mrng-60-top">로그인</h1>
	    </div>
		</div>
		<table>
			<tr>
				<td>ID &nbsp;</td>
				<td><input type="text" name="id"></td>
				<td rowspan=2><input type="submit" value="login"></td>
			</tr>
			<tr>
				<td>PW &nbsp;&nbsp;</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr class="member-check">
				<td colspan=3><input type="radio" name="memkind" value="1" checked>개인회원 &nbsp;
							<input type="radio" name="memkind" value="2">기업회원
				</td>
			</tr>
			<tr class="join-tr">
				<td colspan=3><a href="./pjoin.com">회원가입</a></td>
			</tr>
		</table>
	</form>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>