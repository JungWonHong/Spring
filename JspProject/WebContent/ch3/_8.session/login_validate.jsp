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
						alert("���̵� �Է��ϼ���");
						$("input:text").focus();
						return false;
					}
					if($("input:password").val()==""){
						alert("��й�ȣ�� �Է��ϼ���");
						$("input:password").focus();
						return false;
					}
				});
			});
		</script>
	</head>
	<body>
		<form action="login_ok" method="post">
			���̵� : <input type="text" name="id"/><br>
			��й�ȣ : <input type="password" name="passwd"/><br>
			<input type="submit" value="�α���"/>
		</form>
	</body>
</html>