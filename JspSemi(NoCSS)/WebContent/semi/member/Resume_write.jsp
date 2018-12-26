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
<script src="./js/resume.js"></script>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "addResume" method="post" enctype="multipart/form-data" action = "AddResume.com">
<table>
<h3>�̷¼� ���</h3>
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
    <td>�Ի� �� ����(100~500��)</td>
    <td>
      <div>
    	<textarea id="comment" rows="10" cols="50" name ="comment"><%if(pmember.getP_comment() != null){%><%=pmember.getP_comment() %><%} %></textarea>
    	<p id="remain">0/500</p>
      </div>
    </td>
  </tr>
  <tr>
    <td>��Ʈ������ ÷��</td>
    <td><input type="file" name="portpolio"></td>
  </tr>
   <%if(pmember.getP_portpolio()!=null){ 			
		%>
  <tr>
	<td>���� ��Ʈ������</td>
	<td>
		<a href="./semi/member/file_down.jsp?file_name=<%=pmember.getP_portpolio()%>" download>
		<%=pmember.getP_portpolio() %>
		</a>
	</td>
  </tr>
  <%} %>
  <tr>
    <td>IT���� �ڰ��� ����</td>
    <td> 
    	 <input type = "radio" name = "certi" value=1 <%if(pmember.getP_certi()==1){ %>checked<%} %>>��
         <input type = "radio" name = "certi" value=2 <%if(pmember.getP_certi()==0){ %>checked<%} %>>�ƴϿ�
    </td>
  </tr>
  <tr>
    <td>
      <a id="addResume" href = "javascript:addResume.submit()">[���]</a>
    </td>
    <td>
      <a href = "javascript:history.go(-1)">[�ڷ�]</a>
    </td>
  </tr>  
  
</table>
</form>
</body>

</html>