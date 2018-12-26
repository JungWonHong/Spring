<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="semi.db.bean.*" %>
    
<%
    //저장되어 있던 글 내용 데이터를 화면에 보여주기 위해 boarddata 속성의 데이터를  가져옵니다.
	CommentsBean cmt = (CommentsBean)request.getAttribute("cmtdata");
%>
    
<html>
<head>
<title>댓글 수정</title>
</head>
<body>
<form name="ModifyForm" action="CommentsModifyAction.co" method="post">
<input type="hidden" name="com_no" value="<%=cmt.getCom_no() %>">
<table>
	<tr>
		<th colspan="2">댓글 게시판 - Modify view</th>
	</tr>
	<tr>
		<td><textArea cols="50" rows="3" name="cmtcontent"><%=cmt.getCom_content() %></textArea></td>
	</tr>
	<tr>
		<td colspan=2>
			 <a href="javascript:ModifyForm.submit()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:self.close()">[취소]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</form>
</body>
</html>