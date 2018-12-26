<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	//전달받은 파라미터인 삭제할 글 번호를 num 변수에 저장합니다.
	//list 페이지에서 받아온 값
	int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
<title>Source Board</title>
<script>
	function windowclose() {
		self.close();
	}

	function goSubmit() {
		window.opener.name = "parentPage"; // 부모창의 이름 설정
		document.sbdeleteForm.target = "parentPage"; // 타켓을 부모창으로 설정
		document.sbdeleteForm.action = "sbBoardDeleteAction.bo";
		document.sbdeleteForm.submit();
		self.close();
	}
</script>
</head>
<body>
	<form name="sbdeleteForm" action="sbBoardDeleteAction.bo" method="post">
		<input type="hidden" name="sb_no" value='<%=num%>'>
		<table>
			<tr>
				<th colspan=2>삭제 하시겠습니까?</th>
			</tr>
			<tr>
				<td colspan=2><a href="javascript:goSubmit()">삭제</a>
					&nbsp;&nbsp; <a href="javascript:windowclose()">돌아가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>