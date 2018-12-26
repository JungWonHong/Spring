<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*"%>
<%@ page import="semi.db.*"%>
<%
	request.setCharacterEncoding("euc-kr");
	RecruitBoardBean board = (RecruitBoardBean) request.getAttribute("boarddata");
	BoardDAO boarddao = new BoardDAO();
	EListBean info = boarddao.getEInfo(board.getRc_company());
%>
<html>
<head>
<title>채용 게시판</title>
<link href="./css/recruit.css" rel="stylesheet" type="text/css" />
<link href="./css/recruit2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<div class="rcboard">
		<div class="common_center" align=right>
			<p class="cStyle common_left">
				등록일
				<%=board.getRc_date()%></p>
		</div>

		<div class="shop_detail_info">
			<div class="subject_title"><%=board.getRc_title()%></div>

		</div>


		<div class="common_center MAT55">
			<h4 class="cStyle common_left" style="font-weight: normal;">
				<i class="fa fa-dot-circle-o" aria-hidden="true"></i> 채용분야 및 급여
			</h4>
		</div>

		<table class="cStyle3">
			<tr>
				<th>분야</th>
				<th>급여</th>
				<!--th>근무형태</th-->
			</tr>
			<tr>
				<td><%=board.getRc_ability()%></td>
				<td style="text-align: center"><span style="color: #fff; padding: 0 2px 2px 2px;"> <%
				 	if (board.getRc_sal() == 0) {
				 %>
					협의후결정 <%
				 	} else {
				 %> <%=board.getRc_sal()%> <%
				 	}
				 %></span>
				</td>
			</tr>
		</table>

		<!-- 채용정보 안내-->

		<div class="common_center MAT55">
			<h4 class="cStyle common_left" style="font-weight: normal;">
				<i class="fa fa-dot-circle-o" aria-hidden="true"></i> 채용정보안내
			</h4>
		</div>
		<table class="cStyle6">
			<colgroup>
				<col width="150" />
				<col width="300" />
				<col width="150" />
				<col width="300" />
			</colgroup>
			<tr>
				<th>업종</th>
				<td><%=info.getEl_part()%></td>
				<th>근무형태</th>
				<%
					if (board.getRc_hirekind() == 1) {
				%>
				<td>정규직</td>
				<%
					} else {
				%>
				<td>계약직</td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>근무지역</th>
				<td><%=info.getEl_loc()%></td>
				<th>복리후생</th>
				<td><%=info.getEl_environment()%></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>무관</td>
				<th>경력</th>
				<%
					if (board.getRc_career() == 1) {
				%>
				<td>신입</td>
				<%
					} else if (board.getRc_career() == 2) {
				%>
				<td>경력</td>
				<%
					} else {
				%>
				<td>신입/경력</td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>근무일</th>
				<td><%=board.getRc_worktime()%></td>
				<th>접수마감</th>
				<td><%=board.getRc_expire()%></td>
			</tr>
			<tr>
				<th>접수방법</th>
				<td colspan="3">자사 채용 홈페이지</td>
			</tr>
		</table>

		<!-- 채용정보 안내-->

		<!-- 상세모집요강 안내-->
		<div class="common_center MAT55">
			<h4 class="cStyle common_left" style="font-weight: normal;">
				<i class="fa fa-dot-circle-o" aria-hidden="true"></i> 상세모집요강
			</h4>
		</div>
		<div class="shop_detail_info_common_box"><%=board.getRc_content()%></div>
		<!-- 상세모집요강 안내-->
	</div>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>