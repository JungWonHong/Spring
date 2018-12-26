<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "semi.db.bean.*" %>
    <%
    request.setCharacterEncoding("euc-kr");
    ResumeBean resume = (ResumeBean)request.getAttribute("resume");
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
    <td><%=pmember.getP_id()%></td>
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
	<td>����ȸ���</td>
	<td><%=resume.getR_company()%></td>
  </tr>
  <tr>
    <td>�Ի� �� ����(500�� �̳�)</td>
    <td><textarea rows="10" cols="50" name = "comment" readonly="readonly"><%=resume.getR_content() %></textarea>
    </td>
  </tr>
  <tr>
    <td>��Ʈ������</td>
    <td><%if(resume.getR_file()!=null){%>
    <a href="./semi/resume/file_down.jsp?file_name=<%=resume.getR_file()%>" download>
		<%=resume.getR_file() %></a><%}else{ %>
		��Ʈ����������
	<%} %>
	</td>
  </tr>
  <tr>
    <td>�ڰ���</td>
    <td>
    <%
  	String certi = resume.getR_certi();
  	StringTokenizer st = new StringTokenizer(certi, ",");
  	String[] certiName = new String[st.countTokens()];
  	while(st.hasMoreTokens()){%>
		<%=st.nextToken() %>&nbsp;&nbsp;
  <%}%>
    </td>
  </tr>
  <tr>
    <td colspan=2>
      <a href = "javascript:location.href='./ResumeDelete.re?p_id=<%=pmember.getP_id()%>&r_company=<%=resume.getR_company()%>'">[����]</a>
      <a href = "javascript:history.go(-1)">[�ڷ�]</a>
    </td>
  </tr>  
  
</table>

<jsp:include page="../Footer.jsp"></jsp:include>

</body>

</html>