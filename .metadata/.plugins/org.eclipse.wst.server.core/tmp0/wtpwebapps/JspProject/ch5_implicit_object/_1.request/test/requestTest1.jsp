<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- 파라미터 한글 처리를 위해 request 객체의 문자 셋 인코딩 방식을
	 euc-kr로 지정하였습니다. -->
<% request.setCharacterEncoding("euc-kr"); %>
<html>
	<head>
		<title>Request Test(request1.jsp)</title>
		<style>
			h1 { text-align: center }
			table { width: 400px; margin: 0 auto}
			td { text-align: center }
		</style>
	</head>
	<body>
		<h1>Request 예제 입니다.</h1>
		<table border="1">
			<tr>
				<td>이름</td>
				<%--name파라미터 값을 얻어와서 표현식으로 출력합니다. --%>
				<td><%=request.getParameter("name")%></td>
			</tr>
			
			<tr>
				<td>성별</td>
				<td>
				<%
					if(request.getParameter("gender").equals("male")) {
				%>
				남자
				<% 
					} else {
				%>
				여자
				<% 
					}
				%>
				</td>
			</tr>
			
			<tr>
				<td>취미</td>
				<td>
				<%-- hobby란 이름을 가진 파라미터는 여러 개의 값을 가질 수 있으므로
					 getParameterValues()메서드를 사용하여 String 배열로
					 값을 가져옵니다. 
				--%>
				<%
					String[] hobby = request.getParameterValues("hobby");
					for(int i=0;i<hobby.length;i++){
				%>
				<%=hobby[i]%> &nbsp;&nbsp;
				<%
					}
				%>
				</td>
			</tr>
		</table>
	</body>
</html>