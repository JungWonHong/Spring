<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시판 내용보기</title>
	<link rel="stylesheet" type="text/css"
		   href="./resources/css/board.css"/>
</head>
<body>
	<div id="boardcont_wrap" style="width:600px">
		<h2 class="boardcont_title" style="width:370px">게시물 내용보기</h2>
		<table id="boardcont_t">
			<tr>
				<th>제목</th>
				<td>${bcont.board_subject }</td>
			</tr>
			
			<tr>
				<th>글내용</th>
				<td>
					<%--<pre>태그로 입력한 그대로 출력되게 합니다. 엔터도 잘 나옵니다.  --%>
					<%--<pre>${bcont.board_content}</pre> --%>
					<textarea rows="8" cols="50">${bcont.board_content }</textarea>
				</td>
			</tr>
			
			<tr>
				<th>조회수</th>
				<td>
					${bcont.board_readcount }
				</td>
			</tr>
		</table>
		
		<div id="boardcont_menu" style="margin-left:200px">
			<input type="button" value="수정" class="input_button"
				onclick="location='board_cont.nhn?board_num=${bcont.board_num}&page=${page }&state=edit'"/>
			
			<input type="button" value="삭제" class="input_button"
				onclick="location='board_cont.nhn?board_num=${bcont.board_num}&page=${page }&state=del'"/>
			
			<input type="button" value="답변" class="input_button"
				onclick="location='board_cont.nhn?board_num=${bcont.board_num}&page=${page }&state=reply'"/>
			
			<input type="button" value="목록" class="input_button"
				onclick="location='board_list.nhn?page=${page}'"/>
		</div>
	</div>
</body>
</html>