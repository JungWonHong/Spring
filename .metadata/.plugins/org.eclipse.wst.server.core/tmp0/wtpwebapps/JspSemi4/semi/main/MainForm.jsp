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
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/main.css" type="text/css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
$(document).ready(function () {
    $("ul[data-liffect] li").each(function (i) {
        $(this).attr("style", "-webkit-animation-delay:" + i * 300 + "ms;"
                + "-moz-animation-delay:" + i * 300 + "ms;"
                + "-o-animation-delay:" + i * 300 + "ms;"
                + "animation-delay:" + i * 300 + "ms;");
        if (i == $("ul[data-liffect] li").size() -1) {
            $("ul[data-liffect]").addClass("play")
        }
    });
});
</script>
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

<div class="row">
    <div class="col-md-12 text-center">
			<img src="image/logo.png">
			<h1 class="mrng-60-top">Jobs</h1> 
    </div>
</div>

<div class="main_button">
 <ul data-liffect="bounceIn">
<li><button name="Recruit" value="Recruit" class="btn btn-sm animated-button recruit"
	onclick="location.href='./RecruitList.bo'">Recruit</button></li>

<%  String id = (String)session.getAttribute("id");
	String isE = (String)session.getAttribute("isE");
	if(id != null && id.length() != 0){ 
		if(id.equals("admin")) {
	%>
	<li><button name="mypage" value="관리자페이지" class="btn btn-sm animated-button mypage"
	onclick="location.href='./adminMemberList.com'">AdminPage</button></li>
	<%}else if(isE != null && isE.length() != 0){ %>
	<li><button name="mypage" value="MYPAGE" class="btn btn-sm animated-button mypage"
	onclick="location.href='./EMyPage.com'">MyPage</button></li>
	<%}else { %>
	<li><button name="mypage" value="MYPAGE" class="btn btn-sm animated-button mypage"
	onclick="location.href='./PMyPage.com'">MyPage</button></li>
	<%}} else {%>
<li><button name="login_join" value="Login&Join" class="btn btn-sm animated-button login"
	onclick="location.href='./login.com'">Login</button></li> <%} %>

<li><button name="Review" value="Review" class="btn btn-sm animated-button review"
	onclick="location.href='./rvBoardList.bo'">Review</button></li>
<li><button name="source_board" value="source_board" class="btn btn-sm animated-button source"
	onclick="location.href='./sbBoardList.bo'">Source Board</button></li>
<li><button name="event" value="event" class="btn btn-sm animated-button event"
	onclick="location.href='./eventBoard.bo'">Event</button></li>
<li><button name="chat" value="chat" class="btn btn-sm animated-button chat"
	onclick="liveChatOpen()">Chat</button></li>
</div>

<jsp:include page="swiper.jsp"></jsp:include>
<jsp:include page="../Footer.jsp"></jsp:include>

</body>
</html>