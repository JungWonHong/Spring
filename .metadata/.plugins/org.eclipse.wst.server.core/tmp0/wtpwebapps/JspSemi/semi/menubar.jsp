<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
   
<style>
form {
	padding : 0px;
}
body {
	text-align: right;
	margin: 0px;
}

img {
	transition:1s;
 	transition-timing-function:ease-in-out;
}
 img:hover {
	margin-right: 50px;
	width:50px;
	background:url("../image/programmer (1).png");
	width:50px;
} 
ul, li {
	display:inline-block;
	margin-bottom:30px;
}
button {
	font-size:18px;
	width:150px;
	height:50px; 
 	margin:15px auto; 
	border:0px;
	background-color: Transparent;
}
button:hover {
 		 background-color:#F7CA18;
}

</style>
<script type="text/javascript">
function liveChatOpen(){
	<%if(session.getAttribute("id") == null){%> //로그인 되어 있지않은경우
	alert('로그인이 필요한 서비스입니다.');
	location.href = './login.com'; //로그인창으로 이동
	return false;
	<%}%>
	window.name = "parentForm";  
	window.open("chatting/ChatLogin",//url
	          "LiveChatRoom", "width=570, height=350, resizable = no, scrollbars = yes");
};
</script>

<ul>
	<li><button name="Recruit" value="Recruit" class="btn btn-sm animated-button recruit"
	onclick="location.href='./RecruitList.bo'">Recruit</button></li>

	<li><button name="Review" value="Review" class="btn btn-sm animated-button review"
		onclick="location.href='./rvBoardList.bo'">Review</button></li>
	<li><button name="source_board" value="source_board" class="btn btn-sm animated-button source"
		onclick="location.href='./sbBoardList.bo'">Source Board</button></li>
	<li><button name="event" value="event" class="btn btn-sm animated-button event"
		onclick="location.href='./eventBoard.bo'">Event</button></li>
	<li><button name="chat" value="chat" class="btn btn-sm animated-button chat"
		onclick="liveChatOpen()">Chat</button></li>
</ul>

