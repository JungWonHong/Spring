<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<html>
	<head>
		<title>application Test - �ʱ�ȭ �Ķ���� �о����</title>
	</head>
	<%--
		application�� ������ ���۵ż� ���������� ����ִ�(���� ���)
		-�ʱ�ȭ �Ķ���ʹ� web.xml�� �ۼ��մϴ�.
		getInitParameterNames() :
			�� ���ø����̼� �ʱ�ȭ �Ķ������ �̸� ����� �����մϴ�.
		getInitParameter(Name) :
			�̸��� Name�� �� ���ø����̼� �ʱ�ȭ �Ķ������ ���� �о�ɴϴ�.
			�������� ���� ��� null�� �����մϴ�.
	 --%>
	<body>
		<h2>�ʱ�ȭ �Ķ���� ���</h2>
		<ul>
			<%
				Enumeration initParamEnum =
						application.getInitParameterNames();
			
				while (initParamEnum.hasMoreElements()){
					String initParamName =
							(String)initParamEnum.nextElement();
			%>
			<li>
				<%=initParamName %> =
				<%=	application.getInitParameter(initParamName) %>
			</li>
			<%
				}
			%>		
		</ul>
	</body>
</html>