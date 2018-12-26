<%-- �� ���� �� ������ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="net.board.db.*" %>
<%
    //����Ǿ� �ִ� �� ���� �����͸� ȭ�鿡 �����ֱ� ���� boarddata �Ӽ��� �����͸�  �����ɴϴ�.
	BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>
<!Doctype html>
<html>
<head>
	<title>MVC �Խ���</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
	<script>
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>

<body>
<!-- �Խ��� ���� -->
<form action="BoardModifyAction.bo" method="post" name="modifyform">
<input type="hidden" name="BOARD_NUM" value=<%=board.getBOARD_NUM() %>>
<table>
	<tr>
		<th colspan="2">MVC �Խ��� - Modify view</th>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<input name="BOARD_SUBJECT" size="50" maxlength="100" 
				value="<%=board.getBOARD_SUBJECT()%>">
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15"><%=board.getBOARD_CONTENT() %></textarea>
		</td>
	</tr>
	<%if(!(board.getBOARD_FILE()==null)){ %>
	<tr>
		<td>
			<div>���� ÷��</div>
		</td>
		<td>
			&nbsp;&nbsp;<%=board.getBOARD_FILE() %>
		</td>
	</tr>
	<%} %>
	<tr>
		<td>
			<div>��й�ȣ</div>
		</td>
		<td>
			<input name="BOARD_PASS" type="password">
		</td>
	</tr>
	
	<tr bgcolor="00ffff">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	
	<tr class="center">
		<td colspan="2" class="h30 lime">
			<a href="javascript:modifyboard()">[����]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[�ڷ�]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</form>
<!-- �Խ��� ���� -->
</body>
</html>