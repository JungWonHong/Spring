<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- JSTL xml은 xml문서에서 자주 사용되는 기능들을 태그 라이브러리로 모아 놓은 것입니다. -->
<!-- JSTL xml라이브러리를 사용하기 위해 uri 속성과 prefix 속성을 설정합니다.-->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
	<head>
		<title>JSTL xml 라이브러리 사용 예제(jstl_xml_ex3_jquery.jsp)</title>
	</head>
	<body>
		<div></div>
	</body>
	<script src="../../js/jquery-3.2.1.js"></script>
	<script>
		data = '<students>'
		data += ' <student>'
		data += '  <name lang="한국">홍길동</name>'
		data += '  <age>18</age>'
		data += '  <gender>남</gender>'
		data += '  <phone>010-3456-11xx</phone>'
		data += ' </student>'
		data += ' <student>'
		data += '  <name lang="일본">김길동</name>'
		data += '  <age>19</age>'
		data += '  <gender>남</gender>'
		data += '  <phone>010-4567-00xx</phone>'
		data += ' </student>'
		data += ' <student>'
		data += '  <name lang="미국">홍길순</name>'
		data += '  <age>18</age>'
		data += '  <gender>여</gender>'
		data += '  <phone>없음</phone>'
		data += ' </student>'
		data += ' <student>'
		data += '  <name lang="미국">김길순</name>'
		data += '  <age>18</age>'
		data += '  <gender>여</gender>'
		data += '  <phone>없음</phone>'
		data += ' </student>'
		data += ' </students>'
		
		//$(document).ready(function(){ //body 아래에 있기 때문에 $(document).ready를 안해줘도 된다.
			var xmlData = $.parseXML(data);
			stu = $(xmlData).find('student');
			$(stu).each(function(){
				name = $(this).find('name').text();
				if (name != '홍길순') {
					output = name + " ";
					output += $(this).find('age').text() + " ";
					output += $(this).find('gender').text() + " ";
					output += $(this).find('name').attr('lang');
					
					phone = $(this).find('phone').text();
					if (phone == '없음')
						phone_message = "전화없음";
					else
						phone_message = "전화번호 : " + phone;
					
					output += "[" + phone_message + "]<br>";
					
					//innerHTML 속성에 추가하여 출력합니다.
					document.body.innerHTML += output;
				}
			});
			/* $(xmlData).find('student').each(function(){
				var output = '';
				if($(this).find('name').text() != '홍길순'){
					output += $(this).find('name').text() + '&nbsp;';
					output += $(this).find('age').text() + '&nbsp;';
					output += $(this).find('gender').text() + '&nbsp;';
					output += $(this).find('name').attr('lang') + '&nbsp;';
					if($(this).find('phone').text() != '없음')
						output += '[전화번호 : ' + $(this).find('phone').text() + ']';
					else
						output += '[전화 없음]';
					output += '<br>';
				}
				document.body.innerHTML += output;
			}); */
		//});
	</script>
</html>	