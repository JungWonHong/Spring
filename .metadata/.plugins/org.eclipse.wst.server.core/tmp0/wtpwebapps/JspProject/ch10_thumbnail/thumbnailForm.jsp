<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>썸네일</title>
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
		<h3>썸네일 이미지 폼 예제</h3>
		<form action="thumbnail.jsp" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td class="yellow">이미지 파일</td>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>
					<td colspan=2 class="green">
						<input type="submit" value="전송">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>