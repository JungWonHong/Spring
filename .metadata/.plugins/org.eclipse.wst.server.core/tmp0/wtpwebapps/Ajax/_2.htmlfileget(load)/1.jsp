<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>resource1</title>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
			$(function(){
				$.ajaxSetup({
					cache: false
				});
				$("button").click(function(){
					//html파일 가져옵니다.
					$("#container").load('resource1.html');
				});
			});
		</script>
	</head>
	<body>
		<button> 서버로부터 데이터 가져오기</button>
		<div id="container">데이터 가져오기 전</div>
	</body>
</html>