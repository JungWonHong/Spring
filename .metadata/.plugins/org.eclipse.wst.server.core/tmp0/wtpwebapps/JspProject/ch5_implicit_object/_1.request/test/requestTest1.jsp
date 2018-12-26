<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- �Ķ���� �ѱ� ó���� ���� request ��ü�� ���� �� ���ڵ� �����
	 euc-kr�� �����Ͽ����ϴ�. -->
<% request.setCharacterEncoding("euc-kr"); %>
<html>
	<head>
		<title>Request Test(request1.jsp)</title>
		<style>
			h1 { text-align: center }
			table { width: 400px; margin: 0 auto}
			td { text-align: center }
		</style>
	</head>
	<body>
		<h1>Request ���� �Դϴ�.</h1>
		<table border="1">
			<tr>
				<td>�̸�</td>
				<%--name�Ķ���� ���� ���ͼ� ǥ�������� ����մϴ�. --%>
				<td><%=request.getParameter("name")%></td>
			</tr>
			
			<tr>
				<td>����</td>
				<td>
				<%
					if(request.getParameter("gender").equals("male")) {
				%>
				����
				<% 
					} else {
				%>
				����
				<% 
					}
				%>
				</td>
			</tr>
			
			<tr>
				<td>���</td>
				<td>
				<%-- hobby�� �̸��� ���� �Ķ���ʹ� ���� ���� ���� ���� �� �����Ƿ�
					 getParameterValues()�޼��带 ����Ͽ� String �迭��
					 ���� �����ɴϴ�. 
				--%>
				<%
					String[] hobby = request.getParameterValues("hobby");
					for(int i=0;i<hobby.length;i++){
				%>
				<%=hobby[i]%> &nbsp;&nbsp;
				<%
					}
				%>
				</td>
			</tr>
		</table>
	</body>
</html>