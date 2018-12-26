<%-- 글쓰기 폼 페이지 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<% String id=(String)session.getAttribute("id"); %>

<html>
<head>
	<title>코딩 게시판</title>
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./js/sbwrite2.js"></script>
	<link href="./css/board.css" rel="stylesheet" type="text/css"/>
	<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form action="sbBoardAddAction.bo" method="post" 
	enctype="multipart/form-data" name="boardform">
	
<table>
	<tr>
		<td>
			<div>글쓴이</div>
		</td>
		<td>
			<%=id %>
			<input type="hidden" name="id" value="<%=id %>">
		</td>
	</tr>
	<tr>
		<td>
			<div>제 목</div>
		</td>
		<td>
			<input id="sb_title" name="sb_title"   type="text" 
			       size="80"   maxlength="100"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>내 용</div>
		</td>
		<td>
			<textarea id="sb_content" name="sb_content" cols="83" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<div>파일 첨부</div>
		</td>
		<td>
			<input name="sb_file" type="file">
		</td>
	</tr>
	<% if(id!=null&&id.length()!=0){ %>
	<tr class="center">
		<td colspan="2" class="h30 lime">
		    <!-- 등록을 클릭할 경우  addboard()를 호출합니다.-->
			<a id="sbwrite" href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
			
			<!-- 뒤로를 클릭할 경우 이전 페이지로 이동합니다. -->
			<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
	<%} %>
   </table>
 </form>
 <jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>