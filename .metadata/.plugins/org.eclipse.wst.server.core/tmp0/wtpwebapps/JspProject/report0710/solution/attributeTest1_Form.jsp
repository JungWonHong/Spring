<!-- 유효성 검사 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!Doctype html>
<html>
<head>
 <title>Attribute Test Form</title>
 <script src="../../js/jquery-3.2.1.js" ></script>
 <script src="ch5-2.js" charset="euc-kr"></script>
 <link rel="stylesheet" href="ch5-3.css" 
       type="text/css">
</head>
<body>
<h2>영역과 속성 테스트</h2>
<form action="attributeTest1.jsp" method="post">
<table border="1">
	<tr><td colspan="2">Application 영역에 저장할 내용들</td></tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" id="id"></td>
	</tr>
	<tr >
		<td colspan="2" ><input type="submit" value="전송"></td>
	</tr>
</table>
</form>
</body>
</html>
