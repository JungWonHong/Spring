<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="semi.db.bean.*" %>
<%@ page import="semi.db.*" %>   
<%
	//저장되어 있던 글 내용 데이터를 화면에 보여주는 위해 rv 속성의 데이터를 가져옴
	ReviewBoardBean rv=(ReviewBoardBean)request.getAttribute("rv");
%>
<html>
<head>
	<script>
	function rvmodifyboard(){
		rvmodifyform.submit();
	}
	</script>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<form action="rvBoardModifyAction.bo" method="post" name="rvmodifyform">
	<input type="hidden" name="RV_NO" value=<%=rv.getRv_no() %>>
	<table>
		<tr>
			<th colspan="2">현장의 소리 - 수정 중</th>
		</tr>
		<tr>
			<td>
				<div>제 목</div>
			</td>
			<td>
				<input name="rv_title" size="50" maxlength="100"
					value="<%=rv.getRv_title() %>">
			</td>	
		</tr>
		<tr>
			<td>
				<div>내 용</div>
			</td>
			<td>
				<textarea name="rv_content" cols="67" rows="15"><%=rv.getRv_content() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="height:1px;">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="javascript:rvmodifyboard()">[수정]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)" >[뒤로]</a>&nbsp;&nbsp;
			</td>	
		</tr>	
	</table>
</form>
</body>
</html>