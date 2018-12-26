<%--댓글 목록을 보여주는 뷰 페이지 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="semi.db.bean.*"%>
<%
	List<CommentsBean> commentslist = (ArrayList<CommentsBean>) request.getAttribute("commentslist");
	int listcount = ((Integer) request.getAttribute("cmtlistcount")).intValue();
	int nowpage = ((Integer) request.getAttribute("cmtpage")).intValue();
	int maxpage = ((Integer) request.getAttribute("cmtmaxpage")).intValue();
	int startpage = ((Integer) request.getAttribute("cmtstartpage")).intValue();
	int endpage = ((Integer) request.getAttribute("cmtendpage")).intValue();

	String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<title>댓글 게시판</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	//댓글 수정창
	function cmtUpdateOpen(com_no){
     window.name = "parentForm"; 
    window.open("CommentsModify.co?com_no="+com_no,
                "Comments_Modify", "width=570, height=350, resizable = no, scrollbars = no");
	};
	
	function cmtDelete(com_no){
		document.myform.action="CommentsDeleteAction.co?" + "com_no=" + com_no;
		document.myform.submit();
	};
</script>

<style>
	a {
		width:50px;
	}
</style>
</head>
<body>
	<%
	if(id != null && id.length() != 0){
	%>
	<jsp:include page="Comments_Write.jsp"></jsp:include>
	<%} %>
	<form name="myform" id="myform" method="post">
		<table>
			<%
				if (listcount > 0) { //등록된 댓글이 있는 경우입니다.
					
					for (int i = 0; i < commentslist.size(); i++) {
						CommentsBean cb = (CommentsBean) commentslist.get(i);
			%>
			<tr>
				<td><%=cb.getCom_id()%></td>
				<td><%=cb.getCom_content()%></td>

				<td><input type="hidden" name="com_no"
					value="<%=cb.getCom_no()%>">
					<% int com_no = cb.getCom_no();
						if(id != null && id.length() != 0){
						if(id.equals(cb.getCom_id())){
						%>
					
					<input type="button" value="modify"
					onclick='cmtUpdateOpen(<%=com_no%>)'>
					<input type="button" value="delete" onclick='cmtDelete(<%=com_no%>)'>
					<%}} %>
				</td>
			</tr>
			<%
				} //for end
			%>
			<!-- 페이징 처리하는 문 [이전][1][2][3]..[10][다음] -->
			<tr>
				<td>
					<%if (nowpage <= 1) { //1페이지 이하인 경우 %> [이전]&nbsp;
					<%
 					} else { //2페이지 이상인 경우
 					%>
					<a href="./sbBoardDetailAction.bo?cmtpage=<%=nowpage - 1%>"> [이전]</a>&nbsp;
					<% } %>

					<%
						for (int a = startpage; a <= endpage; a++) {
								if (a == nowpage) { //현재 페이지
					%> [<%=a%>]
					<%
						} else { //현재 페이지 아닌 경우 링크
					%>
					<a href="./sbBoardDetailAction.bo?cmtpage=<%=a%>">[<%=a%>]
					</a>
					<% 		}
						}
					%>
					
 					<!-- 현재 페이지가 가장 큰 페이지보다 크거나 같은 경우 [다음]에 링크 걸지 않습니다. -->
					<%
						if (nowpage >= maxpage) {
					%> [다음]
					<%
						} else {
					%>
					<a href="./sbBoardDetailAction.bo?cmtpage=<%=nowpage + 1%>">[다음]</a>
					<% } %>
				</td>
			</tr>

			<%
				//등록된 글이 있는 경우 end
				} else {
			%>
			<tr>
				<td colspan=2></td>
				<td style="text-align: center"><font size=2>댓글을 등록해주세요</font></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>