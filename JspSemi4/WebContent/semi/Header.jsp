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
      	 <a href="./adminMemberList.com">������������</a>
      <%   }else if(isE != null && isE.length() != 0){%>
         <a href="./EMyPage.com">MYPAGE</a>
      <%}else { %>
         <a href="./PMyPage.com">MYPAGE</a>
         <a href="./ManageResume.re">�̷¼����</a>
      <%   } %>
      <a href="./Logout.com">�α׾ƿ�</a>
      <%}else { %>
   <a href="./login.com">Login</a>
   <a href="./pjoin.com">Join</a>
   <%} %>
   
   <!-- admin, ���ȸ���� ���� ���� �����ֱ�  -->
   <%
      if(isE != null && isE.length() != 0){
   %>
   <a href="./Pool.bo">���� POOL</a><%} %>
   <hr>
</header>