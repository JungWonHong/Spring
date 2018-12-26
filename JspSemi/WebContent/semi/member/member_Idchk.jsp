<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	String p_id = (String)request.getAttribute("p_id");
     	String e_id = (String)request.getAttribute("e_id"); 
     	
    	int check = ((Integer)request.getAttribute("p_check")).intValue();	//개인회원 아이디 존재할 시 1, 없을 시 -1
    	int check2 = ((Integer)request.getAttribute("e_check")).intValue(); //기업회원 아이디 존재할 시 1, 없을 시 -1
    					
    %>
<html>
<head>
<title>JOBS</title>
<script>
	function windowclose(){
		<%
			if (e_id==null) {
		%>
		opener.document.PMemeberJoinform.p_id.value="<%=p_id%>";
		<%
			} else if(p_id==null) {
		%>
		opener.document.EMemeberJoinform.e_id.value="<%=e_id%>";  
		<% } %>
		self.close();
	}
</script>
<style>

form, body {
    font-family: 'Lato', sans-serif;
    background: #353535;
    color: #FFF;
   	text-align:left;
}

</style>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
<style>
table {width:380px}
</style>

</head>
<body>
<% if(check == 1 || check2 == 1) {%>
<table width="150" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
		<td height="30">
			<font size="2">
 			<% if (p_id==null) { %>
			<%=e_id %>
			<% } else { %> 
			<%=p_id %>
 			<% } %> 
			는 이미 사용 중인 아이디입니다.</font>
		</td>
	</tr>
</table>

<form action="MemberIdCheckAction.com" method="post" name="checkForm">
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<font size="2">다른 아이디를 선택하세요.</font><p>
		<%
			if (e_id==null) {
		%>
		<input type="text" size="10" maxlength="12" name="p_id"/>
		<input type="submit" value="중복확인"/>
		<%
			} else if(p_id==null) {
		%>
		 <input type="text" size="10" maxlength="12" name="e_id"/>
		 <input type="submit" value="중복확인"/> 
		 <% } %>
		
	</td>
	</tr>
</table>
</form>
<% } else { %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<font size="2">입력하신
			<% if (p_id==null) { %>
			<%=e_id %>
			<% } else { %> 
			<%=p_id %>
 			<% } %> 
 			는 사용할 수 있는 아이디입니다.</font><br/><br/>
		<input type="button" value="닫기" onclick="windowclose()"/>
	</td>
	</tr>
</table>
<% } %>
</body>
</html>