<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page autoFlush="true" %>
<!-- auFlush ������ �����ϴ� ��� �⺻������ true�� ����˴ϴ�. -->
<html>
	<head>
		<title>out Test(outTest3.jsp)</title>
	</head>
	<body>
		<h2>Out �׽�Ʈ</h2>
		<table border="1">
			<tr>
				<td>autoFlush ����</td>
				<td><%=out.isAutoFlush() %></td>
				<%--page ���þ��� autoFlush �Ӽ����� ������ ���� �����մϴ�.
					��� ���۰� �� ä������ �� ���� ������ Ŭ���̾�Ʈ�� �����ϵ��� �����Ǿ� ������
					true�� �����ϰ�
					��� ���۰� �� ä������ �� ���ܰ� �߻��ϵ��� �����Ǿ� ������ false�� �����մϴ�.
				 --%>
			</tr>
			<tr>
				<td>��� ������ ũ��</td>
				<td><%=out.getBufferSize() %>����Ʈ</td>
			</tr>
			<tr>
				<td>��� ������ ���� ��</td>
				<td><%=out.getRemaining() %>����Ʈ</td>
			</tr>
		</table>
	</body>
</html>