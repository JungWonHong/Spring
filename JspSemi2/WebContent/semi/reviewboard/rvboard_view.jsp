<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*"%>
<%@ page import="semi.db.*"%>
<%
	String id = (String) session.getAttribute("id");
	//�Խù��� ������ ����ִ� boarddata �Ӽ��� �����͸� BoardBean Ÿ������ 
	//��ȯ�Ͽ� ����ϴ�.
	ReviewBoardBean rv = (ReviewBoardBean) request.getAttribute("rv");
%>
<html>
<head>
<title>Review �Խ���</title>
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
	td {text-align:center;}
</style>
<script type="text/javascript">
		function windowopen(){
		    var popUrl = "./rvBoardDelete.bo?num=<%=rv.getRv_no()%>"; //�˾�â�� ��µ� ������ URL
			var popOption = "width=600, height=150, resizable=no, scrollbars=no, status=no;"; //�˾�â �ɼ�(optoin)
			window.open(popUrl, "", popOption);
	}
</script>
</head>

<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<!-- �Խ��� ���� -->
	<table>
		<tr valign="middle">
			<th colspan="2">������ �Ҹ� view</th>
		</tr>
		<tr>
			<td>
				<div>�۾���</div>
			</td>
			<td><%=rv.getRv_id()%></td>
		</tr>
		<tr>
			<td>
				<div>�� ��</div>
			</td>
			<td><%=rv.getRv_title()%><!-- �Խù��� ������ ����մϴ�. --></td>
		</tr>
		<tr>
			<td>
				<div>��� ����</div>
			</td>
			<td>

				<p class="star_rating">
					<%
						System.out.println(rv.getRv_score());
						for (int n = 0; n < rv.getRv_score(); n++) {
					%>
					<a class="on" href="javascript:void(0)">��</a>
					<%
						}
						int a = 5 - rv.getRv_score();
						if (a > 0) {
							for (int n = 0; n < a; n++) {
					%>
					<a class="off" href="javascript:void(0)">��</a>
					<%
						}
						}
					%>
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<div>�� ��</div>
			</td>
			<td><textarea name="rv_content" cols="67" rows="15"
					readonly="readonly"><%=rv.getRv_content()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2" class="h30 lime center">
				<%
					if (id != null && id.length() != 0) {
						if (id.equals(rv.getRv_id()) || id.equals("admin")) {
				%> <a
				href="./rvBoardModify.bo?num=<%=rv.getRv_no()%>"> [����] </a>&nbsp;&nbsp;
				<a href="javascript:windowopen();"> [����] </a>&nbsp;&nbsp; <%
 	}
 	}
 %> <a href="./rvBoardList.bo">[���]</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	<jsp:include page="../Footer.jsp"></jsp:include>
	
</body>
</html>