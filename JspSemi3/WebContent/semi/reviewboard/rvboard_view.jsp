<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*"%>
<%@ page import="semi.db.*"%>
<%
	String id = (String) session.getAttribute("id");
	//게시물의 내용이 담겨있는 boarddata 속성의 데이터를 BoardBean 타입으로 
	//변환하여 얻습니다.
	ReviewBoardBean rv = (ReviewBoardBean) request.getAttribute("rv");
%>
<html>
<head>
<title>Review 게시판</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
<style>
.star_rating a.on {
	color: #FFE400;
}

.star_rating a.off {
	text-decoration: none;
	color: #e8e3e3;
}
</style>
<script type="text/javascript">
		function windowopen(){
		    var popUrl = "./rvBoardDelete.bo?num=<%=rv.getRv_no()%>"; //팝업창에 출력될 페이지 URL
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
			<th colspan="2">현장의 소리 view</th>
		</tr>
		<tr>
			<td>
				<div>글쓴이</div>
			</td>
			<td><%=rv.getRv_id()%></td>
		</tr>
		<tr>
			<td>
				<div>제 목</div>
			</td>
			<td><%=rv.getRv_title()%><!-- 게시물의 제목을 출력합니다. --></td>
		</tr>
		<tr>
			<td>
				<div>기업 평점</div>
			</td>
			<td>

				<p class="star_rating">
					<%
						System.out.println(rv.getRv_score());
						for (int n = 0; n < rv.getRv_score(); n++) {
					%>
					<a class="on" href="javascript:void(0)">★</a>
					<%
						}
						int a = 5 - rv.getRv_score();
						if (a > 0) {
							for (int n = 0; n < a; n++) {
					%>
					<a class="off" href="javascript:void(0)">★</a>
					<%
						}
						}
					%>
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<div>내 용</div>
			</td>
			<td><textarea name="rv_content" cols="67" rows="15"
					readonly="readonly"><%=rv.getRv_content()%></textarea></td>
		</tr>
		<tr bgcolor="00ffff">
			<td colspan="2" style="height: 1px;"></td>
		</tr>
		<tr>
			<td colspan="2" class="h30 lime center">
				<%
					if (id != null && id.length() != 0) {
						if (id.equals(rv.getRv_id()) || id.equals("admin")) {
				%> <a
				href="./rvBoardModify.bo?num=<%=rv.getRv_no()%>"> [수정] </a>&nbsp;&nbsp;
				<a href="javascript:windowopen();"> [삭제] </a>&nbsp;&nbsp; <%
 	}
 	}
 %> <a href="./rvBoardList.bo">[목록]</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	<jsp:include page="../Footer.jsp"></jsp:include>
	
</body>
</html>