<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>   
<%
	//����Ǿ� �ִ� �� ���� �����͸� ȭ�鿡 �����ִ� ���� rv �Ӽ��� �����͸� ������
	ReviewBoardBean rv=(ReviewBoardBean)request.getAttribute("rv");
%>
<html>
<head>
	<script>
	function rvmodifyboard(){
		rvmodifyform.submit();
	}
	</script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
	<style>
	table {width:600px;}
	td {text-align:center;}
	</style>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<jsp:include page="../menubar.jsp"></jsp:include>
	<form action="rvBoardModifyAction.bo" method="post" name="rvmodifyform">
	<input type="hidden" name="RV_NO" value=<%=rv.getRv_no() %>>
	<table>
		<tr>
			<th colspan="2">Review - ���� ������</th>
		</tr>
		<tr>
			<td>
				<div>�� ��</div>
			</td>
			<td>
				<input name="rv_title" size="65" maxlength="100"
					value="<%=rv.getRv_title() %>">
			</td>	
		</tr>
		<tr>
			<td>
				<div>�� ��</div>
			</td>
			<td>
				<textarea name="rv_content" cols="67" rows="15"><%=rv.getRv_content() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="javascript:rvmodifyboard()">[����]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)" >[�ڷ�]</a>&nbsp;&nbsp;
			</td>	
		</tr>	
	</table>
</form>
<jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>