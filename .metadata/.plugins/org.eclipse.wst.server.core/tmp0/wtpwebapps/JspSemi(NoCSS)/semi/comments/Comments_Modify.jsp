<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="semi.db.bean.*" %>
    
<%
    //����Ǿ� �ִ� �� ���� �����͸� ȭ�鿡 �����ֱ� ���� boarddata �Ӽ��� �����͸�  �����ɴϴ�.
	CommentsBean cmt = (CommentsBean)request.getAttribute("cmtdata");
%>
    
<html>
<head>
<title>��� ����</title>
</head>
<body>
<form name="ModifyForm" action="CommentsModifyAction.co" method="post">
<input type="hidden" name="com_no" value="<%=cmt.getCom_no() %>">
<table>
	<tr>
		<th colspan="2">��� �Խ��� - Modify view</th>
	</tr>
	<tr>
		<td><textArea cols="50" rows="3" name="cmtcontent"><%=cmt.getCom_content() %></textArea></td>
	</tr>
	<tr>
		<td colspan=2>
			 <a href="javascript:ModifyForm.submit()">[����]</a>&nbsp;&nbsp;
			<a href="javascript:self.close()">[���]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</form>
</body>
</html>