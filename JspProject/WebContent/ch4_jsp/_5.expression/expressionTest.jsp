<%--
	ǥ����(Expression)
	���� �Ǵ� ��ũ��Ʈ�� �±׿��� ����� ������ �޼����� ���ϰ��� ����ϱ�
	���� ���Ǵ� ����Դϴ�.
	�� �����̳ʿ� ���� _jspService()�޼ҵ� ���ο� ��� ��ü��
	print()�޼ҵ� ��ȣ�ȿ�
	��°�� ���Ƿ� scriptlet���� �޸� �����ݷ��� ����ؼ��� �ȵ˴ϴ�.
	����)<%=����%>
		<%=���ϰ��� �ִ� �޼ҵ�%>
		<%=����%>
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!  
	public int sum(){
		int total = 0;
		for(int i=1;i<=100;i++){
			total += i;
		}
		return total;
	}
%>

<% 
	//������ �Ҵ��մϴ�.
	String str = "1���� 100������ ��";
%>
<html>
	<head>
		<title>Expression Test</title>
		<style>
			b { color: red}
		</style>
	</head>
	<body>
		<h2><%=str%>�� <b><%=sum() %></b>�Դϴ�.</h2>
		<br>
		<h2><%=str%>�� 3�� ���ϸ�<b><%=sum() * 3%></b>�� �˴ϴ�.</h2>
		<br>
		<h2><%=str%>�� 1000���� ������ <b><%=sum() / 1000.%></b>�˴ϴ�.</h2>
	</body>
</html>