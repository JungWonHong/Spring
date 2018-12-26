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
<title>인재POOL - view</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<jsp:include page="../menubar.jsp"></jsp:include>
<table>
<h3>이력서</h3>
  <tr>
    <td>이름</td>
    <td><%=pmember.getP_name()%></td>
  </tr>
  <tr>
    <td>나이</td>
    <td><%=pmember.getP_age()%></td>
  </tr>
  <tr>
    <td>ID</td>
    <td><%=pmember.getP_id()%></td>
  </tr>
  <tr>
    <td>연락처</td>
    <td><%=pmember.getP_hp()%></td>
  </tr>
  <tr>
    <td>Email</td>
    <td><%=pmember.getP_email()%></td>
  </tr>
  <tr>
	<td>지원회사명</td>
	<td><%=resume.getR_company()%></td>
  </tr>
  <tr>
    <td>입사 후 포부(500자 이내)</td>
    <td><textarea rows="10" cols="50" name = "comment" readonly="readonly"><%=resume.getR_content() %></textarea>
    </td>
  </tr>
  <tr>
    <td>포트폴리오</td>
    <td><%if(resume.getR_file()!=null){%>
    <a href="./semi/resume/file_down.jsp?file_name=<%=resume.getR_file()%>" download>
		<%=resume.getR_file() %></a><%}else{ %>
		포트폴리오없음
	<%} %>
	</td>
  </tr>
  <tr>
    <td>자격증</td>
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
      <a href = "javascript:location.href='./ResumeDelete.re?p_id=<%=pmember.getP_id()%>&r_company=<%=resume.getR_company()%>'">[삭제]</a>
      <a href = "javascript:history.go(-1)">[뒤로]</a>
    </td>
  </tr>  
  
</table>

<jsp:include page="../Footer.jsp"></jsp:include>

</body>

</html>