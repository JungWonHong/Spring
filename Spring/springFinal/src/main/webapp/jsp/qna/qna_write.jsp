<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>REVIEW 등록</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<style>
#qnawrite_t{margin-top:10%}
.qnawrite_title{font-size: 30pt; font-weight: bold;}

th {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

td {
	border: 2px solid lightgray;
	width: 540px;
	height: 50px;
}
.text {
    width:690px;
	height: 300px;
}
#qna_content {
	width: 660px;
	height: 300px
}
#qna_subject {
	width: 550px;
	height: 50px;
}
#qna_pass{
	width: 550px;
	height: 50px;}
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
	margin-top:-5%;
	margin-left:4%
}
.qna_write{	
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;
	
}
.qna_back {
	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;
	
}
#qnasubdiv{margin-left:35%; margin-top:5%}

</style>
</head>
<body>
	<div id="qawrite_wrap">
		<h2 class="qnawrite_title">1:1문의 등록</h2>
		<form method="POST" action="qna_write_ok.nhn"
			onsubmit="return qnafind_check()" enctype="multipart/form-data">
			<!-- 파일 인코딩시 멀티파트 -->
			<table id="qnawrite_t">
				<tr>
					<th>EMAIL</th>
					<td>
					<label>${login_email}</label>
					<input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
					<!-- <input name="qna_name" id="qna_name" size="14" class="input_box"> -->
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
					<input type="password" name="qna_pass" id="qna_pass" size="14" class="input_box">
					</td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td>
					<input name="qna_subject" id="qna_subject" size="40" class="input_box">
					</td>
				</tr>
				
				<tr>
					
					<td colspan="2" class="text">
					<textarea name="qna_content" id="qna_content" rows="8" cols="50" class="input_box"></textarea>
					</td>
				</tr>
				
				<tr>
					<th>이미지등록</th>
					<td>
			<div class="file_input">

							<label> 파일 첨부 
								<input type="file" name="uploadfile" id="uploadfile">

							</label> 
								<input title="File Route" type="text" readonly="readonly" id="nt_file">

						</div>
					</td>
				</tr>			
			</table>
			
			<div id="qnasubdiv">
				<input type="submit" value="등록" class="qna_write">
				<input type="reset" value="취소" class="qna_back"  onclick="self.close();">
			</div>	
		</form>	
	</div>
</body>
</html>
