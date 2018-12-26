<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>placeholder</title>
		<link href="../../css/form.css" rel="stylesheet" type="text/css">
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
			$(function(){
				$("form").submit(function(e){ //전송 버튼 클릭시
					
					e.preventDefault();
					
					var check = 0; //이름에 포커스를 줄때는 check=0입니다.
								   //나이에 포커스를 줄때는 check=0입니다.
								   //주소에 포커스를 줄때는 check=0입니다.
					
					if($("#name").val()==""){//이름을 입력하지 않는 경우
						$("#name").attr("placeholder", "이름을 입력하세요");
						//이름에 포커스를 줍니다.
						$("#name").focus();
						check++;
					}
					
					if($("#age").val()==""){//나이를 입력하지 않는 경우
						//placeholder의 값을 변경합니다.
						$("#age").attr("placeholder", "나이를 입력하세요");
						//나이에 포커스를 줍니다.
						if(check==0) $("#age").focus();
						check++;
					}
					
					if($("#address").val()==""){//주소를 입력하지 않는 경우
						//placeholder의 값을 변경합니다.
						$("#address").attr("placeholder", "주소를 입력하세요");
						//이름에 포커스를 줍니다.
						if(check==0) $("#adderss").focus();
						check++;
					}
					
					//input 태그 중 빈 곳이 한 곳이라도 있으면 placeholder의 색상을 변경합니다.
					if(check!=0){
						//placeholder의 색상을 빨간색으로 변경하는 스타일을 head태그 뒤에 추가합니다.
						$("<style>input::-webkit-input-placeholder{color:red}</style>").appendTo("head"); //크롬, 사파리
						$("<style>input::-moz-placeholder{color:red}</style>").appendTo("head"); //파이어폭스
						$("<style>input::-ms-input-placeholder{color:red}</style>").appendTo("head"); //IE
					} else {
						$("style").remove(); //style엘리먼트를 삭제합니다.
						
						var data = $("form").serialize(); //서버로 보낼 데이터를 폼에서 얻어옵니다.
														  //입력 양식에 적힌 값을 쿼리 문자열로 바꿉니다.
						$("div").load("process.jsp", data);
					}
				}); //click end
			}); //ready end
		</script>
	</head>
	<body>
		<form action="process.jsp" method="post">
			<span>이름</span>
			<input type="text" placeholder="이름" id="name" name="name"><br>
			
			<span>나이</span>
			<input type="text" placeholder="나이" id="age" name="age"><br>
			
			<span>주소</span>
			<input type="text" placeholder="주소" id="address" name="address"><br>
			
			<input type="submit" value="전송">
			
			<div></div>			
		</form>
	</body>
</html>