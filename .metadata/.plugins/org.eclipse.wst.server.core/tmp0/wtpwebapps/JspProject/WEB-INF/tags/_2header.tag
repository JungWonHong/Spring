<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag trimDirectiveWhitespaces="true" %>

<%--attribute ��Ƽ��� �Ӽ��� �����մϴ�.
	attribute ��Ƽ��� �Ӽ��� ��ũ��Ʈ���̳�
	EL ǥ�� ���� ������ ����� �� �ֽ��ϴ�.
  ��) <%@ attribute name="title" required="true" %>
  	....
  	<%=title> �Ǵ� ${title}
  	
  	name="title" : �Ӽ��� �̸��� title
  	required="true" : title �Ӽ��� �ʼ��Դϴ�.
--%>
<%@ attribute name="title" required="true" %>

<%-- 
	name="level" : �Ӽ��� �̸��� level�� ���մϴ�.
	type="java.lang.Integer" : level �Ӽ��� Ÿ���� Integer�Դϴ�.
--%>
<%@ attribute name="level" type="java.lang.Integer" %>
<%
	String headStartTag = null;
	String headEndTag = null;
	
	if(level == null){ //level �Ӽ��� �������� ���� ���
		headStartTag = "<h1>";
		headEndTag	 = "</h1>";
	} else if(level == 1){
		headStartTag = "<h1>";
		headEndTag	 = "</h1>";
	} else if(level == 2){
		headStartTag = "<h2>";
		headEndTag	 = "</h2>";
	} else if(level == 3){
		headStartTag = "<h3>";
		headEndTag	 = "</h3>";
	}
%>
<%= headStartTag %>
${title} <%-- �� �±� ������ ����ϴ� JSP�� title �Ӽ��� �̿��ؼ�
			   �±� ���Ͽ� ���� ������ �� �ְ� ���� ���� ���� ����մϴ�. --%>
<%= headEndTag %>