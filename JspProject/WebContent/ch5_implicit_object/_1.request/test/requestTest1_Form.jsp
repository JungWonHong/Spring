<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Request Test(Form)</title>
		<style>
			h1 { text-align: center }
			table { width: 400px; margin: 0 auto }
			tr>td:nth-child(2n+1) { background: orange }
			tr>td:nth-child(2n) { background: yellow }
			tr:last-child>td { background: green; text-align: center}
			.name { width: 98%; margin: 0 1% }
		</style>
	</head>
	<body>
		<h1>Request �����Դϴ�.</h1>
		<form action="requestTest2.jsp" method="post">
			<table border="1">
				<tr>
					<td>�̸�</td>
					<td><input type="text" name="name" class="name"></td>
				</tr>
				
				<tr>
					<td>����</td>
					<td>
						��<input type="radio" name="gender" value="male">
						��<input type="radio" name="gender" value="female">
					</td>
				</tr>
				
				<tr>
					<td>���</td>
					<td>
						����<input type="checkbox" name="hobby" value="����">
						����<input type="checkbox" name="hobby" value="����">
						TV��û<input type="checkbox" name="hobby" value="TV��û">
						�౸<input type="checkbox" name="hobby" value="�౸">
						��Ÿ<input type="checkbox" name="hobby" value="��Ÿ">
					</td>
				</tr>
				
				<tr>
					<td colspan = 2><input type="submit" value="����"></td>
				</tr>
			</table>
		</form>
	</body>
</html>