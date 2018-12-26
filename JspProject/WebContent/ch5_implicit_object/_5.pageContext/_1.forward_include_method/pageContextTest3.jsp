<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%! 
			public int sum(int a, int b){
				return a+b;
			}
		%>
		µ¡¼ÀÀÇ °á°ú : <%=sum(20, 30) %>
	</body>
</html>