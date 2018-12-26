<!-- �� �亯 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="net.board.db.*" %>
<%
//�Խù��� ������ ��� �ִ� boarddata �Ӽ��� �����͸� BoardBean Ÿ������ ��ȯ�Ͽ� �����ɴϴ�.
	BoardBean board=(BoardBean)request.getAttribute("boarddata");
%>

<html>
<head>
	<title>MVC �Խ���</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
	<script>
	//replyboard()�� ȣ���ϸ� ���� submit�մϴ�.
	function replyboard(){
		boardform.submit();
	}
	</script>
</head>
<body>
<!-- �Խ��� �亯 -->
<!-- �亯�� Ŭ���ϸ�  BoardReplyAction Ŭ������ ȣ���Ͽ� �亯 ó���� �ǵ��� �մϴ�.-->
<form action="./BoardReplyAction.bo" method="post" name="boardform">
  <!-- ���� ���� ������ hidden������ ������ �ֽ��ϴ�. -->
  <input type="hidden" name="BOARD_NUM" 
         value="<%=board.getBOARD_NUM() %>">
       
  <input type="hidden" name="BOARD_RE_REF" 
         value="<%=board.getBOARD_RE_REF() %>">
       
  <input type="hidden" name="BOARD_RE_LEV" 
         value="<%=board.getBOARD_RE_LEV() %>">
       
  <input type="hidden" name="BOARD_RE_SEQ" 
         value="<%=board.getBOARD_RE_SEQ() %>">

  <table>
	<tr>
		<th colspan="2">MVC �Խ���-Reply</th>
	</tr>
	<tr>
		<td>
			<div>�۾���</div>
		</td>
		<td>
			<input name="BOARD_NAME" type="text"/>
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
		   <!-- �亯 �� �������� ���� �κп��� �� �տ� Re:�� �ٰ� ���� �� ������ ���ɴϴ�. -->
			<input name="BOARD_SUBJECT" type="text" size="50" 
				   maxlength="100" 
				   value="Re: <%=board.getBOARD_SUBJECT() %>"/>
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
		</td>
	</tr>
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
		<!-- ����� Ŭ���ϸ� ���� submit �մϴ�. -->
		<a href="javascript:replyboard()">[���]</a>&nbsp;&nbsp;
		<!-- �ڷθ� Ŭ���ϸ� ���� �������� �̵��մϴ�. -->
		<a href="javascript:history.go(-1)">[�ڷ�]</a>
		</td>
	</tr>
</table>
</form>
<!-- �Խ��� �亯 -->
</body>
</html>

