<%-- 첨부파일 클릭시 다운로드하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REVIEW 내용</title>
<link rel="stylesheet" type="text/css" href="./resources/css/qa.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
</head>
<body>
 <div id="qacont_wrap">
  <h2 class="qacont_title">FAQ 내용</h2>
  <table id="qacont_t">
   <tr>
    <th>제목</th>
    <td>${faqbean.faq_subject}</td>
   </tr>
   
   <tr>
    <th>내용</th>
    <td>${faq_cont}</td>
   </tr>
   
   <tr>
    <th>VIEW</th>
    <td>${faqbean.faq_readcount}</td>
   </tr>
   
   <tr>
   	<th>첨부파일</th>
   	<c:if test="${empty faqbean.faq_file}">
   		<td>
		<img src="./resources/images/khcc.png" height="50" width="200" />
		</td>
	</c:if>
	<c:if test="${!empty faqbean.faq_file}">
	<td><img src=".\resources\upload${faqbean.faq_file}" height="500" width="600"
		style="border-radius:20px" /></td>
	</c:if>
   </tr>
   
   <c:if test="${!empty faqbean.faq_file}">
   <tr>
    <th>파일 다운로드</th>
    <td>
   <a href="./download.file?path=${faqbean.faq_file}&original=${faqbean.faq_original}" 
      target="_blank">${faqbean.faq_original}</a> 
    <!-- _blank target 속성은 새창에 띄워준다. -->
    </td>
   </tr>
   </c:if>
	
  </table>
  
  <div id="qacont_menu">
  <c:if test="${login_email eq 'admin@khcc.com'}">
   <input type="button" value="수정" class="input_button"
   style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"
   onclick="location='faq_cont.nhn?num=${faqbean.faq_num}&page=${page}&state=edit'" />
   <input type="button" value="삭제" class="input_button"
   style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"
   onclick="location='faq_cont.nhn?num=${faqbean.faq_num}&page=${page}&state=del'" />
   <%-- <input type="button" value="답변" class="input_button"
   style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"
   onclick="location='faq_cont.nhn?num=${faqbean.faq_num}&page=${page}&state=reply'" /> --%>
   </c:if>
   <input type="button" value="목록" class="input_button"
   style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"
   onclick="location='faq_list.nhn?page=${page}'" />
  </div>
 </div>
</body>
</html>