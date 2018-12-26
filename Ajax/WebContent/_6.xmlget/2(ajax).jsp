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
			$(function(){
				$("button").click(function(){
					$.ajax({
						url:'item.xml',
						dataType:'xml',
						success:function(data){ //data에는 item.xml의 내용이 들어있다.
							$("#treeData").append(
									"<tr><td>id</td><td>name</td>"
								+	"<td>price</td><td>description</td></tr>");
							
							//서버에서 얻어온 데이터에서 셀렉터로 item태그를 찾습니다.
							$(data).find('item').each(function(){ //each 반복함수(data 끝까지 반복)
								$("#treeData").append("<tr>"
													+ "<td>" + $(this).attr('id') + "</td>"
													+ "<td>" + $(this).attr('name') + "</td>"
													+ "<td align='right'>" + $(this).find('price').text() + "</td>"
													+ "<td>" + $(this).find('description').text() + "</td></tr>");
							});//each end
						},
						error:function(){
							alert("실패");
						}
					});//ajax() end
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