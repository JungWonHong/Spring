<!-- ��ȿ�� �˻� -->
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
<h2>������ �Ӽ� �׽�Ʈ</h2>
<form action="attributeTest1.jsp" method="post">
<table border="1">
	<tr><td colspan="2">Application ������ ������ �����</td></tr>
	<tr>
		<td>�̸�</td>
		<td><input type="text" name="name" id="name"></td>
	</tr>
	<tr>
		<td>���̵�</td>
		<td><input type="text" name="id" id="id"></td>
	</tr>
	<tr >
		<td colspan="2" ><input type="submit" value="����"></td>
	</tr>
</table>
</form>
</body>
</html>
