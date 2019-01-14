<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>�Խ��� ���뺸��</title>
	<link rel="stylesheet" type="text/css"
		   href="./resources/css/board.css"/>
</head>
<body>
	<div id="boardcont_wrap" style="width:600px">
		<h2 class="boardcont_title" style="width:370px">�Խù� ���뺸��</h2>
		<table id="boardcont_t">
			<tr>
				<th>����</th>
				<td>${bcont.board_subject }</td>
			</tr>
			
			<tr>
				<th>�۳���</th>
				<td>
					<%--<pre>�±׷� �Է��� �״�� ��µǰ� �մϴ�. ���͵� �� ���ɴϴ�.  --%>
					<%--<pre>${bcont.board_content}</pre> --%>
					<textarea rows="8" cols="50">${bcont.board_content }</textarea>
				</td>
			</tr>
			
			<tr>
				<th>��ȸ��</th>
				<td>
					${bcont.board_readcount }
				</td>
			</tr>
		</table>
		
		<div id="boardcont_menu" style="margin-left:200px">
			<input type="button" value="����" class="input_button"
				onclick="location='board_cont.nhn?board_num=${bcont.board_num}&page=${page }&state=edit'"/>
			
			<input type="button" value="����" class="input_button"
				onclick="location='board_cont.nhn?board_num=${bcont.board_num}&page=${page }&state=del'"/>
			
			<input type="button" value="�亯" class="input_button"
				onclick="location='board_cont.nhn?board_num=${bcont.board_num}&page=${page }&state=reply'"/>
			
			<input type="button" value="���" class="input_button"
				onclick="location='board_list.nhn?page=${page}'"/>
		</div>
	</div>
</body>
</html>