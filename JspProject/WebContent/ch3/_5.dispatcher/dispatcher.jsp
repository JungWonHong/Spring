<%@ page language="java" 
       contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
   <title>dispatcher.jsp</title>
</head>
<body>
   여기는 dispatcher.jsp 입니다. <br>
<!-- request 영역에 속성 "food"라는 이름으로 저장되어 있는 값을 가져와서
   출력하라는 의미입니다. -->
<%-- jsp에서 <%= ~ %>의 의미는 출력의 의미입니다. --%>
   request 속성 값 : <%=request.getAttribute("food") %>   
</body>
</html>
<%-- 실행 후 주소란을 꼭 확인해 보세요.
브라우저의 주소 표시줄의 URL 변경이 없으며 서블리과 jsp가 같은 request 영역을
공유하기 때문에 포워딩 된 jsp 페이지에서 request 영역에 공유되어 있는 값에
접근이 가능합니다. --%>