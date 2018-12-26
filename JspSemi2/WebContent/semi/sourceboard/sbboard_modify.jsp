<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>   
<%
	//저장되어 있던 글 내용 데이터를 화면에 보여주는 위해 rv 속성의 데이터를 가져옴
	SourceBoardBean sb=(SourceBoardBean)request.getAttribute("sb");
%>
<html>
<head>
	<script>
	function sbmodifyboard(){
		sbmodifyform.submit();
	}
	</script>
	<link href="./css/board.css" rel="stylesheet" type="text/css"/>
	<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<form action="sbBoardModifyAction.bo?sb_no=<%=sb.getSb_no() %>" method="get" name="sbmodifyform"
		enctype="multipart/form-data">
	<input type="hidden" name="sb_no" value=<%=sb.getSb_no() %>>
	<table>
		<tr>
			<th colspan="2">코딩 게시판 - 수정 중</th>
		</tr>
		<tr>
			<td>
				<div>제 목</div>
			</td>
			<td>
				<input name="sb_title" size="50" maxlength="100"
					value="<%=sb.getSb_title() %>">
			</td>	
		</tr>
		<tr>
			<td>
				<div>내 용</div>
			</td>
			<td>
				<textarea name="sb_content" cols="67" rows="15"><%=sb.getSb_content() %></textarea>
			</td>
		</tr>
		<%//if(!(sb.getSb_file()==null)){ %>
	<tr>
		<td>
			<div>파일 첨부</div>
		</td>
		<td>
			<div><input name="sb_file" type="file"></div>
			<input name="sb_file_orig" type="hidden" value=<%=sb.getSb_file() %>>
		</td>
	</tr>
	<%//} %>
		<tr>
			<td colspan="2">
				<a href="javascript:sbmodifyboard()">[수정]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)" >[뒤로]</a>&nbsp;&nbsp;
			</td>	
		</tr>	
	</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>