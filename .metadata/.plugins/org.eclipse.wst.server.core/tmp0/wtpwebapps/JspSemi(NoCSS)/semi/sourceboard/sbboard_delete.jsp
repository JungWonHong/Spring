<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	//���޹��� �Ķ������ ������ �� ��ȣ�� num ������ �����մϴ�.
	//list ���������� �޾ƿ� ��
	int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>�ڵ� �Խ���</title>
<script>
	function windowclose() {
		self.close();
	}

	function goSubmit() {
		window.opener.name = "parentPage"; // �θ�â�� �̸� ����
		document.sbdeleteForm.target = "parentPage"; // Ÿ���� �θ�â���� ����
		document.sbdeleteForm.action = "sbBoardDeleteAction.bo";
		document.sbdeleteForm.submit();
		self.close();
	}
</script>
</head>
<body>
	<form name="sbdeleteForm" action="sbBoardDeleteAction.bo" method="post">
		<input type="hidden" name="sb_no" value='<%=num%>'>
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