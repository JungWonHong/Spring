<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>post.jsp</title>
<script src="../../../js/jquery-3.2.1.js" ></script>
<script>
/* 
   window.�Ӽ��� �̿��� ������ ����
   window.self  �Ǵ� self:  ���� ���� �ִ� ������
   window.opener �Ǵ� opener : open() �޼ҵ带 �̿��ؼ� ���ο� â�� �� ������
*/
  $(function(){
	  $("#end").click(function(){
		 /* �ڹٽ�ũ��Ʈ 
		  opener.document.myform.post1.value = $("#post1").val(); 
		  opener.document.myform.post2.value = $("#post2").val();  
		  */
		  var post1 = $("#post1").val();
		  var post2 = $("#post2").val();

		  $(window.opener.document).find("#post1").val(post1);
		  $(window.opener.document).find("#post2").val(post2);
		  /* $(opener.document).find("#post1").val(post1);
		  $(opener.document).find("#post2").val(post2); */
		   window.self.close(); //�Ǵ� self.close();
	  });
	  
  });

</script>
</head>
<body>
  �����Ͻ� �����ȣ �Դϴ�.<br>
  <input type="text" value="123" size="3"  id="post1">-<input type="text"size="3"  value="456" id="post2">
  <input type="button" value="�ݱ�" id="end">
</body>
</html>