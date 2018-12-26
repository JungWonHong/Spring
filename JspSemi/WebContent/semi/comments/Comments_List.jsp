<%--��� ����� �����ִ� �� ������ --%>
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
<title>��� �Խ���</title>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	//��� ����â
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
				if (listcount > 0) { //��ϵ� ����� �ִ� ����Դϴ�.
					
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
			<!-- ����¡ ó���ϴ� �� [����][1][2][3]..[10][����] -->
			<tr>
				<td>
					<%if (nowpage <= 1) { //1������ ������ ��� %> [����]&nbsp;
					<%
 					} else { //2������ �̻��� ���
 					%>
					<a href="./sbBoardDetailAction.bo?cmtpage=<%=nowpage - 1%>"> [����]</a>&nbsp;
					<% } %>

					<%
						for (int a = startpage; a <= endpage; a++) {
								if (a == nowpage) { //���� ������
					%> [<%=a%>]
					<%
						} else { //���� ������ �ƴ� ��� ��ũ
					%>
					<a href="./sbBoardDetailAction.bo?cmtpage=<%=a%>">[<%=a%>]
					</a>
					<% 		}
						}
					%>
					
 					<!-- ���� �������� ���� ū ���������� ũ�ų� ���� ��� [����]�� ��ũ ���� �ʽ��ϴ�. -->
					<%
						if (nowpage >= maxpage) {
					%> [����]
					<%
						} else {
					%>
					<a href="./sbBoardDetailAction.bo?cmtpage=<%=nowpage + 1%>">[����]</a>
					<% } %>
				</td>
			</tr>

			<%
				//��ϵ� ���� �ִ� ��� end
				} else {
			%>
			<tr>
				<td colspan=2></td>
				<td style="text-align: center"><font size=2>����� ������ּ���</font></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>