<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- JSTL xml은 xml문서에서 자주 사용되는 기능들을 태그 라이브러리로 모아 놓은 것입니다. -->
<!-- JSTL xml라이브러리를 사용하기 위해 uri 속성과 prefix 속성을 설정합니다. -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSTL xml 라이브러리 사용 예제(jstl_xml_ex.jsp)</title>
	</head>
	<body>
		<!-- XML 데이터를 파싱(특정문서를 읽어 들여서 이를 다른 프로그램이나 서부루틴이 사용할 수 있는
			내부의 표현 방식으로 변환시켜 주는 것)하기 위한 코드입니다.
			x:parse태그 사이에 있는 XMl 내용을 파싱하여 xmldata 변수에 저장합니다. -->
		<x:parse var="xmldata">
		<students><%-- student 엘리먼트 : XML 데이터 입니다. --%>
			<student>
				<name>홍길동</name>
				<age>18</age>
				<gender>남</gender>
				<phone>010-4567-11xx</phone>
			</student>
			<student>
				<name>김길동</name>
				<age>19</age>
				<gender>남</gender>
				<phone>010-4567-00xx</phone>
			</student>
			<student>
				<name>홍길순</name>
				<age>18</age>
				<gender>여</gender>
				<phone>없음</phone>
			</student>
			<student>
				<name>김길순</name>
				<age>18</age>
				<gender>여</gender>
				<phone>없음</phone>
			</student>
		</students>
		</x:parse>
		
		<!-- xmldata 변수에 있는 XML 문서의 모든 student엘리먼트를 차례대로 선택해서
			  반복합니다. -->
		<x:forEach select="$xmldata//student">
			<x:if select="./name!='홍길순'"> <!-- 이름이 '홍길순'이 아닐경우 -->
				<%--name엘리먼트의 값을 출력합니다.
					".의미"(students요소 student요소 :/students/student )
					"./name"(students요소 student요소 name요소:
								/students/student/name)
				 --%>
				<x:out select="./name"/>
				
				<!-- age엘리먼트의 값을 age변수에 저장합니다. -->
				<x:set select="./age" var="age"/>
				
				<!-- age변수 값을 출력합니다. -->
				<x:out select="$age"/>
				
				<!-- gender엘리먼트의 값을 출력합니다. -->
				<x:out select="./gender"/>
				
				<!-- 조건문 -->
				<x:choose>
					<x:when select="./phone!='없음'">
						[전화번호 : <x:out select="./phone"/>]
					</x:when>
					<x:otherwise>
						[전화 없음]
					</x:otherwise>
				</x:choose>
				<br>
			</x:if>
		</x:forEach>
	</body>
</html>