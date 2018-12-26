<%--tag 디렉티브 : JSP페이지의 page 디렉티브와 동일합니다. 
				page 디렉티브가 JSP 페이지에 대한 설정 정보 등을 명시하는 것처럼
				tag 디렉티브는 태그 파일의 정보를 명시합니다.
				
	body-content 속성 : 몸체 내용의 종류를 입력합니다.
	empty, tagdependent, scriptless(기본값)의 세 값 중 한가지를
	사용할 수 있습니다.
	
	body-content="empty" : 태그 파일이 나타내는 커스텀 태그의 몸체 내용이
	없다고 표시 합니다.
	예) <tf:_1now/> 사용해야 합니다.
	만약 <tf:_1now> 하하  <tf:_1now/> 사용하면 에러 발생합니다.
	
	pageEncoding="EUC-KR" : 태그 파일의 소스 코드 인코딩을 알맞게 지정합니다.
--%>
<%@ tag body-content="empty" pageEncoding="EUC-KR"%>
<%@ tag import="java.util.Calendar" %>
<%	Calendar cal = Calendar.getInstance(); %>
<%--태그 파일에서 출력한 내용이 그대로 클라이언트에 출력됩니다. --%>
<%= cal.get(Calendar.YEAR) %>년
<%= cal.get(Calendar.MONTH) + 1%>월
<%= cal.get(Calendar.DATE) %>일
