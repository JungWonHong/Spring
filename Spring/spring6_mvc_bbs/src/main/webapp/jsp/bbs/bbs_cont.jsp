<%-- 첨부파일 클릭시 다운로드하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자료실 내용보기</title>
<link rel="stylesheet" type="text/css" href="./resources/css/bbs.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
</head>
<body>
 <div id="bbscont_wrap">
  <h2 class="bbscont_title">자료실 내용보기</h2>
  <table id="bbscont_t">
   <tr>
    <th>제목</th>
    <td>${bbsbean.bbs_subject}</td>
   </tr>
   
   <tr>
    <th>내용</th>
    <td>${bbs_cont}</td>
   </tr>
   
   <c:if test="${!empty bbsbean.bbs_file}">
   <tr>
    <th>첨부파일명</th>
    <td>
   <a href="./download.file?path=${bbsbean.bbs_file}&original=${bbsbean.bbs_original}" 
      target="_blank">${bbsbean.bbs_original}</a> 
    <!-- _blank target 속성은 새창에 띄워준다. -->
    
    </td>
   </tr>
   </c:if>
   
   <tr>
    <th>조회수</th>
    <td>${bbsbean.bbs_readcount}</td>
   </tr>
  </table>
  
  <div id="bbscont_menu">
   <input type="button" value="수정" class="input_button"
   onclick="location='bbs_cont.nhn?num=${bbsbean.bbs_num}&page=${page}&state=edit'" />
   <input type="button" value="삭제" class="input_button"
   onclick="location='bbs_cont.nhn?num=${bbsbean.bbs_num}&page=${page}&state=del'" />
   <input type="button" value="답변" class="input_button"
   onclick="location='bbs_cont.nhn?num=${bbsbean.bbs_num}&page=${page}&state=reply'" />
   <input type="button" value="목록" class="input_button"
   onclick="location='bbs_list.nhn?page=${page}'" />
  </div>
 </div>
</body>
</html>