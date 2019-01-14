<%-- 첨부파일 클릭시 다운로드하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REVIEW 내용</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<style>
#qacont_wrap{margin-top:10%; margin-left:4%}
.qacont_title{background: #2ABCB4; width:1200px; height:60px; margin-left:18%}
#qacont_t{border: 2px solid #F2EFEF; width:1200px; margin-left:18%}

.qacont_subject{font-size:20pt; font-weight:bold; margin-left:10%; margin-top:10%;
               }
.subject_1{margin-left:10%; font-size:15pt; margin-top:3% }
.subjectbr{border-bottom: 2px solid #F2EFEF; width:1200px;}
.qacont_cont{	font-size:15pt; 
			border: 2px solid lightgray;
			margin-top: 10%; 
			margin-left: 13%;
   			width: 900px;
    		height: 300px;}
.qa_cont_t{margin-top:10%; margin-left:10%}
.qacont_count{margin-top:-3%;  margin-left:70%; font-weight:bold; font-size:17pt;}
.qacont_count_t{margin-top:-2.5%; margin-left:80%; font-size:17pt}
.qacont_img{margin-top:10%; font-size:17pt; font-weight:bold; margin-left:5%}
.qacont_img1{margin-left:25%; margin-top:5%; border:2px solid lightgray; width:600px; height:350px;}
.khccimg{width:600px; height:350px;}
#qacont_button{margin-top:5%; margin-left:43%}
.qacont_list,.qacont_edit,.qacont_del,.qacont_reply{    width: 100px;
	height: 40px;
	border: 0;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold}
</style>
<script>
function qaedit_window() {
	var qa_num = document.getElementById('qa_num').value;
	var page = document.getElementById('page').value;
	var url = 'qa_edit.nhn?qa_num=' + qa_num + '&page=' + page + '&state=edit';
	window.open(url, "qa_edit_ok",
			"toolbar = no, status = yes, menubar = no,"
					+ "width = 700, height = 700");
}



</script>
</head>
<body>
<input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
<form method="post">
 <div id="qacont_wrap">
 <div class="qacont_title"></div>
  <div id="qacont_t">
  

    <div class="qacont_subject">제목 <span class="subject_1">${qabean.qa_subject} </span></div>
    <div class="subjectbr"></div>
    
    <div class="qacont_count">조회수</div>
    <div class="qacont_count_t">${qabean.qa_readcount}</div>

      <div class="qacont_cont"><p class="qa_cont_t">${qa_cont}</p></div>
   

   	<div class="qacont_img">이미지</div>
   	<div class="subjectbr"></div>
   	<c:if test="${empty qabean.qa_file}">
   	    <div class="qacont_img1">
		<img src="./resources/images/khccimg.png"  class="khccimg"/>
		</div>
	</c:if>
	<c:if test="${!empty qabean.qa_file}">
	<div class="qacont_img1"><img src=".\resources\upload${qabean.qa_file}"  class="khccimg"/>  </div>
	</c:if>
 
   
   <c:if test="${!empty qabean.qa_file}">
   <tr>
    <th>파일 다운로드</th>
    <td>
   <a href="./download.file?path=${qabean.qa_file}&original=${qabean.qa_original}" 
      target="_blank">${qabean.qa_original}</a> 
    <!-- _blank target 속성은 새창에 띄워준다. -->
    </td>
   </tr>
   </c:if>
	
  </div>
  
  <div id="qacont_button">
   <c:if test="${login_email == null}">
	  <input type="button" value="목록" class="qacont_list"  onclick="location='qa_list.nhn?page=${page}'" />
   </c:if>
   <c:if test="${login_email != null}">
	<c:if test="${login_email == qabean.qa_name}">
	  <input type="hidden" name="qa_num" value="${qabean.qa_num}" id="qa_num" />
      <input type="hidden" name="page" value="${page}" id="page" />
	   <input type="button" value="수정" class="qacont_edit"
	    onclick="javascript:qaedit_window();" />
	   
	<c:if test="${login_email == 'admin@khcc.com'}">
		  <input type="hidden" name="qa_num" value="${qabean.qa_num}" id="qa_num" />
      <input type="hidden" name="page" value="${page}" id="page" />
	   <input type="button" value="삭제" class="qacont_del"
	   onclick="javascript:qadel_window();" />
	</c:if>
	
	</c:if>
	<c:if test="${login_email != qabean.qa_name}">
	   <input type="button" value="답변" class="qacont_reply" onclick="javascript:qareply_window();">
	<%--    onclick="location='qa_cont.nhn?num=${qabean.qa_num}&page=${page}&state=reply'" /> --%>
	   <input type="hidden" value="${qabean.qa_num}" id="re_num">
	   <input type="hidden" value="${page}" id="page">
	   
	</c:if>
	   <input type="button" value="목록" class="qacont_list"
	   onclick="location='qa_list.nhn?page=${page}'" />
	</c:if>
	<br><br>
  </div>
 </div>
 </form>
</body>
</html>