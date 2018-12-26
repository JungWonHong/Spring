<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	boolean isChecked = false;
	String checked = request.getParameter("idstore");
	if(checked!=null && checked.equals("store")){
		isChecked = true;
		Cookie cookie = new Cookie("id", request.getParameter("id"));
		cookie.setMaxAge(60*2);
		
		response.addCookie(cookie);
	}
%>
<html>
	<head>
		<title>Insert title here</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%
			String id = request.getParameter("id");
			String pw = request.getParameter("pass");
			String sid = application.getInitParameter("ID");
			String spw = application.getInitParameter("Pass");
			
			if(id.equals(sid) && pw.equals(spw)){
		%>
		<script>
			alert(<%=sid%> + "님 환영합니다.");
		</script>
		<%
			} else if (!(id.equals(sid))) {
		%>
		<script>
			alert("로그인 ID가 다릅니다.");
			history.back();
		</script>
		<%
			} else if (!(pw.equals(spw))) {
		%>
		<script>
			alert("패워드가 다릅니다.");
			history.back();
		</script>
		<%
			}
		%>
		
		로그인에 성공했습니다.<br><br>
		<%
			if (!isChecked) {
		%>
		<a href="loginCheck.jsp">로그인 체크</a>
		<%
			} else {
		%>
		<a href="loginCheck.jsp">로그인 체크</a>
		<a href="login.jsp">로그인 화면 다시 보기</a>
		<%
			}
		%>
	</body>
</html>