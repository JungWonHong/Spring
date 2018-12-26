<%-- --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String language = "korea";

	//header�� �̸� �߿��� cookie�� ���� �����ɴϴ�.
	String cookie = request.getHeader("Cookie");

	//��Ű�� �����ϴ��� Ȯ���մϴ�.
	if (cookie != null) {
		//�����ϴ� ��Ű ���� �迭�� �����ɴϴ�.
		Cookie cookies[] = request.getCookies();

		//��Ű�� �̸��� "language"�� ���� ã�� ���� ��Ű �迭���� ��� Ȯ���մϴ�.
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("language")) {
				language = cookies[i].getValue();
			}
		}
		out.println(language);
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>��Ű�� �̿��� ȭ�� ���� ����</title>
		<style>
			body {
				margin: 100px auto;
				text-align: center;
				width: 500px;
			}
			
			fieldset {
				width: 100%;
			}
		</style>
	</head>
	<body>
		<%
			if (language.equals("korea")) {
		%>
		<h3>�ȳ��ϼ���. �̰��� ��Ű �����Դϴ�.</h3>
		<%
			} else {
		%>
		<h3>Hello. This is Cookie example.</h3>
		<%
			}
		%>
		<fieldset>
			<form action="cookieExample2.jsp" method="post">
				<input type="radio" name="language" value="korea"
					<%
						if (language.equals("korea")) {
					//��Ű���� Ȯ���Ͽ� korea�̸� �ѱ��� ������ ���⸦ ������ ���¸� �����մϴ�.
					%> checked <% } %> >�ѱ��� ������ ����
				<input type="radio" name="language" value="english"
					<%
						if (language.equals("english")) { //��Ű���� Ȯ���Ͽ� english�̸� ���� ������ ���⸦ ������ ���¸� �����մϴ�.
					%> checked <% } %> >���� ������ ����
				<input type="submit" value="����">
			</form>
		</fieldset>
	</body>
</html>