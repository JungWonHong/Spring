<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<link href="./css/top.css" rel="stylesheet" type="text/css">
<header>
   <a href="./KHJobs.com">Home</a>
   <% 
      String isE = (String)session.getAttribute("isE");
      String id = (String)session.getAttribute("id");
      if(id != null && id.length() != 0){ 
         if(id.equals("admin")) {
      %>
      	 <a href="./adminMemberList.com">관리자페이지</a>
      <%   }else if(isE != null && isE.length() != 0){%>
         <a href="./EMyPage.com">MYPAGE</a>
      <%}else { %>
         <a href="./PMyPage.com">MYPAGE</a>
         <a href="./ManageResume.re">이력서등록</a>
      <%   } %>
      <a href="./Logout.com">로그아웃</a>
      <%}else { %>
   <a href="./login.com">Login</a>
   <a href="./pjoin.com">Join</a>
   <%} %>
   
   <!-- admin, 기업회원만 접근 가능 조건주기  -->
   <%
      if(isE != null && isE.length() != 0){
   %>
   <a href="./Pool.bo">인재 POOL</a><%} %>
   <hr>
</header>