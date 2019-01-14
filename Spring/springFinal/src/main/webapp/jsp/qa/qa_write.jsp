<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>REVIEW 등록</title>
<style>
.qaedit_title{font-size: 30pt; font-weight: bold;}
#qaedit_t{margin-top:10%}
th {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

td {
	border: 2px solid lightgray;
	width: 510px;
	height: 50px;
}
.qaedit_pass,.qaedit_name,.qaedit_subject{width:550px;height: 50px;}
.qaedit_text,.qaedit_td{    width:660px;
	height: 300px;}
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


.qaedit_bt{    
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;}
	
.qaedit_back{	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;}	
.qnafilediv{margin-top:-5%}
#qawrite_menu{margin-top:5%; margin-left:36%}
</style>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
</head>
<body>
	<div id="qawrite_wrap">
		<h2 class="qaedit_title">REVIEW 등록</h2>
		<form method="post" action="qa_write_ok.nhn"
			onsubmit="return find_check()" enctype="multipart/form-data">
			<!-- 파일 인코딩시 멀티파트 -->
			<table id="qawrite_t">
				<tr>
					<th>ID</th>
					<td>
					<label>${login_email}</label>
					<input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
					<!-- <input name="qa_name" id="qa_name" size="14" class="input_box"> -->
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
					<input type="password" name="qa_pass" class="qaedit_name" id="qa_pass" size="14" class="qaedit_pass">
					</td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td>
					<input name="qa_subject" id="qa_subject" size="40" class="qaedit_subject">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" class="qaedit_td" >
					<textarea name="qa_content" id="qa_content" rows="8" cols="50" class="qaedit_text"></textarea>
					</td>
				</tr>
				
				<tr>
					<th>이미지등록</th>
					<td>
						<div class="file_input">
							<label> 파일 첨부 
								<input type="file" name="uploadfile" id="uploadfile">

							</label> 
							<div class="qnafilediv">
								<input title="File Route" type="text" readonly="readonly" id="nt_file">
                            </div>
						</div>   
					</td>
				</tr>			
			</table>
			
			<div id="qawrite_menu">
				<input type="submit" value="등록" class="qaedit_bt">
				<input type="reset" value="취소" class="qaedit_back" onclick="self.close();">
			</div>	
		</form>	
	</div>
</body>
</html>
<!-- onclick="$('#qa_name').focus(); -->