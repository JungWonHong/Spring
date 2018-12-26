<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*"%>
<%@ page import="semi.db.*"%>
<%
	//게시물의 내용이 담겨있는 boarddata 속성의 데이터를 BoardBean 타입으로 
	//변환하여 얻습니다.
	String id = (String) session.getAttribute("id");
	SourceBoardBean sb = (SourceBoardBean) request.getAttribute("sb");
%>
<html>
<head>
<title>코딩 게시판 view</title>
<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
   function windowopen(){
   		var popUrl = "./sbBoardDelete.bo?num=<%=sb.getSb_no()%>"; //팝업창에 출력될 페이지 URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	}
</script>
</head>

<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<!-- 게시판 수정 -->
	<table>
		<tr valign="middle">
			<th colspan="2">코딩 게시판-view페이지</th>
		</tr>
		<tr>
			<td>
				<div>글쓴이</div>
			</td>
			<td><%=sb.getSb_id()%></td>
		</tr>
		<tr>
			<td>
				<div>제 목</div>
			</td>
			<td><%=sb.getSb_title()%><!-- 게시물의 제목을 출력합니다. --></td>
		</tr>
		<tr>
			<td>
				<div>내 용</div>
			</td>
			<td><textarea name="sb_content" cols="67" rows="15"
					readonly="readonly"><%=sb.getSb_content()%></textarea></td>
		</tr>
		<tr>
			<td>
				<div>첨부파일</div>
			</td>
			<td>
				<!-- 게시물에 첨부파일이 존재할 경우 첨부 파일의 링크를 표시합니다. --> <%
 	if (!(sb.getSb_file() == null)) {
 %> <a
				href="./semi/sourceboard/file_down.jsp?file_name=<%=sb.getSb_file()%>"
				download> <%=sb.getSb_file()%>
			</a> <%
 	}
 %>
			</td>
		</tr>

		<tr bgcolor="00ffff">
			<td colspan="2" style="height: 1px;"></td>
		</tr>

		<!-- 수정, 삭제, 목록의 링크를 표시합니다. -->
		<tr>
			<td colspan="2" class="h30 lime center">
				<%
					if (id != null && id.length() != 0) {
						if (id.equals(sb.getSb_id()) || id.equals("admin")) {
				%> <a href="./sbBoardModify.bo?num=<%=sb.getSb_no()%>"> [수정] </a>&nbsp;&nbsp;
				   <a href="javascript:windowopen();"> [삭제] </a>&nbsp;&nbsp;
				<%
					}
					}
				%> <a href="./sbBoardList.bo">[목록]</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	<jsp:include page="../comments/Comments_List.jsp"></jsp:include>
</body>
</html>