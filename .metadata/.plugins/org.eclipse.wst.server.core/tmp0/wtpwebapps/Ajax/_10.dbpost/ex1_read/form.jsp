<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>DB Basic</title>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
			$(document).ready(function(){
				//데이터를 보여주는 함수
				function selectData(){
					//#output 내부의 내용물을 제거합니다.
					$('#output').empty();
					
					//Ajax를 수행합니다.
					$.getJSON('products.jsp', function(data){
						$(data).each(function(index, item){
							var output = '';
							output += '<tr>';
							output += '	<td>' + item.id + '</td>'; //this.id
							output += '	<td>' + item.name + '</td>';
							output += '	<td>' + item.modelnumber + '</td>';
							output += '	<td>' + item.series + '</td>';
							output += '</tr>'
							$('#output').append(output);
						});
					});//getJSON end
				} //selectData end
				
				//초기 화면에 데이터를 표시합니다.
				selectData();
			}); //ready end
		</script>
	</head>
	<body>
		<div>
			<form id="insert_form">
				<fieldset>
					<legend>데이터 추가</legend>
						<table>
							<tr>
								<td><label>상품명</label></td>
								<td><input type="text" name="name" id="name"/></td>
							</tr>
							<tr>
								<td><label>모델번호</label></td>
								<td><input type="text" name="modelnumber" id="modelnumber"/></td>
							</tr>
							<tr>
								<td><label>시리즈</label></td>
								<td><input type="text" name="series" id="series"/></td>
							</tr>
						</table>
						<input type="submit" value="추가"/>
				</fieldset>
			</form>
		</div>
		<table border="1">
			<thead>
				<tr><th>아이디</th><th>상품명</th><th>모델 번호</th><th>시리즈</th></tr>
			</thead>
			<tbody id="output">
			</tbody>
		</table>
	</body>
</html>