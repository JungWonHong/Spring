<%--sample1.txt를 파일 -> properties -> utf-8로 작성합니다. --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>sample1</title>
		<link href="../css/ex1.css" rel="stylesheet" type="text/css">
		<script src="../js/jquery-3.2.1.js"></script>
		<!-- function(responseTxt, status, xhr)
			- responseTxt : 서버로 부터 리턴된 텍스트 데이터를 가져옵니다.
			- status : 서버로 부터의 리턴된 상태를 가져옵니다.
				(성공인 경우 "success", 실패한 경우 "error")
			- xhr : XMLHttpRequest 객체를 포함합니다.
			- xhr.statusText : 상태 설명 문자열을 가져 옵니다.(주로 오류 내용을 가져오기)
			- xhr.status : 상태 코드를 가져옵니다.
			예) 200 : 서버가 응답을 완료했으며 아무런 문제가 없는 경우
			   304 : 응답 내용이 이전 응답 내용과 동일한 경우
			   404 : 파일을 찾지 못하는 경우
			   500 : 서버에서 클라이언트 요청을 처리 중에 에러 발생한 경우
			    -->
		<script>
			$(function(){
				$.ajaxSetup({
					cache: false
				});
				
				$("button").click(function(){ //변경을 클릭하면
					$("#div1").load("sample1.txt",
										function(responseTxt, status, xhr){
											if(status == "success"){
												alert(responseTxt);
											} else if(status == "error"){ //파일명을 sample.txt로 변경해 보세요
												alert("xhr.status : " + xhr.status  //404
														+ "\n xhr.statusText : " + xhr.statusText); //error
											}
										}
					);
				});
			});
		</script>
	</head>
	<body>
		<pre id="div1">버튼을 클릭하면 이곳에 sample1.txt의 내용이 나타납니다.</pre>
		<button>sample1.txt 불러오기</button>
	</body>
</html>