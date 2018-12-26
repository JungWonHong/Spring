<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>

<%	
	request.setCharacterEncoding("euc-kr");
	ArrayList<ResumeBean> list = (ArrayList<ResumeBean>)request.getAttribute("resumelist");
%>   
<!DOCTYPE html>
<html>
<head>
<title>이력서 LIST</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th width="70%">
			<div>지원 회사</div>
		</th>
		<th  width="30%">
			<div></div>
		</th>
	</tr>		
<%--db에서 값 가져와서 작성글 목록 뽑기 --%>
<%
	//boardList 객체에는 현재 페이지의 글 목록이 저장되어있으며, 저장된 글 목록만큼 
	//for문을 돌려서 boardList에 있는 글들을 하나씩 BoardBean 객체에 담아오고
	//각각의 속성 값을 출력한다.
	for(int i=0; i<list.size(); i++){
		ResumeBean pm = (ResumeBean)list.get(i);
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td>
			<div><%=pm.getR_company() %></div>
		</td>
		<td>
			<div><a href="./ResumeDetail.re?r_company=<%=pm.getR_company() %>&r_id=<%=pm.getR_id() %>">보기</a></div>
		</td>
	</tr>	
<%
	}
%>
	</table>
	
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>