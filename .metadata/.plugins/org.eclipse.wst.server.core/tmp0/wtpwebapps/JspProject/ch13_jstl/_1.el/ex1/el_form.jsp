<%--
	* 표현언어(Expression Language : EL)
	     톰캣에서 지공하기 때문에 따로 설정할 필요 없습니다.
	  JSP 스크립트 대신하여 속성 값들을 좀 더 편리하게 출력하기 위해 제공되는 언어입니다.
	  
	    표현식 태그
	  1. <%=article.getId()%>  //article - 자바빈
	  2. <%=session.getAttribute("test")%>
	  3. <%=request.getParameter("name")%>
	  4. <%=request.getParameterValues("hobby")%>
	  5. <%=request.getAttribute("hoho")%>
	  
	    표현언어(EL)
	  1. ${article.id} 또는 ${article["id"]} 또는 ${article['id']}
	  2. ${sessionScope.test}
	  3. ${param.name}
	  4. ${paramValues.hobby} 결과는 스트링 배열(String[])
	  	차례대로 출력할 경우
	  	- ${paramValues.hobby[0] }
	  	- ${paramValues.hobby[1] }
	  	- ${paramValues.hobby[2] }
	  5. ${requestScope.hoho}
	  	  또는
	  	 ${hoho} :
	  	 이 경우에는 page -> request -> session -> application 영역 순으로
	  	'hoho'이름의 attribute를 찾습니다.
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <title>EL 내장객체 사용 예제</title>
 <style>
    table{margin : 0 auto}
    td{width:100px;height:30px;text-align:center}
    tr:nth-child(1){background:yellow}
    tr:nth-child(2){background:lime}
 </style>
</head>
<body>
  <form action="el_result.jsp" method="post">
   <table border=1>
	<tr>
	   <td>이름  </td>
	   <td><input type="text" name="name" value="홍길동"></td>
	</tr> 
	<tr>
	  <td>취미</td>
	  <td> 
	    <input type="checkbox" name="hobby" id="hobby1" value="독서">독서
		<input type="checkbox" name="hobby" id="hobby2" value="놀기">놀기 
	   </td>
	</tr>
	<tr>
	   <td colspan="2" align="center">
	     <input type="submit" value="입력"></td>
	</tr>
   </table>
  </form>
</body>
</html>