<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<title>ex_post.jsp</title>
<style>
body {
	width: 777px;
	margin: 20px auto;
}

fieldset {
	padding: 50px;
	width: 600px;
}
</style>
<script src="../../../js/jquery-3.2.1.js" ></script>
<script src="../../../js/validate_kr.js" charset="euc-kr"></script>

</head>

<body>
	<fieldset>
		<legend>유효성 검사</legend>
		<form name="myform" method="post" action="send.jsp">
          ID: <input type=text size=10 name=id id=id>
              <input type=button value="id중복체크" id=idcheck>
			<br> 비밀번호 <input type=password name=pass id=pass><br>
			주민번호 :<input type=text size=6 name=jumin1 id=jumin1 maxlength=6>-
			<input type=text size=7 name=jumin2 id=jumin2 maxlength=7><br>
			E-Mail: <input type=text name=email id=email>@<input
				type=text name=domain id=domain> 
			<select name=sel id=sel>
				<option value="">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>
			</select><br> 
			성별: <input type=radio name=gender id=gender1 value="woman">여자
			<input type=radio name=gender id=gender2 value="man">남자<br>
			취미: <input type=checkbox name=hobby id=hobby1 value="독서"> 독서
			<input type=checkbox name=hobby id=hobby2 value="놀기">놀기 <input
				type=checkbox name=hobby id=hobby3 value="등산">등산 <input
				type=checkbox name=hobby id=hobby4 value="노래">노래 <input
				type=checkbox name=hobby id=hobby5 value="게임">게임<br>
			우편번호:<input type=text size=3 name=post1 id=post1 maxlength=3>-
			<input type=text size=3 name=post2 id=post2 maxlength=3> <input
				type=button value=우편검색 id=postcode><br> 
			주소: <input type=text size=50 name=address id=address><br> 
			자기소개:
			<textarea rows=10 cols=75 name=intro id=intro></textarea>
			<br>
			<br> <input type=submit value="회원가입"> <input type=reset
				value="취소">

		</form>

	</fieldset>
</body>
</html>




