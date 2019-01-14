<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
<title>REVIEW LIST</title>

<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<script type="text/javascript">
	function view_image(element, image_path) {
	    if (image_path) {
	       var imagePosition = $(element).position();
	       $('#preview_image')
	          .prop('src', './resources/upload/' + image_path)
	          .css('top' , parseInt(imagePosition.top) - 300)
	          .css('left', parseInt(imagePosition.left)+ 500)
	          .css('border-radius','30px')
	          .css('box-shadow','3px 3px 3px 3px #ABDAE8')
	          .css('width','550px')
	          .css('height','450px')
	          .css('border','#B1EFED')
	          .show();
	    } 
	 }
	
	function close_image() {
		$('#preview_image').hide();
	}

	$(document).ready(function() {
	$("#qashow").on('click','.scanview',function() {
 
		senddata = 'num='  + $(this).next().val() + "&state=cont";

  	$.ajax({
			url:'./qa_cont_ajax.nhn',
		data: senddata,
		dataType: 'html',
		success: function(redata){
		console.log(redata);
		$('#qashow').empty();			    	
		$('#qashow').append(redata);

			}

		})

	});  //qnacontview
	
	
	$(".maximg").on('click',function() {
		 
		senddata = 'num='  + $('#num').val() + "&state=cont";

  	$.ajax({
			url:'./qa_cont_ajax.nhn',
		data: senddata,
		dataType: 'html',
		success: function(redata){
		console.log(redata);
		$('#qashow').empty();			    	
		$('#qashow').append(redata);

			}

		})

	});  //qnacontview
	
	$(".qalist_wrap21").on('click',function() {
		senddata = 'num='  + $('#num2').val() + "&state=cont";
  	$.ajax({
			url:'./qa_cont_ajax.nhn',
		data: senddata,
		dataType: 'html', 
		success: function(redata){
		console.log(redata);
		$('#qashow').empty();			    	
		$('#qashow').append(redata);

			}

		})

	});  //qnacontview
	
	$(".maximg3").on('click',function() {
		 
		senddata = 'num='  + $('#num3').val() + "&state=cont";

  	$.ajax({
			url:'./qa_cont_ajax.nhn',
		data: senddata,
		dataType: 'html',
		success: function(redata){
		console.log(redata);
		$('#qashow').empty();			    	
		$('#qashow').append(redata);

			}

		})

	});  //qnacontview
	
	$("#qashow").on('click','.qa_delbt',function() {
		
		senddata = 'page='  + $("#page").val() + '&qa_num=' + $("#qa_num").val();
		
		$.ajax({
		url:'./qa_delete_ok.nhn',
		data: senddata ,
		dataType : 'html',
	     success: function(redata){
	    	 output = $(redata).find("#qashow").html()	    	
	    	 
	    	 $('#qashow').empty();
	    	 
	         $('#qashow').append(output);
	  
	    	
	     },
	     error:function(){
	    	 alert("error");
	    	 
	     }
		
	});

	});//삭제 완료
	
	$(".searchqnabt").click(function() {
		senddata = 'find_name=' + $("#find_name").val() + '&find_field=' + $("#find_field").val();
		$.ajax({
			url:'./qa_find_ok.nhn',
		data: senddata ,
	     success: function(redata){
	         console.log(redata);
	         $('#qashow').empty();
	    	 $('#qashow').append(redata);
	    	
	     },
	     error:function(){
	    	 alert("error");
	    	 
	     }
		
	});
	


});//$(".input_qnabutton").click end

	
	});
