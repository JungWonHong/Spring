<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "semi.db.bean.*" %>
    <%
    PMemberBean pmember = (PMemberBean)request.getAttribute("pmember");
    %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/pmem_modify.js" charset="euc-kr"></script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "pmodify" method="post" action = "PModifyAction.com">
<table>
<h3>����ȸ�� ���� ����</h3>
  <tr>
    <td>�̸�</td>
    <td><%=pmember.getP_name()%></td>
  </tr>
  <tr>
    <td>����</td>
    <td><%=pmember.getP_age()%></td>
  </tr>
  <tr>
    <td>ID</td>
    <td>
    	<%=pmember.getP_id()%>
    	<input type="hidden" name="p_id" value=<%=pmember.getP_id()%>>
    </td>
  </tr>
  <tr>
    <td>��й�ȣ ����</td>
    <td>
    	<input id="p_pw" type = "password" name = "p_pw">
    	<input id="orig_pw" type = "hidden" name = "orig_pw" value = <%=pmember.getP_pw() %>>
    </td>
  </tr>
  <tr>
    <td>��й�ȣ Ȯ��</td>
    <td><input id="p_pw2" type = "password" name = "p_pw2"></td>
  </tr>
  <tr>
    <td>����ó</td>
    <td><input type = "text" name = "p_hp" value = <%=pmember.getP_hp()%>></td>
  </tr>
  <tr>
    <td>Email</td>
    <td><input type = "text" name = "p_email" value = <%=pmember.getP_email()%>></td>
  </tr>
  <tr>
    <td>
      <a id="pmemmodify" href = "javascript:pmodify.submit()">[�Ϸ�]</a>
    </td>
    <td>
      <a href = "javascript:history.go(-1)">[�ڷ�]</a>
    </td>
  </tr>  
  
</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>

</html>