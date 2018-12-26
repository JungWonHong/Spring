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
<title>이력서 작성</title>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/resume.js"></script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<jsp:include page="../menubar.jsp"></jsp:include>
<form name = "addPoolResume" method="post" enctype="multipart/form-data" action = "AddResume.re">
<table>
<h3>이력서 등록</h3>
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
    <td>
    	<%=pmember.getP_id()%>
    	<input type="hidden" name="p_id" value=<%=pmember.getP_id() %>>
    </td>
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
    <td>입사 후 포부(100~500자)</td>
    <td>
      <div>
    	<textarea id="comment" rows="10" cols="50" name ="comment"><%if(pmember.getP_comment() != null){%><%=pmember.getP_comment() %><%} %></textarea>
    	<p id="remain">0/500</p>
      </div>
    </td>
  </tr>
  <tr>
    <td>포트폴리오 첨부</td>
    <td><input type="file" name="portpolio"></td>
  </tr>
   <%if(pmember.getP_portpolio()!=null){ 			
		%>
  <tr>
	<td>기존 포트폴리오</td>
	<td>
		<a href="./semi/resume/file_down.jsp?file_name=<%=pmember.getP_portpolio()%>" download>
		<%=pmember.getP_portpolio() %>
		</a>
	</td>
  </tr>
  <%} %>
  <tr>
    <td>IT관련 자격증 유무</td>
    <td> 
    	 <input type = "radio" name = "certi" value=1 <%if(pmember.getP_certi()==1){ %>checked<%} %>>네
         <input type = "radio" name = "certi" value=2 <%if(pmember.getP_certi()==0){ %>checked<%} %>>아니오
    </td>
  </tr>
  <tr>
    <td>
      <a id="addResume" href = "javascript:addPoolResume.submit()">[등록]</a>
    </td>
    <td>
      <a href = "javascript:history.go(-1)">[뒤로]</a>
    </td>
  </tr>  
  
</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>

</html>