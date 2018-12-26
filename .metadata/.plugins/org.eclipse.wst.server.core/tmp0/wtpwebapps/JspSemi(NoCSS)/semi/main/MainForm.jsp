<!--첫 메인 페이지 -->

<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "semi.db.*" %>
<%
	request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
<title>JOBS - main</title>
<style>
	input[type=button] {
		width:40%; font-size:15px; margin:20px;
    	height: 32px; background-color:orange;
    	transition: transform 1s ease;
	}
	input[type=button]:hover {
		/* transform: translateX(60px); */
		transform: perspective(150px) translateZ(60px);
	}
	
	input[type=search] {width:300px;}
	
	.container-1{
	  width: 600px;
	  vertical-align: middle;
	  white-space: nowrap;
	  position: relative;
	}
	.container-1 .icon{
	  position: absolute;
	  top: 50%;
	  margin-top: 17px;
	  z-index: 1;
	  color: #4f5b66;
	}
</style>
<script type="text/javascript">
function liveChatOpen(){
	<%if(session.getAttribute("id") == null){%>
	alert('로그인이 필요한 서비스입니다.');
	location.href = './login.com';
	return false;
	<%}%>
	window.name = "parentForm"; 
	window.open("chatting/ChatLogin",
	          "LiveChatRoom", "width=570, height=350, resizable = no, scrollbars = yes");
};
</script>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<!-- 각각 div로 모양과 위치 주는 것? -->
<div>
<input type="button" name="JOBS_logo" value="Jobs" id="Jobs"
	onclick="location.href='http://www.cginjs.bo'">
<input type="button" name="Recruit" value="Recruit" class="Jobs_Recruit"
	onclick="location.href='./RecruitList.bo'">

<%  String id = (String)session.getAttribute("id");
	String isE = (String)session.getAttribute("isE");
	if(id != null && id.length() != 0){ 
		if(id.equals("admin")) {
	%>
	<input type="button" name="myapge" value="관리자페이지" class="Jobs_login_join"
	onclick="location.href='./adminMemberList.com'">
	<%}else if(isE != null && isE.length() != 0){ %>
	<input type="button" name="myapge" value="MYPAGE" class="Jobs_login_join"
	onclick="location.href='./EMyPage.com'">
	<%}else { %>
	<input type="button" name="myapge" value="MYPAGE" class="Jobs_login_join"
	onclick="location.href='./PMyPage.com'">
	<%}} else {%>
<input type="button" name="login_join" value="Login&Join" class="Jobs_login_join"
	onclick="location.href='./login.com'"> <%} %>
<input type="button" name="community" value="Community" id="Community"
	onclick="location.href='http://www.cginjs.com'">

<input type="button" name="Review" value="Review" class="comm_Review"
	onclick="location.href='./rvBoardList.bo'">
<input type="button" name="source_board" value="source_board" class="comm_source"
	onclick="location.href='./sbBoardList.bo'">
<input type="button" name="event" value="event" class="comm_event"
	onclick="location.href='./eventBoard.bo'">
<input type="button" name="chat" value="chat" class="comm_chat"
	onclick="liveChatOpen()">
</div>

<div class="box">
  <div class="container-1">
      <span class="icon"><i class="fa fa-search"></i></span>
      <input type="search" id="search" placeholder="Search..." />
  </div>
</div>

</body>
</html>