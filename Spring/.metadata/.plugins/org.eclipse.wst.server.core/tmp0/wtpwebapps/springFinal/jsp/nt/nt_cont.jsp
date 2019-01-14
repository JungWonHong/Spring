<%-- 첨부파일 클릭시 다운로드하기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REVIEW 내용</title>
<script src="./resources/js/qa2_2.js"></script>
<style>
#qacont_t{ margin-left:37%; margin-top:8%}
.ntth {
	border: 2px solid lightgray;
	width: 200px;
	height: 150;
	background-color: #2ABCB4;
}

.httd {
	border: 2px solid lightgray;
	width: 700px;  
	height: 150px;
}
.httd_title{
  	border: 2px solid lightgray;
	width: 894px;
	height: 80px;
	background-color: #2ABCB4;
	font-size:15pt;
	font-weight:bold;
	color:white;

   }
.httdcont{border: 2px solid lightgray; width:700px; height:600px; font-size:15pt;}
.httdfile{border:2px solid lightgray; width:700px; height:300px;}
.readtd{padding-left:50%}
.contdiv{margin-top:10%; margin-left:5%}
.edit_bt,.del_bt,.list_bt{	width: 100px;
	height: 40px;
	background: #2ABCB4;
	color: white;
	border: 0px;
	margin-top:3%;
	
	}
#qacont_menu{margin-left:66.5%; }
</style>


</head>
<body>

<div id="cont">
  <table id="qacont_t">
   <tr>
    <td class="httd_title" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ntbean.nt_subject}
    <span class="readtd">조회수:${ntbean.nt_readcount}</span>
    </td>
   </tr>
   
  <tr>
   	<c:if test="${empty ntbean.nt_file}">
   
	</c:if>
	<c:if test="${!empty ntbean.nt_file}">
	<td class="httdfile" colspan="2"><img src=".\resources\upload${ntbean.nt_file}" height="300" width="894"
		style="border-radius:20px" /></td>
	</c:if>
   </tr>
      
   
   <tr>
    <td colspan="2" class="httdcont"><div class="contdiv">${nt_cont}</div></td>
   </tr>
   
  
    

   
	
  </table>
  </div>
  
  <div id="qacont_menu">
  <c:if test="${login_email eq 'admin@khcc.com'}">
        <input type="hidden" name="nt_num" value="${ntbean.nt_num}" id="nt_num" />
       <input type="hidden" name="page" value="${page}" id="page" />
   <input type="button" value="수정" class="edit_bt"
   onclick="javascript:ntedit_window();" />
   
   
        <input type="hidden" name="num" value="${ntbean.nt_num}" id="num" />
        <input type="hidden" name="page" value="${page}" id="page" /> 
   &nbsp;
   <input type="button" value="삭제" class="del_bt">
  
 
  

  <input type="hidden" name="qnapage" value="${page}" id="qnapage" />
   &nbsp;
     <input type="button" value="목록" class="list_bt">
      </c:if>
      
        <c:if test="${login_email != 'admin@khcc.com'}">
        <input type="hidden" name="page" value="${page}" id="page" />
   &nbsp;
     <input type="button" value="목록" class="list_bt" style="margin-left:25%">
     </c:if>
  </div>
 
</body>
</html>