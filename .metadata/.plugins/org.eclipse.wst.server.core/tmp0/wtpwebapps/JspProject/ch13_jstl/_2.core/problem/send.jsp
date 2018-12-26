<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("euc-kr");  %>
<html>
 <head>
 <style>
	h1 {text-align:center}
	table {margin:0 auto; width:400px}
	th {background : orange; width:30%}
	td {background : yellow; width:70%}
 </style>
 <title>send2.jsp</title>
 </head>

 <body>
	<h1> 회원 가입한 데이터</h1>
	<table border='1'>
		<tr>
			<th> ID </th>
			<td><%=request.getParameter("id")%></td>
		</tr>
		<tr>
			<th> 비밀번호 </th>
			<td><%=request.getParameter("pass")%></td>
		</tr>
		<tr>
			<th> 주민번호 </th>
			<td>
				<%=request.getParameter("jumin1")%> -
				<%=request.getParameter("jumin2")%>
			</td>
		</tr>
		<tr>
			<th> E-Mail </th>
			<td>
				<%=request.getParameter("email")%>@
				<% if(request.getParameter("sel").equals("")){ %>
				    <%=request.getParameter("domain")%>
				 <%}else{				 
				 %>   
				     <%=request.getParameter("sel")%>
				 <%} %>    
			</td>
		</tr>
		<tr>
			<th> 성별 </th>
			<td>
				<%
					if(request.getParameter("gender").equals("man")){
				%>
				남자
				<%
					}else{
				%>
				여자
				<%
					}
				%>
			</td>
		</tr>
		<tr>
			<th> 취미 </th>
			<td>
				<%
				   String[] hobby = request.getParameterValues("hobby");
					for(int i=0; i<hobby.length; i++){
				%>
					<%=hobby[i]%>&nbsp;
				<%
					}
				%>
			</td>
		</tr>
		<tr>
			<th> 우편번호 </th>
			<td><%=request.getParameter("post1") %> - <%=request.getParameter("post2") %></td>
		</tr>
		<tr>
			<th> 주소 </th>
			<td><%=request.getParameter("address") %></td>
		</tr>
		<tr>
			<th> 자기소개 </th>
			<td><%=request.getParameter("intro") %></td>
		</tr>
	</table>
</body>
</html>