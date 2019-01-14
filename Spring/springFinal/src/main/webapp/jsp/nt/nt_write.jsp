<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>REVIEW 등록</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<style>
#qawrite_t{margin-top:10%}
.qawrite_title {
	font-size: 30pt;
	font-weight: bold;
}

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
    width:850px;
	height: 300px;
}

#nt_content {
	width: 670px;
	height: 300px
}

#nt_subject {
	width: 560px;
	height: 50px;
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
	margin-top:-5%;
	margin-left:4%
}

.writesub {	
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;
	
}
.subdiv{margin-left:35%; margin-top:5%}
.backdiv{margin-left:52%; margin-top:-4.4%}
.back {
	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;
	
}

</style>
</head>
<body>
	<div id="qawrite_wrap">
		<h2 class="qawrite_title">공지사항 등록</h2>
		<form method="post" action="nt_write_ok.nhn"
			onsubmit="return ntfind_check()" enctype="multipart/form-data">
			<!-- 파일 인코딩시 멀티파트 -->
			<input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
			<table id="qawrite_t">

          

				<tr>
					<th>제목</th>
					<td><input name="nt_subject" id="nt_subject" size="40">
					</td>
				</tr>

				<tr>
				  
					<td colspan="2" class="text"><textarea name="nt_content" id="nt_content"></textarea></td>
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

			<div class="subdiv">
			 <input type="hidden" name="page" value="${page}" id="page" />
				<input type="submit" value="등록" class="writesub"> 
		    </div>
		    <div class="backdiv">
				<input	type="reset" value="취소" class="back" onclick="self.close();">
			</div>
		</form>
	</div>
</body>
</html>
<!-- onclick="$('#nt_name').focus(); -->