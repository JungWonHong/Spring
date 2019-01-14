<%-- 첨부파일 클릭시 다운로드하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 내용</title>
<script src="./resources/js/qa2_4.js"></script>
<style>
#qnacont_wrap{ 
  				border: 2px solid #F2EFEF;
  				 margin-top:10%;
  				  margin-left:26%; 
  				  width:1100px;}
.qnacont_title{	background: #2ABCB4; font-size:20pt; font-weight:bold; color:white; width:1100px; height:60px;}
#qacont_t{margin-top:10%}
  				  
.qnatitle{margin-left:31%}


.titleth{font-size:20pt; font-weight:bold; margin-left:5%;}
.titletd{font-size:15pt; margin-left:15%; margin-top:-3%}
.viewth{font-size:20pt;  font-weight:bold; margin-left:70%; margin-top:-2.5%}
.viewtd{font-size:15pt;     margin-left: 80%; margin-top: -3%; width:1100px;}
.qnacont{margin-top:5%; margin-left:5%}
.contenttd{
			font-size:15pt; 
			border: 2px solid #F2EFEF; 
			margin-top: 10%; 
			margin-left: 5%;
   			width: 550px;
    		height: 500px;}
    		
.divhr{border-bottom: 2px solid #F2EFEF; width:1100px; margin-top:5%}
.fileimg{    height: 500px;
    width: 400px;
    margin-left: 57%;
    margin-top: -48%;
}
.filedown{font-size:20pt; font-weight:bold; margin-left: 57%;}
.filedownload{font-size:15pt; margin-left: 76%; margin-top: -3%;}

.qna_list,.qna_edit,.qna_del,.qna_reply{	
    width: 100px;
	height: 40px;
	border: 0;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold}
#qacont_menu{margin-left: 33.5%; margin-top: 10%;}
</style>
</head>
<body>
 <div id="qnacont_wrap">
  <div class="qnacont_title"><span class="qnatitle">${qnabean.qna_name}님이 문의하신 내용입니다.</span></div>
  <div id="qacont_t">
    

    <div class="titleth">TITLE</div>
    <div class="titletd">${qnabean.qna_subject}</div>
    
 
    <div class="viewth">VIEW</div>
    <div class="viewtd">${qnabean.qna_readcount}</div>
 
   <div class="divhr"></div>
 
    <div class="contenttd"><p class="qnacont">${qna_cont}</p></div>

   <div>
 
   	<c:if test="${empty qnabean.qna_file}">
   	
		<img src="./resources/images/khccimg.png" class="fileimg" />
	
	</c:if>
	<c:if test="${!empty qnabean.qna_file}">
	<div><img src=".\resources\upload${qnabean.qna_file}"  class="fileimg"
	 /></div>
	</c:if>
   </div>
   
   <c:if test="${!empty qnabean.qna_file}">
  
     
    <div class="filedown">파일 다운로드</div>
    <div class="filedownload">
   <a href="./download.file?path=${qnabean.qna_file}&original=${qnabean.qna_original}" 
      target="_blank">${qnabean.qna_original}</a> 
    <!-- _blank target 속성은 새창에 띄워준다. -->
    </div>

   </c:if>

  </div>
  
  <div id="qacont_menu">
  
  
  <c:if test="${login_email == null}">
  <input type="hidden" name="page" value="${page}" id="page" />
	   <input type="button" value="목록" class="qna_list" />
   </c:if>
   
   
    <c:if test="${login_email != null}">
    
	<c:if test="${login_email == qnabean.qna_name}">
    <input type="hidden" name="qna_num" value="${qnabean.qna_num}" id="qna_num" />
    <input type="hidden" name="page" value="${page}" id="page"/>
	   <input type="button" value="수정" class="qna_edit"
	   onclick="javascript:qnaedit_window();" />
	   
	       <input type="hidden" name="qna_num" value="${qnabean.qna_num}" id="qna_num" />
    <input type="hidden" name="page" value="${page}" id="page"/>
	   <input type="button" value="삭제" class="qna_del"
		 onclick="javascript:qnadel_window();" />
	</c:if>
	
	<c:if test="${login_email != qnabean.qna_name}">
	   <input type="button" value="답변" class="qna_reply" onclick="javascript:qnareply_window();"/>
	 <%--  	   onclick="location='qna_cont.nhn?num=${qnabean.qna_num}&page=${page}&state=reply'" /> --%>
	 	   <input type="hidden" value="${qnabean.qna_num}" id="re_num">
	   <input type="hidden" value="${page}" id="page">
	</c:if>
	
	
	 <input type="hidden" name="qnapage" value="${page}" id="qnapage" />
	   <input type="button" value="목록" class="qna_list" />
	   
	   
	</c:if>  
  </div>
 </div>
</body>
</html>