<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>
<html>
<head>
<title>ȸ������ �ý��� �����ڸ��(ȸ�� ��� ����)</title>

<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>

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
	<jsp:include page="../menubar.jsp"></jsp:include>
	<table class="admin-table">
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
	
		<table class="admin-table">
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
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>