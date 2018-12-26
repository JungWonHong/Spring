<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<script src="./js/jquery-3.2.1.js"></script>

<script>
$(document).ready(function(){
   $("form").submit(function(){
      if($.trim($("#keyWord").val())==""){
         alert("검색어를 입력하세요");
         $("#keyWord").focus();
         return false;
      }
   });
});
</script>
<link href="./css/board.css" rel="stylesheet" type="text/css"/>
<link href="./css/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<form name="search" method="post" action="rvBoardSearchAction.bo">
	<table>
		<tr align="right">
			<td colspan="5">
				<select name="keyField">
					<option value="rv_id">아이디</option>
					<option value="rv_title">제목</option>
					<option value="rv_content">내용</option>
				</select>
				<input type="text" name="keyWord" id="keyWord"/>
				<input type="submit" value="검색" />
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>