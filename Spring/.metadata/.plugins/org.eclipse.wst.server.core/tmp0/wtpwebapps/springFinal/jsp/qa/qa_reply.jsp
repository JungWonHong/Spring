<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>REVIEW 답변</title>

<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<style>
.qaedit_title{font-size: 30pt; font-weight: bold;}
#qaedit_t{margin-top:10%}
th {
	border: 2px solid lightgray;
	width: 100px;
	height: 50px;
	background-color: #2ABCB4;
}

td {
	border: 2px solid lightgray;
	width: 510px;
	height: 50px;
}
.qaedit_pass,.qaedit_name,.qaedit_subject{width:550px;height: 50px;}
.qaedit_text,.qaedit_td{    width:660px;
	height: 300px;}

.qaedit_bt{    
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;}
	
.qaedit_back{	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;}	
.qnafilediv{margin-top:-5%}
#qawrite_menu{margin-top:5%; margin-left:36%}
</style>
</head>
<body>
 <div id="qawrite_wrap2">
  <h2 class="qaedit_title">REVIEW 답변</h2>
  <form method="post" action="qa_reply_ok.nhn" 
  onsubmit="return check()">
  <input type="hidden" name="login_email" id="login_email" value="${login_email}" />
  <input type="hidden" name="qa_num" value="${qabean.qa_num}" />
  <input type="hidden" name="qa_re_ref" value="${qabean.qa_re_ref}" />
  <input type="hidden" name="qa_re_lev" value="${qabean.qa_re_lev}" />
  <input type="hidden" name="qa_re_seq" value="${qabean.qa_re_seq}" />
  <input type="hidden" name="page" value="${page}" />
  
  <table id="qawrite_t">
    <tr>
     <th>ID</th>
     <td>
     <label>${login_email}</label>
     <!-- <input name="qa_name" id="qa_name" size="14" class="input_box" /> -->
     </td>
    </tr>
    
    <tr>
     <th>PW</th>
     <td>
      <input type="password" name="qa_pass" id="qa_pass"
      class="qaedit_name" />
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="qa_subject" id="qa_subject" 
      class="qaedit_subject" value="Re:${qabean.qa_subject}"/>
     </td>
    </tr>
    
    <tr>
     <td colspan="2" class="qaedit_td">
      <textarea name="qa_content" id="qa_content" rows="8" cols="50"
      class="qaedit_text"></textarea>
     </td>
    </tr>    
   </table>
   
   <div id="qawrite_menu">
     <input type="hidden" value="${page}" id="page">
    <input type="submit" value="답변" class="qaedit_bt" />
    <input type="reset" value="취소" class="qaedit_back"
    onclick="history.back();" />
   </div>
  </form>
 </div>
</body>
</html>