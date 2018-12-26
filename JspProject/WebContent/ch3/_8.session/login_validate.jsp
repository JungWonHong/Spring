<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>login.jsp</title>
		<script src="../../js/jquery-3.2.1.js"></script>
		<script>
			$(function(){
				$("form").submit(function(){
					if($("input:text").val()==""){
						alert("아이디를 입력하세요");
						$("input:text").focus();
						return false;
					}
					if($("input:password").val()==""){
						alert("비밀번호를 입력하세요");
						$("input:password").focus();
						return false;
					}
				});
			});
		</script>
	</head>
	<body>
		<form action="login_ok" method="post">
			아이디 : <input type="text" name="id"/><br>
			비밀번호 : <input type="password" name="passwd"/><br>
			<input type="submit" value="로그인"/>
		</form>
	</body>
</html>