<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>session</title>
		<script src="../js/jquery-3.2.1.js"></script>
		<script src="../js/report0710_2.js" charset="euc-kr"></script>
	</head>
	<body>
		<%
			request.setCharacterEncoding("euc-kr");
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			
			if (name != null && id != null) {
				application.setAttribute("name", name);
				application.setAttribute("ID", id);
			}
		%>
		<h2>영역과 속성 테스트</h2>
		
		<h3>
		<%=application.getAttribute("name") %>님 반갑습니다.<br>
		<%=application.getAttribute("name") %>님의 
		아이디는 <%=application.getAttribute("ID") %>입니다.
		</h3>
		<form action="completePage.jsp" method="post">
			<table border="1">
				<tr>
					<td colspan="2">Session 영역에 저장할 내용들</td>
				</tr>
				<tr>
					<td>e-mail 주소</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>집 주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="전송"></td>
				</tr>
			</table>
		</form>
	</body>
</html>