<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Forward Action Test</title>
		<link rel="stylesheet" href="../../../css/ch5-4.css" type="text/css">
	</head>
	<body>
		<h2>Include �׼� �׽�Ʈ</h2>
		<form action="includeTest2.jsp" method="post">
			
			<!-- hidden Ÿ���� input���� ���� ���������� ����� �ּҰ��� �����Ͽ����ϴ�. -->
			<input type="hidden" name="includePage" value="includeTest3.jsp">

			<table>
				<tr>
					<td>�̸�</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>�ּ�</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="����"></td>
				</tr>
			</table>
		</form>
	</body>
</html>