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
<title>����POOL - view</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "pmodify" method="post" enctype="multipart/form-data" action = "AddResume.com">
<table>
<h3>�̷¼�</h3>
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
    	<input type="hidden" name="p_id" value=<%=pmember.getP_id() %>>
    </td>
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
    <td>�Ի� �� ����(500�� �̳�)</td>
    <td><textarea rows="10" cols="50" name = "comment" readonly="readonly"><%=pmember.getP_comment() %></textarea>
    </td>
  </tr>
  <tr>
    <td>��Ʈ������</td>
    <td><%if(pmember.getP_portpolio()!=null){%>
    <a href="./semi/member/file_down.jsp?file_name=<%=pmember.getP_portpolio()%>" download>
		<%=pmember.getP_portpolio() %></a><%}else{ %>
		��Ʈ����������
	<%} %>
	</td>
  </tr>
  <tr>
    <td>IT���� �ڰ��� ����</td>
    <td>
    <%if(pmember.getP_certi() != 0){ %>
    	�����ڰ�������
    <%} else { %>
    	�����ڰ�������
    <%} %>
    </td>
  </tr>
  <tr>
    <td colspan=2>
      <a href = "javascript:history.go(-1)">[�ڷ�]</a>
    </td>
  </tr>  
  
</table>
</form>

<jsp:include page="../Footer.jsp"></jsp:include>

</body>

</html>