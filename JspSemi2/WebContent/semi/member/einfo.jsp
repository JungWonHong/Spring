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
<title>�Ϲ�ȸ�� ����</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "Einfoform" action = "EModifyView.com" method = "post">
<table>
<h3>���ȸ�� ����</h3>
  <tr>
    <td>�����ڸ�</td>
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
    <td>����ó</td>
    <td><%=emember.getE_phone()%></td>
  </tr>
  <tr>
    <td>ȸ���</td>
    <td><%=emember.getE_company()%></td>
  </tr>
  <tr>
    <td colspan="2">
		<a href="javascript:Einfoform.submit()">[����]</a>&nbsp;&nbsp;
		<a href="./EDeleteCheck.com?e_id=<%=emember.getE_id() %>" >[Ż��]</a>&nbsp;&nbsp;
    </td>	
  </tr>
</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>

</html>