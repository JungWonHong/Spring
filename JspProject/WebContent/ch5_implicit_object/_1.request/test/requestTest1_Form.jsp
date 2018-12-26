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
		<h1>Request 예제입니다.</h1>
		<form action="requestTest2.jsp" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" class="name"></td>
				</tr>
				
				<tr>
					<td>성별</td>
					<td>
						남<input type="radio" name="gender" value="male">
						여<input type="radio" name="gender" value="female">
					</td>
				</tr>
				
				<tr>
					<td>취미</td>
					<td>
						독서<input type="checkbox" name="hobby" value="독서">
						게임<input type="checkbox" name="hobby" value="게임">
						TV시청<input type="checkbox" name="hobby" value="TV시청">
						축구<input type="checkbox" name="hobby" value="축구">
						기타<input type="checkbox" name="hobby" value="기타">
					</td>
				</tr>
				
				<tr>
					<td colspan = 2><input type="submit" value="전송"></td>
				</tr>
			</table>
		</form>
	</body>
</html>