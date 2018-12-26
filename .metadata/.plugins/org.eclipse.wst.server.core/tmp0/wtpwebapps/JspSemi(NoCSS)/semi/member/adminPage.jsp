<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>
<html>
<head>
<title>ȸ������ �ý��� �����ڸ��(ȸ�� ��� ����)</title>
<style>
	table {
	margin: 0 auto;
	width: 400px;
	}
	td:nth-child(2n) {background: #adf1ad}
	td:nth-child(2n+1) {background: #cec8f1}
	tr:first-child>td {background: #e9c9b7}
	tr {text-align:center}
	td {height:30px}
	a {text-decoration: none}
</style>
</head>
<body>
	<%
		//�Ϲ�ȸ��
		List<PMemberBean> PList =
			(ArrayList<PMemberBean>)request.getAttribute("pmemlist");
		
		//���ȸ��
		List<EMemberBean> EList =
			(ArrayList<EMemberBean>)request.getAttribute("ememlist");
	%>
	<jsp:include page="../Header.jsp"></jsp:include>
	<table>
		<tr>
			<td colspan=2>����ȸ�� ���</td>
		</tr>
		<%
			for (PMemberBean m : PList) {
				if(m.getP_id().equals("admin"))
					continue;
		%>
		<tr>
			<td><a href="adminPinfo.com?id=<%=m.getP_id() %>">
				<%=m.getP_id() %></a></td>
		</tr>
		<%
			}
		%>
	</table>
	
		<table>
		<tr>
			<td colspan=2>���ȸ�� ���</td>
		</tr>
		<%
			for (EMemberBean m : EList) {
		%>
		<tr>
			<td><a href="adminEinfo.com?id=<%=m.getE_id() %>">
				<%=m.getE_id() %></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>