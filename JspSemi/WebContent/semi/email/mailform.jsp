<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "semi.db.bean.*" %>
<%
//String id = (String)session.getAttribute("id");
request.setCharacterEncoding("euc-kr");
String memkind=((String)session.getAttribute("memkind"));
%>
<html>
<head>
<title>Insert title here</title>
<script>

	 function goSubmit() {
		document.form.action = "SendEmail.com";
		document.form.submit();
		
	} 
</script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
<style>
table {width:500px; height:500px}
</style>
</head>
<body>
<form name="form" action="./SendEmail.com" method="post">
<input type="hidden" name="sender" value="hermes89@naver.com">
<%
if(memkind != null){
  if(memkind.equals("1")) {
	PMemberBean pmember=(PMemberBean)request.getAttribute("pmember");%>
<input type="hidden" name="p_email" value="<%=pmember.getP_email()%>">
<%} else if(memkind.equals("2")){ 
	EMemberBean emember=(EMemberBean)request.getAttribute("emember");%>
<input type="hidden" name="e_email" value="<%=emember.getE_email()%>">
<%}} %>
<table border=1>
<tr>
<td style="height:10%">운영자</td>
<td><input type="text" name="receiver" value="hermes89@naver.com" size="58" style="height:30px" ReadOnly></td>
</tr>
<tr>
<td style="height:10%">제목</td>
<td><input type="text" name="subject" size="58" style="height:30px"></td>
</tr>
<tr>
<td>내용</td>
<%if(memkind == null) {%>
<td><textarea name="content" cols=60 rows=20 placeholder="연락처와 문의내용을 입력해주세요"></textarea>
<%} else { %>
<td><textarea name="content" cols=60 rows=20 placeholder="문의내용을 입력해주세요" ></textarea>
<%} %>
</td>
</tr>
<tr>
<td colspan=2 style="height:10%" align="center"><a href="javascript:form.submit()">보내기</a></td>
</tr>
</table>
</form>
</body>
</html>