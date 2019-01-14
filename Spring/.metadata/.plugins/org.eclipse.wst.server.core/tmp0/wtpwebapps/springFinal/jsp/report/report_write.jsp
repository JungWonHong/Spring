<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./resources/js/jquery-3.2.1.js"></script>
<style>
#title {
	font-size: 30pt;
	font-weight: bold;
}

#title1 {
	font-size: 12pt;
}

#id1, #rid, #file {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

#id11, #file1 {
	border: 2px solid lightgray;
	width: 550px;
	height: 50px;
}

#rid1 {
	border: 2px solid lightgray;
}

#R_CATEGORY,#R_ILLEGALID{
	margin-left: 5%;
	width: 200px;
	height: 25px;
}

#R_CONTENT {
	width: 660px;
	height: 300px;
	margin-left:0%;
	margin-top:2%
}

.file_input label {
	margin-left: 70%;
	display: inline-block;
	overflow: hidden;
	width: 100px;
	height: 30px;
	background: #2ABCB4;
	text-align: center;
	line-height: 30px;
}

.file_input label input {
	position: absolute;
	width: 0;
	height: 0;
	overflow: hidden;
}

.file_input input[type=text] {
	display: inline-block;
	width: 350px;
	height: 28px;
	line-height: 28px;
	font-size: 12px;
	border: 1px solid #777;
}

#R_IMG {
	margin-top: -6%;
	margin-left: 5%
}

#sub {
	width: 100px;
	height: 30px;
	margin-left: 430%;
	background: #2ABCB4;
	border: 0px;
}

#reset {
	width: 100px;
	height: 30px;
	margin-left: 80%;
	background: lightgray;
	border: 0px;
}
</style>
<title>KHCC - 신고하기</title>
<script>
	$(document).ready(function() {

		$('.file_input input[type=file]').change(function() {

			var fileName = $(this).val();

			var fileCount = $(this).get(0).files.length;

			if ($(this).get(0).files.length == 1) {

				$('.file_input input[type=text]').val(fileName);

			}

			else {

				$('.file_input input[type=text]').val('파일 ' + fileCount + '개');

			}

		});
		  
/* 		$('submit').click(function(){
		 
			alert("전송이 되었습니다.");
			 
		}); */
	});
</script>
</head>
<body>
	<div id="title">신고하기</div>
	<div id="title1">신고접수를 통하여 편리하며 안전한 서비스를 위해 최선을 다하겠습니다.<br>
	      *작성란에 모두 기입해주시기 바랍니다.(증거확보)
	</div>
	<br>
	<br>
	<form method="post" action="khcc_reportwrite_ok.nhn"
		enctype="multipart/form-data">
		<input name="R_SENDER" type="hidden" id="R_SENDER"
			value="${sessionScope.login_email}">
		<table>
			<tr>
				<td id="id1">신고 유형</td>
				<td id="id11"><select name="R_CATEGORY" id="R_CATEGORY">
						<option>신고 유형을 선택하세요 </option>
						<option value="흡연신고">흡연신고</option>
						<option value="서비스/버그 신고">서비스/버그 신고</option>
						<option value="차량고장신고">차량고장신고</option>
						<option value="불편접수/신고">불편접수/신고</option>
						<option value="동물탑승신고">동물탑승신고</option>
						<option value="불법이용자 신고">불법이용자 신고</option>
						<option value="기타">기타</option>
				</select></td>
			</tr>
			<tr>
				<td id="rid">신고할 회원</td>
				<td id="rid1"><input name="R_ILLEGALID" type="text"
					id="R_ILLEGALID"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea name="R_CONTENT" id="R_CONTENT"></textarea></td>
			</tr>

			<tr>
				<td id="file">첨부파일</td>
				<td id="file1">
					<div class="file_input">
						<label> 파일 첨부 <input type="file" name="uploadfile" id="uploadfile">
						</label> <input title="File Route" type="text" id="R_IMG" readOnly>
					</div>
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><input type="submit" id="sub" value="전송"></td>
				<td><input type="reset" id="reset" value="다시쓰기"></td>
		</table>
	</form>
</body>
</html>