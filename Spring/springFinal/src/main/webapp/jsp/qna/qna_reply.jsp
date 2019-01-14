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

.qnareply_bt{    
    width: 100px;
	height: 30px;
	background: #2ABCB4;
	border: 0px;}
	
.qnareply_back{	width: 100px;
	height: 30px; 
	background: lightgray;
	border: 0px;}	
.qnafilediv{margin-top:-5%}
#qawrite_menu{margin-top:5%; margin-left:36%}
</style>
</head>
<body>
 <div id="qawrite_wrap">
  <h2 class="qaedit_title">REVIEW 답변</h2>
  <form method="post" action="qna_reply_ok.nhn" 
  onsubmit="return check()">
  <input type="hidden" name="qna_num" value="${qnabean.qna_num}" />
  <input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
  <input type="hidden" name="qna_re_ref" value="${qnabean.qna_re_ref}" />
  <input type="hidden" name="qna_re_lev" value="${qnabean.qna_re_lev}" />
  <input type="hidden" name="qna_re_seq" value="${qnabean.qna_re_seq}" />
  <input type="hidden" name="page" value="${page}" />
  
  <table id="qawrite_t">
    <tr>
     <th>글쓴이</th>
					<td>
					<label>${login_email}</label>
					
					
					 <input type="hidden" name="qna_name" id="qna_name" value="${qnabean.qna_name}"/> 
					</td>
    </tr>
    
    <tr>
     <th>비밀번호</th>
     <td>
      <input type="password" name="qna_pass" id="qna_pass" size="14"
      class="qaedit_name" />
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="qna_subject" id="qna_subject" size="40" 
      class="qaedit_subject" value="Re:${qnabean.qna_subject}"/>
     </td>
    </tr>
    
    <tr>
  
     <td colspan="2" class="qaedit_td">
      <textarea name="qna_content" id="qna_content" rows="8" cols="50"
      class="qaedit_text"></textarea>
     </td>
    </tr>    
   </table>
   
   <div id="qawrite_menu">
    <input type="submit" value="답변" class="qnareply_bt" />
    <input type="reset" value="취소" class="qnareply_back"
    onclick="self.close();" />
   </div>
  </form>
 </div>
</body>
</html>