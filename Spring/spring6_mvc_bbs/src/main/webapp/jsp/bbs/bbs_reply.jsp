<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>자료실 답변</title>
<link rel="stylesheet" type="text/css" href="./resources/css/bbs.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/bbs.js"></script>
</head>
<body>
 <div id="bbswrite_wrap">
  <h2 class="bbswrite_title">자료실 답변</h2>
  <form method="post" action="bbs_reply_ok.nhn" 
  onsubmit="return check()">
  <input type="hidden" name="bbs_num" value="${bbsbean.bbs_num}" />
  <input type="hidden" name="bbs_re_ref" value="${bbsbean.bbs_re_ref}" />
  <input type="hidden" name="bbs_re_lev" value="${bbsbean.bbs_re_lev}" />
  <input type="hidden" name="bbs_re_seq" value="${bbsbean.bbs_re_seq}" />
  <input type="hidden" name="page" value="${page}" />
  
  <table id="bbswrite_t">
    <tr>
     <th>글쓴이</th>
     <td>
     <input name="bbs_name" id="bbs_name" size="14" class="input_box" />
     </td>
    </tr>
    
    <tr>
     <th>비밀번호</th>
     <td>
      <input type="password" name="bbs_pass" id="bbs_pass" size="14"
      class="input_box" />
     </td>
    </tr>
    
    <tr>
     <th>글제목</th>
     <td>
      <input name="bbs_subject" id="bbs_subject" size="40" 
      class="input_box" value="Re:${bbsbean.bbs_subject}"/>
     </td>
    </tr>
    
    <tr>
     <th>글내용</th>
     <td>
      <textarea name="bbs_content" id="bbs_content" rows="8" cols="50"
      class="input_box"></textarea>
     </td>
    </tr>    
   </table>
   
   <div id="bbswrite_menu">
    <input type="submit" value="답변" class="input_button" />
    <input type="reset" value="취소" class="input_button"
    onclick="$('#bbs_name').focus();" />
   </div>
  </form>
 </div>
</body>
</html>