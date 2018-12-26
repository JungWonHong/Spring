<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>post.jsp</title>
<script src="../../../js/jquery-3.2.1.js" ></script>
<script>
/* 
   window.속성을 이용한 윈도우 접근
   window.self  또는 self:  현재 열려 있는 윈도우
   window.opener 또는 opener : open() 메소드를 이용해서 새로운 창을 연 윈도우
*/
  $(function(){
	  $("#end").click(function(){
		 /* 자바스크립트 
		  opener.document.myform.post1.value = $("#post1").val(); 
		  opener.document.myform.post2.value = $("#post2").val();  
		  */
		  var post1 = $("#post1").val();
		  var post2 = $("#post2").val();

		  $(window.opener.document).find("#post1").val(post1);
		  $(window.opener.document).find("#post2").val(post2);
		  /* $(opener.document).find("#post1").val(post1);
		  $(opener.document).find("#post2").val(post2); */
		   window.self.close(); //또는 self.close();
	  });
	  
  });

</script>
</head>
<body>
  선택하신 우편번호 입니다.<br>
  <input type="text" value="123" size="3"  id="post1">-<input type="text"size="3"  value="456" id="post2">
  <input type="button" value="닫기" id="end">
</body>
</html>