<!--  �� ���� �� ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
    //���޹��� �Ķ������ ������ �� ��ȣ�� num������ �����մϴ�.
	int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
 <title>MVC �Խ���</title>
 <link href="css/ch14_1.css" rel="stylesheet" type="text/css">
</head>
<body>
 <form name="deleteForm" 
       action="BoardDeleteAction.bo" 
	   method="post">
  <input type="hidden" name="num" value='<%=num %>'>	   
  <table border="1">
   <tr>
	<th>�� ��й�ȣ</th>
	<td>
		<input name="BOARD_PASS" type="password">
	</td>
   </tr>
   <tr>
	<td colspan=2 class="h30 center lime">
	    <!-- ���� ��ư�� Ŭ���ϸ� ���� submit �մϴ�. -->
		<a href="javascript:deleteForm.submit()">����</a>
		&nbsp;&nbsp;
		<!-- ���ư��⸦ Ŭ���ϸ� ���� �������� �̵��մϴ�. -->
		<a href="javascript:history.go(-1)">���ư���</a>
	</td>
</tr>
</table>
</form>
</body>
</html>