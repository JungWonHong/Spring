<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr"); %>
	<%--���۵� ������ �ѱ� ó���� ���� �ڵ� �Դϴ�.
		<jsp:param>�׼� �±״�
		request.setCharacterEncoding("euc-kr");�޼��带
		���ؼ� ������ ĳ���� ���� ����ؼ� ���Ե� �������� ������ ��û �Ķ������ ����
		���ڵ��մϴ�.
		<jsp:param>�׼� �±װ� ���ǵ� �������� �ۼ��մϴ�.
	 --%>
<html>
	<body>
		<h1>forwardTest2.jsp �Դϴ�.(���� ȭ�鿡�� ����������?)</h1>
		<%--forward �׼��� pageContext ���� ��ü�� forward()�޼ҵ尡 �±׷� ������
			����Դϴ�.
			forward �׼��� page �Ӽ��� ������ �̵��� �������� ���� �������� ��û�� ���信
			���� ó������ �ѱ�ϴ�.
			�̶�, �̵��ϱ� �� �������� ���� ��� ��� ������ ������ ����(������ ������ ������)�Ǹ�
			�̵��� �������� ��û�� ó���Ͽ� ������ �Ϸ�Ǹ�
			���� �������� ������� ���ư��� �ʰ� �� ���¿��� ��� ������ ����˴ϴ�. --%>
		<%-- page �Ӽ��� ������ �� ǥ���� ���ο� ū ����ǥ�� ���� �� �����Ƿ�
			 ���� ����ǥ�� ����Ͽ� ó���մϴ�.
			 ������ �Ǵ� �������� "tel"�̶� �̸����� ��ȭ��ȣ ���� �Ķ���ͷ� �����ϱ� ����
			 <jsp:param/>�±׸� ����߽��ϴ�..
		 --%>
		<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
			<jsp:param name="tel" value="010-1234-5678"/>
			<jsp:param name="alias" value="�����"/>
		</jsp:forward>
		
		<%="���� ����� �ɱ��?" %>
	</body>
</html>