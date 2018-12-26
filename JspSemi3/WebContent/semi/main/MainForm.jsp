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

<!-- 슬라이드 배너 -->
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="./js/jquery.banner.js"></script>
<script type="text/javascript" src="./js/script.js"></script>
<style>

.clsBannerScreen {
    overflow: hidden;
    position: relative;
    height: 150px;
    width: 600px;
    cursor: pointer;
    clear: both;
    margin:0 auto;
}
 
.clsBannerScreen .images {
    position: absolute;
    display: none;
    margin:0 auto;
}
 
ul, li {
    list-style: none;
    margin: 0 auto;
    padding: 0;
    font-size: 10pt;
    
}
 
.clsBannerButton {
    width: 600px;
    cursor: pointer;
    border-bottom: 1px solid #e1e1e1;
}
 
.clsBannerButton li {
    width: 100px;
    float: left;
    padding: 2px;
    border-right: 1px solid #e1e1e1;
}
 
.clsBannerButton li.fir {
    border-left: 1px solid #e1e1e1;
}
 
.clsBannerButton li.labelOverClass {
    font-weight: bold;
}
</style>

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

   <div id="image_list_2">
        <div class="clsBannerScreen">
            <div class="images" style="display:block"><img src="image/banner/google.jpg"></div>
            <div class="images"><img src="image/banner/daum.jpg"></div>
            <div class="images"><img src="image/banner/naver.jpg"></div>
            <div class="images"><img src="image/banner/nate.jpg"></div>
            <div class="images"><img src="image/banner/yahoo.jpg"></div>
        </div>
 
        <ul class="clsBannerButton" id="label_2">
            <li class="fir">구글<br>(google.co.kr)</li>
            <li>다음<br>(daum.net)</li>
            <li>네이버<br>(naver.com)</li>
            <li>네이트<br>(nate.com)</li>
            <li>야후<br>(kr.yahoo.com)</li>
        </ul>
    </div>
    
<jsp:include page="../Footer.jsp"></jsp:include>

</body>
</html>