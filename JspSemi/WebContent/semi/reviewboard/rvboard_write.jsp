<%-- 글쓰기 폼 페이지 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<% String id=(String)session.getAttribute("id"); %>
<html>
<head>
	<title>Review 게시판</title>
	<link href="./css/board.css" rel="stylesheet" type="text/css"/>
	<link href="./css/top.css" rel="stylesheet" type="text/css"/>
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./js/rvbwrite.js"></script>
	<script>
		
	</script>		
	<script>
	$(document).ready(function() {
		$( ".star_rating a" ).click(function() {
		     $(this).parent().children("a").removeClass("on");
		     $(this).addClass("on").prevAll("a").addClass("on");
		     var rv_score = $('.on').length;
		     $("#score").val(rv_score);
		     return false;
		});
	});
	</script>
	<style>
	.star_rating {font-size:0; letter-spacing:-4px;}
	.star_rating a {
	    font-size:22px;
	    letter-spacing:0;
	    display:inline-block;
	    margin-left:5px;
	    text-decoration:none;}
	.star_rating a:visited {
		text-decoration: none;
    	color: #e8e3e3;
	}
	.star_rating a:first-child {margin-left:0;}
	.star_rating a.on {color:#FFE400;}
	</style>
</head>
<body>
<jsp:include page="../Header.jsp"></jsp:include>
<jsp:include page="../menubar.jsp"></jsp:include>
<form action="rvBoardAddAction.bo" method="post" name="boardform">
	
<table>
	<tr>
			<th colspan="2">Review - 글쓰기 페이지</th>
	</tr>
	<tr>
		<td>
			<div>글쓴이</div>
		</td>
		<td>
			<%=id %>
			<input type="hidden" name="id" value="<%=id %>">
		</td>
	</tr>
	<tr>
		<td>
			<div>제 목</div>
		</td>
		<td>
			<input name="rv_title"   type="text" id="rv_title" 
			       size="80"   maxlength="100"    value="">
		</td>

	<tr>
	<td>
			<div>기업 평점</div>
		</td>
		<td>
			<p class="star_rating">
			    <a class="on" href="#">★</a>
			    <a class="on" href="#">★</a>
			    <a class="on" href="#">★</a>
			    <a href="#">★</a>
			    <a href="#">★</a>
			</p>
			<input id="score" type="hidden" name="rv_score" value="">
		</td>
	</tr>
	
	<tr>
		<td>
			<div>내 용</div>
		</td>
		<td>
			<textarea id="rv_content" name="rv_content" cols="83" rows="15"></textarea>
		</td>
	</tr>
	<tr class="center">
		<td colspan="2" class="h30 lime">
		    <!-- 등록을 클릭할 경우  addboard()를 호출합니다.-->
			<a id="rvwrite" href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
			
			<!-- 뒤로를 클릭할 경우 이전 페이지로 이동합니다. -->
			<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
   </table>
 </form>
 <jsp:include page="../Footer.jsp"></jsp:include>
</body>
</html>