</script>
<style>
html, body { width:100%; height:100%; margin: 0;}
#qalist_wrap{mrgin-left:20%; margin-top:10%}
.qatitle{
	font-size: 35pt;
	font-weight: bold;
	margin-left: 15%;
	color: #2ABCB4}
.qatitle1{
	font-size: 15pt;
	font-weight: bold;
	margin-left: 15%;

}
#qalist_wrap2{margin-left:15%; margin-top:10%; border: 2px solid #F2EFEF; 
  				background: #F2EFEF;width:450px; height:400px;}
.qalist_wrap21{margin-left:40%; margin-top:-21%; border: 2px solid #F2EFEF; 
				background: #F2EFEF; width:450px; height:400px;}
.qasubject,.qasubject2{margin-left:38%; font-size:15pt; font-weight:bold;}
#qalist_wrap23{margin-left:65%; margin-top:-21%; border: 2px solid #F2EFEF; 
  				background: #F2EFEF; width:450px; height:400px;}

#qalist{width:1400px; margin-left:15%; margin-top:10%}
.qatd{	
    width: 400px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center;
	}
.qadiv{border: 2px solid #F2EFEF; width:1400px; height:200px; margin-left:15%; background:#F2EFEF;}
.re_bt{    width: 600px;
    height: 40px;
    background: #2ABCB4;
    margin-top: 35%;
    color: white;
    font-size: 15pt;
    font-weight: bold;
    margin-left: 4%;}
.qnafind{      width: 80px;
    margin-left: 120%;
    height: 40px;
    margin-top: 30%;

}
.find_name{    margin-top:8%;
    margin-left: 37%;
    width: 300px;
    height: 40px;}
.findtable{margin-top:-1%}
.searchqnabt{    border: 0;
    background: #2ABCB4;
    width: 100px;
    height: 40px;
    color: white;
    margin-left: 155%;}
.review_search{    margin-left: 60%;
    margin-top: -4%;}
.subqnasearch{margin-top:-13%}
.writebt{margin-top:-40%}
.qatd1,.qatd5{width:100px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center;
}
.qatd2{
width:600px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center;
}
.qatd4{width:300px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center;}
.qaten{width:300px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	text-align:center;}
</style>
</head>
<body>
<c:if test="${login_email == null}">
<%@ include file = "../include/menubar_nologin.jsp" %>
</c:if>
<c:if test="${login_email != null}">
<%@ include file = "../include/menubar_login.jsp" %>
</c:if>
	<div id="qalist_wrap">

	   <div class="qatitle">ReView</div>
	   <br>
	   <div class="qatitle1">이용후기를 통해 KHCC를 알아보세요.</div>
		
		<c:if test="${listcount >= 1}">
		
		<div id="qalist_wrap2"  class="maximg" >
			<%-- onclick="location='qa_cont.nhn?num=${qamax1.qa_num}&page=${page}&state=cont'" --%>
			<input type="hidden" value="${qamax1.qa_num}" id="num">
			<c:if test="${empty qaimage1.qa_file}">
			
				<img src="./resources/images/khccimg.png" height="350px" width="445px" />
			</c:if>
			
			<c:if test="${!empty qaimage1.qa_file}">
				<img src=".\resources\upload${qaimage1.qa_file}" height="350px" width="445px" />
			</c:if>
			
			<br> <span class="qasubject" id="qasubject"> ${qamax1.qa_subject}</span>
			<input type="hidden" value="${qamax1.qa_num}" id="num">
		</div>

		<c:if test="${listcount == 1}">
		<div  class="qalist_wrap21" onclick="write_window()">
			<img src="./resources/images/khccimg.png" height="80" width="239" />
			REVIEW를 등록 해주세요.
		</div>
		</c:if>
		
		<!-- 박스 2 -->
		<c:if test="${listcount == 2 || listcount == 3 || listcount >= 4}">
		<div class="qalist_wrap21" >
			<%-- onclick="location='qa_cont.nhn?num=${qamax2.qa_num}&page=${page}&state=cont'" --%>
			<input type="hidden" value="${qamax2.qa_num}" id="num2">
			<c:if test="${empty qaimage2.qa_file}">
				<img src="./resources/images/khccimg.png" height="350px" width="445px" />
			</c:if>
			<c:if test="${!empty qaimage2.qa_file}">
				<img src=".\resources\upload${qaimage2.qa_file}" height="350px" width="445px"/>
			</c:if>
			<br> <span class="qasubject2" id="qasubject">${qamax2.qa_subject} </span>

		</div>
		</c:if>
		
		
		<!--박스3 -->
		<c:if test="${listcount == 1 || listcount == 2}">
		<div id="qalist_wrap22" 	onclick="write_window()">
			<img src="./resources/images/khcc.png"  height="350px" width="445px" />
			REVIEW를 등록 해주세요.
		</div>
		</c:if>
		
		
		<c:if test="${listcount == 3 || listcount >= 3}">
		<div id="qalist_wrap23" class="maximg3">
				<input type="hidden" value="${qamax3.qa_num}" id="num3">
			<c:if test="${empty qaimage3.qa_file}">
				<img src="./resources/images/khccimg.png"  height="350px" width="445px" />
			</c:if>
			<c:if test="${!empty qaimage3.qa_file}">
				<img src=".\resources\upload${qaimage3.qa_file}"  height="350px" width="445px" />
			</c:if>
			<br>
			<%-- <a href="qa_cont.nhn?num=${qamax3.qa_num}&page=${page}&state=cont"> --%>
			<span class="qasubject" id="qasubject">${qamax3.qa_subject}</span>
			<input type="hidden" value="${qamax1.qa_num}" id="num">
			<!-- </a> -->
		</div>
		</c:if>
		<br> <br> <br> <br> <br> <br>
		</c:if>
		
		<div class="qadiv">


			<br>
			<table class="findtable">
				<tr>
					<th><select name="find_field" class="qnafind" id="find_field">
							<option value="qa_name">EMAIL</option>
							<option value="qa_subject">제목</option>
							<option value="qa_content">내용</option>
					</select></th>
					<td> <input name="find_name" id="find_name" class="find_name">
					<div class="subqnasearch">
					 <input type="submit" value="SEARCH" class="searchqnabt"></div>
					</td>
				</tr>
			</table>
			<img src="./resources/images/qareview.png" height="160px" width="445px" class="review_search" />
			<div class="writebt">
			
					<!-- <div id="qalist_w"> -->
			
				
		
						<input type="hidden" name="login_email" id="login_email" 
						value="${login_email}"/>
						<input type="button" value="REVIEW 등록" class="re_bt"
							onclick="write_window()">
					<!-- </div> -->
				
				
			</div>

		</div>
		<div id="qashow">
		<table id="qalist">
			<tr>
				<td class="qatd1">
					<div>No.</div>
				</td>
				<td class="qatd2">
					<div>TITLE</div>
				</td>
				<td class="qatd">
					<div>EMAIL</div>
				</td>
				<td class="qatd4">
					<div>DATE</div>
				</td>
				<td class="qatd5">
					<div>VIEW</div>
				</td>
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="num" value="${listcount-(page-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${qalist}">

				<tr align="center"
					onmouseover="this.style.background='#B1EFED';javascript:view_image(this,'${b.qa_file}')"
					onmouseout="this.style.background='';javascript:close_image();">
					<td  class="qaten">
						<!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
							value="${num-1}" />
					</td>

					<td class="qaten">
						<div>

							<!-- 답글인 경우 -->
							<c:if test="${b.qa_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.qa_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>
								<img src="./resources/images/AnswerLine.png">
							</c:if>

							<!-- 제목 출력 부분 -->
							<a class="scanview" href="#"
								>
								${b.qa_subject} 
							</a> <input type="hidden" value="${b.qa_num}" id="num">
						</div>
					</td>

					<td class="qaten">
						<div>${b.qa_name}</div>
					</td>
					<td class="qaten">
					<div><c:set var="TextValue" value="${b.qa_date}"/>
						${fn:substring(TextValue,0,16)}
					</div>
					</td>
					<td class="qaten">
						<div>${b.qa_readcount}</div>
					</td>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>



		<!-- <div style="margin-left:120px; margin-top:20px" > -->
		<c:if test="${listcount >= 1}">
		<div class="paging" style="align: center; margin-top: 20px">
			<c:if test="${page <=1 }">
				<a class="direction" href="qa_list.nhn?page=${page}">&lt</a>
			</c:if>
			<c:if test="${page > 1 }">
				<a class="direction" href="qa_list.nhn?page=${page-1}">&lt</a>
			</c:if>

			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					<span class="number on">${a}</span>
				</c:if>
				<c:if test="${a != page }">
					<a class="number" href="qa_list.nhn?page=${a}">${a}</a>
				</c:if>
			</c:forEach>

			<c:if test="${page >= maxpage }">
				<span class="direction">&gt</span> 
			</c:if>
			<c:if test="${page < maxpage }">
				<a class="direction" href="qa_list.nhn?page=${page+1}">&gt</a>
			</c:if>
		</div>
		</c:if>
		
		<img style="width:200px; height:100px; position :absolute; display:none;" id="preview_image" src="">
		<!-- 검색 부분 -->
		<div id="qafind">
			<script>
				function find_check() {
					if ($.trim($("#find_name").val()) == "") {
						alert("검색내용을 입력하세요!");
						$("#find_name").val("").focus();
						return false;
					}
				}
			</script>
		</div>
		</div>
	</div>
</body>
</html>