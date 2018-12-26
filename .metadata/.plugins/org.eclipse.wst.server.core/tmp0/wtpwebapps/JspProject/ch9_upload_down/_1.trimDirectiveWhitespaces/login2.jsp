<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%--���� �� ������ �ҽ� ���⸦ ���ϴ�.
	html �±� �������� �ٹٲ� ���� ���ڰ� �ֽ��ϴ�.
	�̰��� �����ϱ� ���� trimDirectiveWhitespaces="true"���� �����մϴ�.
	JSP�������� ���� ��� ���������� ��Ƽ�곪 ��ũ��Ʈ�� �ִ� �κ��� ��������
	ǥ�õǴ� ���� ���� ����� ���Ե��� �ʵ��� �մϴ�.
--%>
<%
	boolean isIDShow = false;
	String id = null;
	
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("id")){
				isIDShow = true;
				id = cookies[i].getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>��Ű�� �̿��� ȭ�� ���� ����</title>
		<style>
			body {
				margin: 10px auto;
				width: 400px;
			}
			
			fieldset {
				width: 100%;
			}
		</style>
	</head>
	<body>
		<fieldset>
			<form action="loginprocess2.jsp" method="post">
			<%
				if (isIDShow) {
			%>
				<div>ID:</div>
				<input type="text" name="id" value="<%=id%>" id="id" class="length">
				<input type="checkbox" name="idstore" value="store" checked>ID ����ϱ�<br>
			<%
				} else {
			%>
				<div>ID:</div>
				<input type="text" name="id" id="id" class="length">
				<input type="checkbox" name="idstore" value="store">ID ����ϱ�<br>
			<%
				}
			%>
				<div>password:</div>
				<input type="text" name="pass" class="length" id="pass"><br>
				<input type="submit" value="����">
			</form>		
		</fieldset>
	</body>
</html>