<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	//���޹��� �Ķ������ ������ �� ��ȣ�� num ������ �����մϴ�.
	//list ���������� �޾ƿ� ��
	int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>Review �Խ��� - ����</title>
<script>
	function windowclose() {
		self.close();
	}

	function goSubmit() {
		window.opener.name = "parentPage"; // �θ�â�� �̸� ����
		document.rvdeleteForm.target = "parentPage"; // Ÿ���� �θ�â���� ����
		document.rvdeleteForm.action = "rvBoardDeleteAction.bo";
		document.rvdeleteForm.submit();
		self.close();
	}
</script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
<style>
table {width:500px}
</style>
</head>
<body>
	<form name="rvdeleteForm" action="rvBoardDeleteAction.bo" method="post">
		<input type="hidden" name="rv_no" value='<%=num%>'>
		<table>
			<tr>
				<th colspan=2>���� �Ͻðڽ��ϱ�?</th>
			</tr>
			<tr>
				<td colspan=2><a href="javascript:goSubmit()">����</a>
					&nbsp;&nbsp; <a href="javascript:windowclose()">���ư���</a></td>
			</tr>
		</table>
	</form>
</body>
</html>