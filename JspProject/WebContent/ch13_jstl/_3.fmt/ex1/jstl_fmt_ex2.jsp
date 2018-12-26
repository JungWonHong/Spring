<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%--fmt: 국제화/형식화의 기능을 제공해 주는 JSTL 라이브러리 입니다.
	fmt 라이브러리를 등록하는 코드 입니다. --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="date" class="java.util.Date"/>
<%--
	Date date = new Date();
	pageContext.setAttribute("date", date);
 --%>

<!DOCTYPE html>
<html>
	<head>
		<title>JSTL fmt 라이브러리 사용 예제</title>
	</head>
	<body>
		<p>
		<%-- <fmt:formatNumber> : 숫자 형식의 패턴을 설정 할 때 사용합니다.
			 type : 숫자의 타입으로 숫자, 통화, 퍼센트 중 설정할 수 있습니다.
			 pattern : 지정한 값을 어떤 패턴으로 변화시킬지 정할 수 있습니다. --%>
			 
		<!-- 값을 통화 형식으로 변환합니다. -->
		<fmt:formatNumber value="50000" type="currency"/><br>
		
		<!-- 값을 퍼센트 형식으로 변환합니다. -->
		<fmt:formatNumber value="0.15" type="percent"/><br>
		
		<!-- 숫자를 ###,###,### 형식으로 출력합니다. -->
		<fmt:formatNumber value="500567300" pattern="###,###,###"/><br>
		
		<!-- 날짜만 출력합니다. -->
		<fmt:formatDate value="${date }" type="date"/><br>
		
		<!-- 시간만 출력합니다. -->
		<fmt:formatDate value="${date }" type="time"/><br>
		
		<!-- 날짜와 시간 출력합니다. -->
		<fmt:formatDate value="${date }" type="both"/><br>
		
		<!-- 날짜와 시간을 짧게 출력합니다. -->
		<fmt:formatDate value="${date }" type="both"
						timeStyle="short" dateStyle="short"/><br>
		
		<!-- 날짜와 시간을 길게 출력합니다. -->
		<fmt:formatDate value="${date }" type="both"
						timeStyle="long" dateStyle="long"/><br>					
	</body>
</html>