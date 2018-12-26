<%-- �۾��� �� ������ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<html>
<head>
	<title>MVC �Խ���</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">	
	<script src="js/jquery-3.2.1.js"></script>
	<script src="js/ch14.js"></script>
</head>
<body>
<%-- �Խ��� ��� 
 BoardAddAction.bo : ���� ���ó���ϴ�  BoardAddAction Ŭ������ ȣ���մϴ�.
     enctype="multipart/form-data" : ������ ���ε��� �� �ֵ��� �����մϴ�.
--%>
<form action="./BoardAddAction.bo" method="post" 
	enctype="multipart/form-data" name="boardform">
	
<table>
	<tr class="center">
		<th colspan="2">MVC �Խ���-write ������</th>
	</tr>
	<tr>
		<td>
			<div>�۾���</div>
		</td>
		<td>
			<input name="BOARD_NAME" type="text"   size="10" 
			       maxlength="10"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>��й�ȣ</div>
		</td>
		<td>
			<input name="BOARD_PASS" type="password"  size="10" 
			       maxlength="10"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<input name="BOARD_SUBJECT"   type="text" 
			       size="80"   maxlength="100"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="83" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<div>���� ÷��</div>
		</td>
		<td>
			<input name="BOARD_FILE" type="file">
		</td>
	</tr>
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr class="center">
		<td colspan="2" class="h30 lime">
		    <!-- ����� Ŭ���� ���  addboard()�� ȣ���մϴ�.-->
			<a href="javascript:addboard()">[���]</a>&nbsp;&nbsp;
			
			<!-- �ڷθ� Ŭ���� ��� ���� �������� �̵��մϴ�. -->
			<a href="javascript:history.go(-1)">[�ڷ�]</a>
		</td>
	</tr>
   </table>
 </form>
</body>
</html>