<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//��Ű ��ü�� �����ϰ� language�� ��Ű �̸��� �Է¹��� language���� ���� �����մϴ�.
	String val = request.getParameter("language");
	Cookie cookie = new Cookie("language", val);
	cookie.setMaxAge(60*60*24); //��Ű�� ��ȿ�ð��� 24�ð����� �����մϴ�.
	
	//�ð��� �������� ������(setMaxAge()�޼ҵ� ������� ���� ��)
	//������ ����� ��Ű�� �����˴ϴ�.
	//�޼��带 ȣ���� �� ���� ������ 0�� �ָ� ��Ű�� ���� �˴ϴ�.
	
	response.addCookie(cookie);//Ŭ���̾�Ʈ�� ��Ű���� �����մϴ�.
	
	
%>
<script>
	location.href = "cookieExample.jsp"; /*cookieExample.jsp�� ���ư��ϴ�. */
</script>