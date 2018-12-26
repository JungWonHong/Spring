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
         var popUrl = "./EmailForm.com"; //팝업창에 출력될 페이지 URL
      var popOption = "width=600, height=520, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)
      window.open(popUrl, "", popOption);
   }
</script>
<footer class="jumbotron text-center">
<div class="container">
  <p style="color:#888">copyright(c) JOBS Corp. All right reserved.</p>
  <p>More information at <a href="javascript:mailwindowopen();">email for @jobs!</a></p>
</div>
</footer>