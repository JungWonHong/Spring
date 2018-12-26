<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>  
<%	
	String id=(String)session.getAttribute("id");
	ArrayList boardList=(ArrayList)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	CommentsDAO cmtdao = new CommentsDAO();
%>    
<html>
<head>
<title>Source Board</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
	<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<!-- 게시판 리스트 -->
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">코딩 게시판</td>
		<td align=right>
			<font size=2>글 개수 : <%=listcount %></font>
		</td>
	</tr>
	<tr>
		<th  width="8%">
			<div>번호</div>
		</th>
		<th width="50%">
			<div>제목</div>
		</th>
		<th width="14%">
			<div>글쓴이</div>
		</th>
		<th width="17%">
			<div>작성일</div>	
		</th>
		<th width="11%">
			<div>조회수</div>
		</th>	
	</tr>		
<%--db에서 값 가져와서 작성글 목록 뽑기 --%>
<%
	//boardList 객체에는 현재 페이지의 글 목록이 저장되어있으며, 저장된 글 목록만큼 
	//for문을 돌려서 boardList에 있는 글들을 하나씩 BoardBean 객체에 담아오고
	//각각의 속성 값을 출력한다.
	for(int i=0; i<boardList.size(); i++){
		SourceBoardBean sb=(SourceBoardBean)boardList.get(i);
		//System.out.println(sb.getSb_id());
%>
	<tr align="center" valign="middle"
		onmouseover="this.style.backgroundColor='F8F8F8'"		
		onmouseout="this.style.backgroundColor=''">
		<td><%=sb.getSb_no() %></td>
		<td>
			<div>
			<a href="./sbBoardDetailAction.bo?num=<%=sb.getSb_no()%>">
				<%=sb.getSb_title() %>
				<%if(cmtdao.getCommentsListCount(sb.getSb_no()) != 0){ %>
					[<%=cmtdao.getCommentsListCount(sb.getSb_no()) %>]
				<%} %>
			</a>	
			</div>
		</td>
		<td>
			<div><%=sb.getSb_id() %></div>
		</td>
		<td>
			<div><%=sb.getSb_date() %></div>
		</td>
		<td>
			<div><%=sb.getSb_count() %></div>
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
			<a href="./sbBoardList.bo?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>
			<!-- 해당 페이지 그룹의 시작 페이지부터 마지막 페이지까지 for문을 돌린다. -->
			<%for(int a=startpage; a<=endpage; a++){ 
				//표시할 이동 가능한 페이지 중 현재 페이지는 링크를 걸지 않고 표시.
				if(a==nowpage){%>
					<b>[<%=a %>]</b>
				<!-- 현재페이지를 제외한 나머지 이동 가능한 페이지를 표시할 때는 페이지 이동이 되도록 링크를 건다. -->	
				<%}else{ %>
				<a href="./sbBoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<% if(nowpage>=maxpage){%>
				[다음]
			<% }else{ %>
			<a href="./sbBoardList.bo?page=<%=nowpage+1 %>">[다음]</a>&nbsp;	
			<%} %>
		</td>
	</tr>
	<%if(id!=null&&id.length()!=0){ %>
	<tr align="right">
		<td colspan="4">
			<a href="./sbBoardWrite.bo">[글쓰기]</a>	
		</td>	
	<%} else {%>
	<tr align="right">
		<td colspan="4">
		&nbsp;
		</td>
	<%} %>	
		<td colspan="1" align="center">
			<a href="./sbBoardList.bo">[처음]</a>
		</td>	
	</tr>	 
</table>
	<jsp:include page="./sbboard_search.jsp"></jsp:include>
	<jsp:include page="../Footer.jsp"></jsp:include>
		
</body>
</html>