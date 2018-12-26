<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="semi.db.bean.*" %>

<%	
	List<PMemberBean> list = (ArrayList<PMemberBean>)request.getAttribute("poollist");
	int listcount=((Integer)request.getAttribute("poollistcount")).intValue();
	int nowpage=((Integer)request.getAttribute("poolpage")).intValue();
	int maxpage=((Integer)request.getAttribute("poolmaxpage")).intValue();
	int startpage=((Integer)request.getAttribute("poolstartpage")).intValue();
	int endpage=((Integer)request.getAttribute("poolendpage")).intValue();
%>   
<!DOCTYPE html>
<html>
<head>
<title>인재POOL - LIST</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<jsp:include page="../menubar.jsp"></jsp:include>
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">인재 POOL</td>
		<td align=right>
			<font size=2>인재 LIST : <%=listcount %></font>
		</td>
	</tr>
	<tr>
		<th  width="20%">
			<div>ID</div>
		</th>
		<th  width="20%">
			<div>나이</div>
		</th>
		<th width="25%">
			<div>자격증 유/무</div>
		</th>
		<th width="25%">
			<div>포트폴리오 유/무</div>
		</th>
		<th  width="10%">
			<div></div>
		</th>
	</tr>		
<%--db에서 값 가져와서 작성글 목록 뽑기 --%>
<%
	//boardList 객체에는 현재 페이지의 글 목록이 저장되어있으며, 저장된 글 목록만큼 
	//for문을 돌려서 boardList에 있는 글들을 하나씩 BoardBean 객체에 담아오고
	//각각의 속성 값을 출력한다.
	for(int i=0; i<list.size(); i++){
		PMemberBean pm = (PMemberBean)list.get(i);
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td>
			<div><%=pm.getP_id() %></div>
		</td>
		<td>
			<div><%=pm.getP_age() %></div>
		</td>
		<% 
		String certi = "";
		if(pm.getP_certi() == 1) 
			certi = "관련 자격증 보유";
		else
			certi = "자격증 없음";
		%>
		<td>
			<div><%=certi %></div>
		</td>
		<% 
		String portpolio = "";
		if(pm.getP_portpolio() != null && pm.getP_portpolio().length() != 0) 
			portpolio = "포트폴리오 존재";
		else
			portpolio = "포트폴리오 없음";
		%>
		<td>
			<div><%=portpolio %></div>
		</td>
		<td>
			<div><a href="./PoolView.bo?p_id=<%=pm.getP_id() %>">보기</a></div>
		</td>
	</tr>	
<%
	}
%>
	<tr align=center height=20>
		<td colspan=7>
			<!-- 현재 페이지가 1일 경우 [이전]을 표시할 때 링크를 걸지 않는다. 현재 위치한 페이지가 2이상일 경우만
			이전 페이지로 돌아갈 수 있으므로, 현재 페이지 값이 1일 때에는 링크할 필요가 없다. -->
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./Pool.bo?poolpage=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>
			<!-- 해당 페이지 그룹의 시작 페이지부터 마지막 페이지까지 for문을 돌린다. -->
			<%for(int a=startpage; a<=endpage; a++){ 
				//표시할 이동 가능한 페이지 중 현재 페이지는 링크를 걸지 않고 표시.
				if(a==nowpage){%>
					[<%=a %>]
				<!-- 현재페이지를 제외한 나머지 이동 가능한 페이지를 표시할 때는 페이지 이동이 되도록 링크를 건다. -->	
				<%}else{ %>
				<a href="./Pool.bo?poolpage=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<% if(nowpage>=maxpage){%>
				[다음]
			<% }else{ %>
			<a href="./Pool.bo?poolpage=<%=nowpage+1 %>">[다음]</a>&nbsp;	
			<%} %>
		</td>
	</tr>
	</table>
	
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>