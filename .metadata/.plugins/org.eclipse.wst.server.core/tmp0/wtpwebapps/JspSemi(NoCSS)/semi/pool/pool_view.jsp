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
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form name = "pmodify" method="post" enctype="multipart/form-data" action = "AddResume.com">
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
    <td>입사 후 포부(500자 이내)</td>
    <td><textarea rows="10" cols="50" name = "comment" readonly="readonly">
    		<%=pmember.getP_comment() %>
    	</textarea>
    </td>
  </tr>
  <tr>
    <td>포트폴리오</td>
    <td><%if(pmember.getP_portpolio()!=null){%>
    <a href="./semi/member/file_down.jsp?file_name=<%=pmember.getP_portpolio()%>" download>
		<%=pmember.getP_portpolio() %></a><%}else{ %>
		포트폴리오없음
	<%} %>
	</td>
  </tr>
  <tr>
    <td>IT관련 자격증 유무</td>
    <td>
    <%if(pmember.getP_certi() != 0){ %>
    	관련자격증보유
    <%} else { %>
    	관련자격증없음
    <%} %>
    </td>
  </tr>
  <tr>
    <td colspan=2>
      <a href = "javascript:history.go(-1)">[뒤로]</a>
    </td>
  </tr>  
  
</table>
</form>
</body>

</html>