<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page autoFlush="true" %>
<!-- auFlush 설정을 생략하는 경우 기본값으로 true로 적용됩니다. -->
<html>
	<head>
		<title>out Test(outTest3.jsp)</title>
	</head>
	<body>
		<h2>Out 테스트</h2>
		<table border="1">
			<tr>
				<td>autoFlush 여부</td>
				<td><%=out.isAutoFlush() %></td>
				<%--page 지시어의 autoFlush 속성으로 지정된 값을 리턴합니다.
					출력 버퍼가 다 채워졌을 때 버퍼 내용을 클라이언트로 전송하도록 지정되어 있으면
					true를 리턴하고
					출력 버퍼가 다 채워졌을 때 예외가 발생하도록 지정되어 있으면 false를 리턴합니다.
				 --%>
			</tr>
			<tr>
				<td>출력 버퍼의 크기</td>
				<td><%=out.getBufferSize() %>바이트</td>
			</tr>
			<tr>
				<td>출력 버퍼의 남은 양</td>
				<td><%=out.getRemaining() %>바이트</td>
			</tr>
		</table>
	</body>
</html>