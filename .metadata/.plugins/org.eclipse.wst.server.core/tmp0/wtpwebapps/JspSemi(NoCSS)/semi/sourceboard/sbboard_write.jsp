<%-- �۾��� �� ������ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<% String id=(String)session.getAttribute("id"); %>

<html>
<head>
	<title>�ڵ� �Խ���</title>
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./js/sbwrite2.js"></script>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<form action="sbBoardAddAction.bo" method="post" 
	enctype="multipart/form-data" name="boardform">
	
<table>
	<tr>
		<td>
			<div>�۾���</div>
		</td>
		<td>
			<%=id %>
			<input type="hidden" name="id" value="<%=id %>">
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<input id="sb_title" name="sb_title"   type="text" 
			       size="80"   maxlength="100"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>�� ��</div>
		</td>
		<td>
			<textarea id="sb_content" name="sb_content" cols="83" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<div>���� ÷��</div>
		</td>
		<td>
			<input name="sb_file" type="file">
		</td>
	</tr>
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<% if(id!=null&&id.length()!=0){ %>
	<tr class="center">
		<td colspan="2" class="h30 lime">
		    <!-- ����� Ŭ���� ���  addboard()�� ȣ���մϴ�.-->
			<a id="sbwrite" href="javascript:addboard()">[���]</a>&nbsp;&nbsp;
			
			<!-- �ڷθ� Ŭ���� ��� ���� �������� �̵��մϴ�. -->
			<a href="javascript:history.go(-1)">[�ڷ�]</a>
		</td>
	</tr>
	<%} %>
   </table>
 </form>
</body>
</html>