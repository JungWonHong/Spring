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
		<h2>������ �Ӽ� �׽�Ʈ</h2>
		
		<h3>
		<%=application.getAttribute("name") %>�� �ݰ����ϴ�.<br>
		<%=application.getAttribute("name") %>���� 
		���̵�� <%=application.getAttribute("ID") %>�Դϴ�.
		</h3>
		<form action="completePage.jsp" method="post">
			<table border="1">
				<tr>
					<td colspan="2">Session ������ ������ �����</td>
				</tr>
				<tr>
					<td>e-mail �ּ�</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>�� �ּ�</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>��ȭ��ȣ</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="����"></td>
				</tr>
			</table>
		</form>
	</body>
</html>