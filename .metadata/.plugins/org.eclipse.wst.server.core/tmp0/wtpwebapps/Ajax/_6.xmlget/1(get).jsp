<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>XML 파일을 GET 방식으로 로드하기</title>
		<style>
			td{
				border : 1px solid gray;
			}
		</style>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
			/*
			 - $.get() 메서드를 이용해서 item.xml 파일을 불러옵니다.
			 - $.get() 메서드의 첫번째 매개변수에는 서버의 URL 주소를 지정합니다.
			 - $.get() 메서드의 두번째 매개변수인 콜백함수를 이용해서 서버에서 보내온
			   XML 형식의 데이터를 data 로 받습니다.
			*/
			$(function(){
				$("button").click(function(){
					$.get('item.xml', function(data){
						$("#treeData").append(
								"<tr><td>id</td><td>name</td>"
							+	"<td>price</td><td>description</td></tr>");
						$(data).find('item').each(function(){ //each 반복함수(data 끝까지 반복)
							$("#treeData").append("<tr>"
												+ "<td>" + $(this).attr('id') + "</td>"
												+ "<td>" + $(this).attr('name') + "</td>"
												+ "<td align='right'>" + $(this).find('price').text() + "</td>"
												+ "<td>" + $(this).find('description').text() + "</td></tr>");
						/*
						$(this).attr("id") : 속성 id의 값을 구해옵니다.
						$(this).find("price") : price 태그를 찾습니다.
						$(this).find("price").text() : price 태그 사이의 값을 구해옵니다.
						$(this).find("description") : description 태그를 찾습니다.
						$(this).find("description").text() : description 태그 사이의 값을 구해옵니다.
						*/
						});//each end
					})//get end
				});//click end
			}); //jQuery() end
		</script>
	</head>
	<body>
		<button>XML형식으로 데이터 가져옵니다.</button>
		<!--  -->
		<table>
			<tbody id="treeData"></tbody>
		</table>
	</body>
</html>