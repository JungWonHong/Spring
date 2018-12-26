<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSTL core 라이브러리 사용 예제 2</title>
	</head>
	<body>
		<!-- 자바의 for문과 유사합니다.
			 items 속성에 컬렉션이나 배열 형태의 객체를 지정하여 객체의 인덱스만큼 반복할 수 있습니다.
			 begin : 시작 인덱스
			 end : 끝 인덱스
			 step : 증감식
			 var : 반복 중일 경우 현재 반복하고 있는 값을 기억하는 변수입니다.
		 -->
		<c:forEach var="test" begin="1" end="10" step="2">
			<b>${test }</b>&nbsp;
		</c:forEach>
		<hr>
		
		<%
		pageContext.setAttribute("nameList", new String[]{"홍길동", "임꺽정", "일지매", "신사임당"});
		
		String[] nameList = (String[])pageContext.getAttribute("nameList"); 
		
		for(String name : nameList){ 
			out.println("<li style='color:blue'>" + name + "</li>");
		}
		
		for(int i=0;i<nameList.length;i++){ 
			out.println("<li style='color:blue'>" + nameList[i] + "</li>");
		}
		%>
		<hr>
		
		<%-- 배열의 모든 내용을 출력합니다.
			 items에는 ${pageScope.nameList} 또는 ${nameList} 사용 가능 --%>
		<c:forEach var="name" items="${pageScope.nameList }">
			<li>${name }</li>
		</c:forEach>
		<hr>
		
		<%-- 배열의 인덱스 2부터 3까지의 내용을 출력합니다.
			 참조할 변수의 개수를 제한합니다. --%>
		<c:forEach var="name" items="${nameList }" begin="2" end="3">
			<li>${name }</li>
		</c:forEach>
		<hr>
		
		<%-- varStatus 속성은 반복 정보를 담고 있는 객체(LoopTagStatus)를 저장할 변수명을
			  값으로 갖습니다.
			 varStatus="status"인 경우
			 status.index : 반복 실행에서 현재의 인덱스값을 의미합니다.
			 status.count : 반복 실행의 횟수를 의미합니다. --%>
		<c:forEach var="name" items="${nameList }" begin="2" end="3" varStatus="status">
			<li>${status.count }번째 반복 - index[${status.index }] : ${name }</li>
		</c:forEach>
		
		<%
			java.util.HashMap<String, Object> m =
					new java.util.HashMap<String, Object>();
			m.put("name", "홍길동");
			m.put("today", new java.util.Date());
		%>
		<c:set var="map" value="<%=m %>"/>
		<c:forEach var="data" items="${map }">
			<li>${data.key } - ${data.value }</li>
		</c:forEach>
		<hr>
		
		<!-- 자바의 for문과 StringTokenizer 객체를 결합하였다고 볼 수 있습니다.
			 items에 지정한 값을 delims 속성의 구분자로 나눈 후 나눠진 만큼 반복을 수행합니다. -->
		<c:forTokens var="alphabet" items="a,b,c,d,e,f,g,h,i,j,k,l,m,n" delims=",">
			<b>${alphabet }</b>&nbsp;
		</c:forTokens>
		<hr>
		
		<!-- 변수 data에 값을 설정합니다. -->
		<c:set var="data" value="홍길동,김길동,고길동"/>
		
		<!-- items에 변수 data값을 지정하여 콤마(,)로 구분한 후 한 개씩 출력합니다. -->
		<c:forTokens var="varData" items="${data }" delims=",">
			<b>${varData }</b>&nbsp;
		</c:forTokens>			 
	</body>
</html>