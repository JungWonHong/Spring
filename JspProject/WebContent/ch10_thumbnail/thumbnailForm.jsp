<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>�����</title>
		<style>
			h3 {
				text-align: center;
			}
			table {
				margin: 0 auto;
				text-align: center;
			}
			.yellow {
				background: yellow;
			}
			.green {
				background: green;
			}
		</style>
	</head>
	<body>
		<h3>����� �̹��� �� ����</h3>
		<form action="thumbnail.jsp" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td class="yellow">�̹��� ����</td>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>
					<td colspan=2 class="green">
						<input type="submit" value="����">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>