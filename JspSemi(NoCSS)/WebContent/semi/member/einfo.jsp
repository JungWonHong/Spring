<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "semi.db.bean.*" %>
    <%
    EMemberBean emember = (EMemberBean)request.getAttribute("emember");
    %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "Einfoform" action = "EModifyView.com" method = "post">
<table>
<h3>기업회원 정보</h3>
  <tr>
    <td>가입자명</td>
    <td><%=emember.getE_memname()%></td>
  </tr>
   <tr>
    <td>ID</td>
    <td>
    	<%=emember.getE_id()%>
    	<input type="hidden" name="e_id" value=<%=emember.getE_id()%>>
    </td>
  </tr>
  <tr>
    <td>Email</td>
    <td><%=emember.getE_email()%></td>
  </tr>
  <tr>
    <td>연락처</td>
    <td><%=emember.getE_phone()%></td>
  </tr>
  <tr>
    <td>회사명</td>
    <td><%=emember.getE_company()%></td>
  </tr>
  <tr>
    <td colspan="2">
		<a href="javascript:Einfoform.submit()">[수정]</a>&nbsp;&nbsp;
		<a href="./EDeleteCheck.com?e_id=<%=emember.getE_id() %>" >[탈퇴]</a>&nbsp;&nbsp;
    </td>	
  </tr>
</table>
</form>
</body>
</html>