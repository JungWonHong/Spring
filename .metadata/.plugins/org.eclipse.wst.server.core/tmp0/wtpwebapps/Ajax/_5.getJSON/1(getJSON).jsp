<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<style>
			td{
				border : 1px solid gray;
			}
		</style>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
		/*
		 - 서버로 부터 get방식의 요청을 하고, 응답을 JSON 형식으로 받기 위해서
		   $.getJSON()메서드를 사용합니다.
		 - $.getJSON()메서드의 첫번째 매개변수는 서버의 URL주소를 지정합니다.
		   ('item.json')
		 - 서버로 요청이 성공적으로 완료되면,
		      두번째 매개변수로 기술한 콜백함수가 호출됩니다. (function(data, textStatus))
		      콜백함수의 첫번째 매개변수인 data는 서버에서 돌려받은 JSON 객체 형식의 데이터이고,
		      두번째 매개변수인 textStatus는 성공일때 "success" 라는 문자열이 전달됩니다.
		      
		      자바스크립트의 JSON객체는 JSON데이터를 자바스크립트 객체로 변환할 수 있습니다.
		      또한 자바스크립트 객체를 문자열로 변환하기도 합니다.
		   - JSON.stringfy()메서드는 자바스크립트 객체를 JSON형식의 문자열로 변환합니다.
		   	  이를 이용해서 자바스크립트 객체를 브라우저로부터 다른 애플리케이션으로 전송할 수 있습니다.
		   - JSON.parse()메서드는 JSON데이터를 브라우저가 사용할 수 있는 자바스크립트
		   	  객체로 변환합니다.
		*/
		
		$(function(){
			$("button").click(function(){ //변경을 클릭하면
				$.getJSON('item.json', function(data, textStatus){
					//.getJSON()을 사용할 경우에는 키를 알고 있어야 값을 구할 수 있습니다.
					$("#treeData").append(
							"<tr><td>id</td><td>name</td>"
						+	"<td>price</td><td>description</td></tr>");
					$.each(data, function(){ //each 반복함수(data 끝까지 반복)
						//each() : 반복 하는 메서드로 객체 6개에 대해서 처리합니다.
						// 6개의 객체 중에서 현재 처리 중인 것을 thisㄹ로 접근합니다.
						//this.id : id는 키를 의미하고 this.id는 현재 처리중인 객체의 id키 값을 의미 합니다.
						$("#treeData").append("<tr>"
											+ "<td>" + this.id + "</td>"
											+ "<td>" + this.name + "</td>"
											+ "<td align='right'>" + this.price + "</td>"
											+ "<td>" + this.description + "</td></tr>");
					});//each end
				}); //getJSON end
			}); //click end
		});//ready end
		</script>
	</head>
	<body>
		<button>JSON 데이터를 불러옵니다.</button>
		<table>
			<tbody id="treeData"></tbody>
		</table>
	</body>
</html>