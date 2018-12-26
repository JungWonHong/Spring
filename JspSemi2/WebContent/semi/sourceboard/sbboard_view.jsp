<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*"%>
<%@ page import="semi.db.*"%>
<%
	//�Խù��� ������ ����ִ� boarddata �Ӽ��� �����͸� BoardBean Ÿ������ 
	//��ȯ�Ͽ� ����ϴ�.
	String id = (String) session.getAttribute("id");
	SourceBoardBean sb = (SourceBoardBean) request.getAttribute("sb");
%>
<html>
<head>
<title>Source Board - view</title>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
   function windowopen(){
   		var popUrl = "./sbBoardDelete.bo?num=<%=sb.getSb_no()%>"; //�˾�â�� ��µ� ������ URL
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; //�˾�â �ɼ�(optoin)
		window.open(popUrl, "", popOption);
	}
</script>
</head>

<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<!-- �Խ��� ���� -->
	<table>
		<tr valign="middle">
			<th colspan="2">�ڵ� �Խ���-view������</th>
		</tr>
		<tr>
			<td>
				<div>�۾���</div>
			</td>
			<td><%=sb.getSb_id()%></td>
		</tr>
		<tr>
			<td>
				<div>�� ��</div>
			</td>
			<td><%=sb.getSb_title()%><!-- �Խù��� ������ ����մϴ�. --></td>
		</tr>
		<tr>
			<td>
				<div>�� ��</div>
			</td>
			<td><textarea name="sb_content" cols="67" rows="15"
					readonly="readonly"><%=sb.getSb_content()%></textarea></td>
		</tr>
		<tr>
			<td>
				<div>÷������</div>
			</td>
			<td>
				<!-- �Խù��� ÷�������� ������ ��� ÷�� ������ ��ũ�� ǥ���մϴ�. --> <%
 	if (!(sb.getSb_file() == null)) {
 %> <a
				href="./semi/sourceboard/file_down.jsp?file_name=<%=sb.getSb_file()%>"
				download> <%=sb.getSb_file()%>
			</a> <%
 	}
 %>
			</td>
		</tr>

		<!-- ����, ����, ����� ��ũ�� ǥ���մϴ�. -->
		<tr>
			<td colspan="2" class="h30 lime center">
				<%
					if (id != null && id.length() != 0) {
						if (id.equals(sb.getSb_id()) || id.equals("admin")) {
				%> <a href="./sbBoardModify.bo?num=<%=sb.getSb_no()%>"> [����] </a>&nbsp;&nbsp;
				   <a href="javascript:windowopen();"> [����] </a>&nbsp;&nbsp;
				<%
					}
					}
				%> <a href="./sbBoardList.bo">[���]</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	<jsp:include page="../comments/Comments_List.jsp"></jsp:include>
	<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>