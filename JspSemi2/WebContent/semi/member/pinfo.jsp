<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "semi.db.bean.*" %>
    <%
    request.setCharacterEncoding("euc-kr");
    PMemberBean pmember = (PMemberBean)request.getAttribute("pmember");
    %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����ȸ�� ����</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "Pinfoform" action = "PModifyView.com" method = "post">
<table>
<h3>����ȸ�� ����</h3>
  <tr>
    <td>�̸�</td>
    <td><%=pmember.getP_name()%></td>
  </tr>
   <tr>
    <td>ID</td>
    <td>
    	<%=pmember.getP_id()%>
    	<input type="hidden" name="p_id" value=<%=pmember.getP_id()%>>
    </td>
  </tr>
  <tr>
    <td>����</td>
    <td><%=pmember.getP_age()%></td>
  </tr>
  <tr>
    <td>����ó</td>
    <td><%=pmember.getP_hp()%></td>
  </tr>
  <tr>
    <td>Email</td>
    <td><%=pmember.getP_email()%></td>
  </tr>
  <tr>
    <td colspan="2">
		<a href="javascript:Pinfoform.submit()">[����]</a>&nbsp;&nbsp;
		<a href="./PDeleteCheck.com?p_id=<%=pmember.getP_id() %>" >[Ż��]</a>&nbsp;&nbsp;
    </td>	
  </tr>
</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>