<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<script src="./js/jquery-3.2.1.js"></script>
<script>
$(document).ready(function(){
   $("form").submit(function(){
      if($.trim($("#keyWord").val())==""){
         alert("�˻�� �Է��ϼ���");
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
	<form name="search" method="get" action="sbBoardSearchAction.bo">
	<table>
		<tr align="right">
			<td colspan="5">
				<select name="keyField">
					<option value="sb_id">���̵�</option>
					<option value="sb_title">����</option>
					<option value="sb_content">����</option>
				</select>
				<input type="text" name="keyWord" id="keyWord"/>
				<input type="submit" value="�˻�" />
			</td>
		</tr>	
	</table>
	</form>
	
</body>
</html>