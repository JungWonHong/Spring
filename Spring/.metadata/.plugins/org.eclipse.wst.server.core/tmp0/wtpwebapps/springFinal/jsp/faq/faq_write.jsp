<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>REVIEW 등록</title>
<link rel="stylesheet" type="text/css"
	href="./resources/css/qa.css"/>
<link rel="stylesheet" type="text/css"
	href="./resources/css/admin.css"/>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2.js"></script>
</head>
<body>
	<div id="qawrite_wrap">
		<h2 class="qawrite_title">FAQ 등록</h2>
		<form method="post" action="faq_write_ok.nhn"
			onsubmit="return faqfind_check()" enctype="multipart/form-data">
			<!-- 파일 인코딩시 멀티파트 -->
			<table id="qawrite_t">
				<tr>
					<th>EMAIL</th>
					<td>
					<label>${login_email}</label>
					<input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
					<!-- <input name="faq_name" id="faq_name" size="14" class="input_box"> -->
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
					<label>${login_email}</label>
					<!-- <input type="password" name="faq_pass" id="faq_pass" size="14" class="input_box"> -->
					</td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td>
					<input name="faq_subject" id="faq_subject" size="40" class="input_box">
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
					<textarea name="faq_content" id="faq_content" rows="8" cols="50" class="input_box"></textarea>
					</td>
				</tr>
				
				<tr>
					<th>이미지등록</th>
					<td>
					<input type="file" name="uploadfile"
					style="border-radius:10px; color:black; background-color:#B1EFED; border:1px">
					</td>
				</tr>			
			</table>
			
			<div id="qawrite_menu">
				<input type="submit" value="등록" class="input_button"
				style="border-radius:10px; color:black; background-color:#B1EFED; border:1px">
				<input type="reset" value="취소" class="input_button" onclick="self.close();"
				style="border-radius:10px; color:black; background-color:#B1EFED; border:1px">
			</div>	
		</form>	
	</div>
</body>
</html>
<!-- onclick="$('#faq_name').focus(); -->