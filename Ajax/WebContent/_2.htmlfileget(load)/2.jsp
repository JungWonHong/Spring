<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>서버의 데이터를 대상 엘리먼트에 삽입하기</title>
		<style>
			div {
				width: 180px; height: 80px;
				margin: 3px; float: left;
			}
		</style>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
		/*
		 - jQuery에서 제공해주는 load() 함수를 사용해서 서버의 menu.html 페이지의
		 	데이터를 가져와서 특정 엘리먼트에 추가합니다.
		*/
			$(function(){
				$.ajaxSetup({
					cache: false
				});
				$("#menu1").click(function(){
					//html파일 가져옵니다.
					$("#message1").load('menu.html');
				});
				$("#menu2").click(function(){
					//html파일 가져옵니다.
					$("#message2").load('menu.html li');
				});
			});
		</script>
	</head>
	<body>
		<div>
			<a href="#" id="menu1">메뉴 보기1</a><p>
			<span id="message1">하하</span>
		</div>
		<div>
			<a href="#" id="menu2">메뉴 보기2</a><p>
			<span id="message2"></span>
		</div>
	</body>
</html>