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
<title>ä�� �Խ���</title>
<link href="./css/recruit.css" rel="stylesheet" type="text/css" />
<link href="./css/recruit2.css" rel="stylesheet" type="text/css" />
<script>
			function open_window(){
				win = window.open('<%=board.getRc_url()%>');
			}
</script>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<jsp:include page="../menubar.jsp"></jsp:include>
	<div class="rcboard">
		<div class="common_center" align=right>
			<p class="cStyle common_left">
				�����
				<%=board.getRc_date()%></p>
		</div>

		<div class="shop_detail_info">
			<div class="subject_title"><%=board.getRc_title()%></div>

		</div>


		<div class="common_center MAT55">
			<h4 class="cStyle common_left" style="font-weight: normal;">
				<i class="fa fa-dot-circle-o" aria-hidden="true"></i> ä��о� �� �޿�
			</h4>
		</div>

		<table class="cStyle3">
			<tr>
				<th>�о�</th>
				<th>�޿�</th>
				<!--th>�ٹ�����</th-->
			</tr>
			<tr>
				<td><%=board.getRc_ability()%></td>
				<td style="text-align: center"><span style="color: #fff; padding: 0 2px 2px 2px;"> <%
				 	if (board.getRc_sal() == 0) {
				 %>
					�����İ��� <%
				 	} else {
				 %> <%=board.getRc_sal()%> <%
				 	}
				 %></span>
				</td>
			</tr>
		</table>

		<!-- ä������ �ȳ�-->

		<div class="common_center MAT55">
			<h4 class="cStyle common_left" style="font-weight: normal;">
				<i class="fa fa-dot-circle-o" aria-hidden="true"></i> ä�������ȳ�
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
				<th>����</th>
				<td><%=info.getEl_part()%></td>
				<th>�ٹ�����</th>
				<%
					if (board.getRc_hirekind() == 1) {
				%>
				<td>������</td>
				<%
					} else {
				%>
				<td>�����</td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>�ٹ�����</th>
				<td><%=info.getEl_loc()%></td>
				<th>�����Ļ�</th>
				<td><%=info.getEl_environment()%></td>
			</tr>
			<tr>
				<th>����</th>
				<td>����</td>
				<th>���</th>
				<%
					if (board.getRc_career() == 1) {
				%>
				<td>����</td>
				<%
					} else if (board.getRc_career() == 2) {
				%>
				<td>���</td>
				<%
					} else {
				%>
				<td>����/���</td>
				<%
					}
				%>
			</tr>
			<tr>
				<th>�ٹ���</th>
				<td><%=board.getRc_worktime()%></td>
				<th>��������</th>
				<td><%=board.getRc_expire()%></td>
			</tr>
		</table>

		<!-- ä������ �ȳ�-->

		<!-- �󼼸����䰭 �ȳ�-->
		<div class="common_center MAT55">
			<h4 class="cStyle common_left" style="font-weight: normal;">
				<i class="fa fa-dot-circle-o" aria-hidden="true"></i> �󼼸����䰭
			</h4>
		</div>
		<div class="shop_detail_info_common_box"><%=board.getRc_content()%></div>
		<!-- �����ϱ� ��ư -->
		<div><input type="button" name="apply" value="�����ϱ�" <%if(board.getRc_url() != null){ %>disabled="disabled" <%} %>
				onclick="javascript:location.href='./ApplyView.re?cmp=<%=info.getEl_company()%>'">
			 <input type="button" name="url" value="Ȩ������" <%if(board.getRc_url()==null){ %>disabled="disabled" <%} %>
			 onclick="javascript:open_window();">
		</div>
	</div>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>