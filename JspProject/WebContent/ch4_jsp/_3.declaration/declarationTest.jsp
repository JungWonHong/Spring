<%-- ����(Declarations)
	 JSP���������� �ڹ� �ڵ忡���� ��� ����(�ʵ�)�� �޼��带 �����ϱ� ����
	 ���˴ϴ�.
	 ������ ����� ����� ������ JSP������ �� �����̳ʿ� ���� ������ �� ��
	 ��� ������ �νĵǱ� ������ JSP �������� ��� ��ġ������ �ش� ������
	 �����ϴ� ���� �����մϴ�.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<h1><%=getStr() %></h1>
<%!
	private String getStr(){
		str += "�׽�Ʈ�Դϴ�.";
		return str;
	}
	
	private String str = "����";
%>