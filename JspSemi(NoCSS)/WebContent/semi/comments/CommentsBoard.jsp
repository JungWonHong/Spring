<!--��� ������ -->

<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "semi.db.*" %>
<%
	request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
<title>JOBS - CommentsBoard</title>
</head>
<style>
	@CHARSET "EUC-KR";
	div {width:800px; height:100px}
	table{margin:0 auto; width:800px; text-align:center;}
	tr{height:20px; background:silver;}
	tr:first-child {height:10px;}
	td{font-family:����; font-size:14; height:36px}
	.center {margin:0 auto}
</style>
<body>
<%-- �Խ��� ��� 
 ReplyAddAction.bo : ���� ���ó���ϴ�  ReplyAddAction Ŭ������ ȣ���մϴ�.
--%>
<form action="./CommentsAddAction.co" method="post" name="Commentsform">
	
	
<!-- ��� �Է�â -->
<div class="center">
<label>id ����</label><br>
<textarea name="comment_content" cols="90" rows="3" placeholder="������ �ǰ��� �����ּ���.(����ȸ�� �α��� �� �̿� ����)"></textarea>
<input type="button" name="registration" value="���" width=100px height=200px >
</div>
<table>
	<tr>
		<td>�ۼ���</td>
		<td>��¥</td>
		<td>���</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td>genie</td>
		<td>2017.07.24 12:46</td>
		<td>�ȳ��ϼ���~~~~~~~~~~~~~~~~~~~~~</td>
		<td>���</td>
		<td>����</td>
		<td>����</td>
	</tr>
</table>
</form>
</body>
</html>