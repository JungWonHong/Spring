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
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/emem_modify.js" charset="euc-kr"></script>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "emodify" method="post" action = "EModifyAction.com">
<table>
<h3>���ȸ�� ���� ����</h3>
  <tr>
  	<tr>
    <td>�����ڸ�</td>
    <td><%=emember.getE_memname()%></td>
  	</tr>
    <td>ID</td>
    <td>
    	<%=emember.getE_id()%>
    	<input type="hidden" name="e_id" value=<%=emember.getE_id()%>>
    </td>
  </tr>
  <tr>
    <td>��й�ȣ ����</td>
    <td>
    	<input id="e_pw" type = "password" name = "e_pw" placeholder="8�ڸ� �̻�">
    	<input id="orig_pw" type = "hidden" name = "orig_pw" value = <%=emember.getE_pw() %>>
    </td>
  </tr>
  <tr>
    <td>��й�ȣ Ȯ��</td>
    <td><input id="e_pw2" type = "password" name = "e_pw2"></td>
  </tr>
  <tr>
    <td>����ó</td>
    <td><input type = "text" name = "e_hp" value = <%=emember.getE_phone()%>></td>
  </tr>
  <tr>
    <td>Email</td>
    <td><input type = "text" name = "e_email" value = <%=emember.getE_email()%>></td>
  </tr>
  <tr>
    <td>ȸ���̸�</td>
    <td><input type = "text" name = "e_company" value = <%=emember.getE_company()%>></td>
  </tr>
  <tr>
    <td>
      <a id="ememmodify" href = "javascript:emodify.submit()">[�Ϸ�]</a>
    </td>
    <td>
      <a href = "javascript:history.go(-1)">[�ڷ�]</a>
    </td>
  </tr>   
  
</table>
</form>
</body>

</html>