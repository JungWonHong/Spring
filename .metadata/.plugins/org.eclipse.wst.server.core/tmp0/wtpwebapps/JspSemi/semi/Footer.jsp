<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<link href="./css/main.css" type="text/css" rel="stylesheet">
<footer class="jumbotron text-center">
<div class="container">
  <p style="color:#888">copyright(c) JOBS Corp. All right reserved.</p>
  <p>More information at <a href="./EmailForm.com">email for @jobs!</a></p>
</div>
</footer> --%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<link href="./css/main.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
   function mailwindowopen(){
         var popUrl = "./EmailForm.com"; //�˾�â�� ��µ� ������ URL
      var popOption = "width=600, height=520, resizable=no, scrollbars=no, status=no;"; //�˾�â �ɼ�(optoin)
      window.open(popUrl, "", popOption);
   }
</script>
<footer class="jumbotron text-center">
<div class="container">
  <p style="color:#888">copyright(c) JOBS Corp. All right reserved.</p>
  <p>More information at <a href="javascript:mailwindowopen();">email for @jobs!</a></p>
</div>
</footer>