<!--  �� ������ �����ִ� View ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="euc-kr"%>
<%@ page import="net.board.db.*" %>
<%
//�Խù��� ������ ����ִ� boarddata �Ӽ��� �����͸� BoardBean Ÿ������ 
//��ȯ�Ͽ� ����ϴ�.
  BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>
<html>
<head>
	<title>MVC �Խ���</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- �Խ��� ���� -->
<table>
	<tr valign="middle">
		<th colspan="2">MVC �Խ���-view������</th>
	</tr>	
	<tr>
		<td>
			<div>�۾���</div>
		</td>		
		<td>
		<%=board.getBOARD_NAME()%>
		</td>
	</tr>	
	<tr>
		<td>
			<div>�� ��</div>
		</td>		
		<td>
		<%=board.getBOARD_SUBJECT()%><!-- �Խù��� ������ ����մϴ�. -->
		</td>
	</tr>	
	<tr>
		<td>
			<div>�� ��</div>
		</td>		
		<td>		
		 <textarea name="BOARD_CONTENT" 
		   cols="67" rows="15"><%=board.getBOARD_CONTENT() %></textarea>
		</td>			
	</tr>	
	<tr>
		<td>
			<div>÷������</div>
		</td>
		<td>
		<!-- �Խù��� ÷�������� ������ ��� ÷�� ������ ��ũ�� ǥ���մϴ�. -->
		<%if(!(board.getBOARD_FILE()==null)){ 			
		%>
		 <a href="./boardupload/<%=board.getBOARD_FILE()%>" download>
			<%=board.getBOARD_FILE() %>
		    </a>
	    <%} %>
		</td>
	</tr>
	
	<tr bgcolor="00ffff">
		<td colspan="2" style="height:1px;"></td>
	</tr>

	<!-- �亯, ����, ����, ����� ��ũ�� ǥ���մϴ�. -->
	<tr>
		<td colspan="2" class="h30 lime center">
			<a href="./BoardReplyView.bo?num=<%=board.getBOARD_NUM() %>">
			[�亯]
			</a>&nbsp;&nbsp;
			<a href="./BoardModify.bo?num=<%=board.getBOARD_NUM() %>">
			[����]
			</a>&nbsp;&nbsp;
			<a href="./BoardDelete.bo?num=<%=board.getBOARD_NUM() %>">
			[����]
			</a>&nbsp;&nbsp;
			<a href="./BoardList.bo">[���]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</body>
</html>