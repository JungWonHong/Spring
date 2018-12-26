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
		 $.getJSON()메서드 대신에 $.ajax()메서드를 이용해서 JSON 형식의 데이터를 얻을 수 있습니다.
		 jQuery.ajax(setting) = $.ajax(setting)
		 - post(), get(), getJSON() 내부에 ajax() 메서드가 존재합니다.
		   url : 요청 전송 url
		   dataType : return data의 Type(에이잭스 성공 후 돌력받은 자료의 형을 정의)
		   success : HTTP 요청이 성공한 경우 실행할 함수 정의(이벤트 핸들러)
		*/
		
		$(function(){
			$("button").click(function(){ //변경을 클릭하면
				$.ajax({
					url:'item.json', //item2.json으로 바꾸어 보세요
					dataType:'json',
					cache:false,
					success:function(data){
						//.getJSON()을 사용할 경우에는 키를 알고 있어야 값을 구할 수 있습니다.
						$("#treeData").append( //<table>태그뒤에 추가
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
					},
					error:function(data, status){
						alert("error 입니다. " + status);
					},
					complete:function(){
						alert("아작스가 완료되었습니다.");
					}
				});//ajax end
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