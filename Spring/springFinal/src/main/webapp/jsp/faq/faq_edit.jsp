<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>FAQ 수정</title>
<link rel="stylesheet" type="text/css" href="./resources/css/qa.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2.js"></script>

</head>
<body>
 <div id="qawrite_wrap">
  <h2 class="qawrite_title">FAQ 수정</h2>
  <form method="post" action="faq_edit_ok.nhn" 
  onsubmit="return check()" enctype="multipart/form-data">
  <input type="hidden" name="faq_num" value="${faqbean.faq_num}" />
  <input type="hidden" name="page" value="${page}" />
  
   <table id="qawrite_t">
    <tr>
     <th>EMAIL</th>
     <td>
     <input name="faq_name" id="faq_name" size="14"
     value="${faqbean.faq_name}" class="input_box" />
     </td>
    </tr>
    
    <tr>
     <th>PW</th>
     <td>
      <input type="password" name="faq_pass" id="faq_pass" size="14"
             class="input_box" />
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="faq_subject" id="faq_subject" size="40" 
      value="${faqbean.faq_subject}" class="input_box" />
     </td>
    </tr>
    
    <tr>
     <th>내용</th>
     <td>
      <textarea name="faq_content" id="faq_content" rows="8" cols="50"
      class="input_box">${faqbean.faq_content}</textarea>
     </td>
    </tr>
    
   <tr>
     <th>이미지등록</th>
     <td>
       <input type="file" name="uploadfile"
       style="border-radius:10px; color:black; background-color:#B1EFED; border:1px" />
     </td>
    </tr>
   </table>
   
   <div id="qawrite_menu">
    <input type="submit" value="수정" class="input_button"
    style="border-radius:10px; color:black; background-color:#B1EFED; border:1px" />
    <input type="reset" value="취소" class="input_button"
    style="border-radius:10px; color:black; background-color:#B1EFED; border:1px"
    onclick="history.back();" />
   </div>
  </form>
 </div>
</body>
</html>
<!-- onclick="$('#faq_name').focus(); -->