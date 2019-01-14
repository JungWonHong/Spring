<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">
<head>
<title>고객센터</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<script>
	$(document).ready(function() {
		$(".show3").hide();
		$(".show2").hide();
	

		$(".menu1").click(function() {
			$(".show3").hide();
			$(".show2").hide();
			$(".show1").show();
		});

		$(".menu2").click(function() {
			$('.show1').hide();
			$(".show3").hide();
		
			$(".show2").show();
			
		
			
			
				$.ajax({
					url:'./qna_list.nhn',
					//data: 'qnapage=' + $(this).next().val(),
					dataType: 'html',
				     success: function(redata){
				    	console.log(redata);
				    	 $('#qnalist').empty();			    	
				    	 $('#qnalist').append(redata);
				    
				     }
					
				})
				

			$("#qnalist").on('click','.qnasubject',function() {

          	$.ajax({
 				url:'./qna_cont_ajax.nhn',
				data: 'num=' + $(this).next().val(),
				dataType: 'html',
				success: function(redata){
				console.log(redata);
				$('#qnalist').empty();			    	
				$('#qnalist').append(redata);

					}

				})

			});  //qnacontview
			
			
				$("#qnalist").on('click','.qna_list',function() {
					

					$.ajax({
						url:'./qna_list.nhn',
						dataType: 'html',
					     success: function(redata){
					    	console.log(redata);
					    	 $('#qnalist').empty();			    	
					    	 $('#qnalist').append(redata);
					    
				  
				    	
				     },
				     error:function(){
				    	 alert("error");
				    	 
				     }
					
				});
				


			});	//qnalist
			
			
				$(".input_qnabutton").click(function() {
					senddata = 'qnafind_name=' + $("#qnafind_name").val() + '&qnafind_field=' + $("#qnafind_field").val();
					$.ajax({
						url:'./qna_find_ok.nhn',
					data: senddata ,
				     success: function(redata){
				         console.log(redata);
				         $('#qnalist').empty();
				    	 $('#qnalist').append(redata);
				    	
				     },
				     error:function(){
				    	 alert("error");
				    	 
				     }
					
				});
				
	  
	       
			});//$(".input_qnabutton").click end
			

								
			
			
		});   //show2 end


		$(".menu3").click(function() {
			$('.show1').hide();
			$(".show2").hide();

			$(".show3").show();
		});
		
		$("#cont").on('click','.ajaxtest',function() {
		
			$.ajax({
				url:'./nt_cont_ajax.nhn',
				data: 'num=' + $(this).next().val(),
				dataType: 'html',
			     success: function(redata){
			    	//alert(redata);
			    	 $('#cont').empty();			    	
			    	 $('#cont').append(redata);
			    	 $('#cont script').remove();
			     }
				
			})
			
  
       
		});
		
			$(".input_findbt").click(function() {
				senddata = 'ntfind_name=' + $("#ntfind_name").val() + '&ntfind_field=' + $(".ntfind").val();
				$.ajax({
				url:'./nt_find_okajax.nhn',
				data: senddata ,
			     success: function(redata){
			         console.log(redata);
			         $('#cont').empty();
			    	 $('#cont').append(redata);
			    	
			     },
			     error:function(){
			    	 alert("error");
			    	 
			     }
				
			});
			
  
       
		});//$(".input_findbt").click end
		
		$("#cont").on('click','.subjectview',function() {
			
			senddata = 'num=' + $(this).prev().prev().prev().val() + '&page=' +$(this).prev().prev().val() + '&state=cont' ;
			
			$.ajax({
			url:'./nt_cont.nhn',
			data: senddata ,
		     success: function(redata){
		         console.log(redata);
		         $('#cont').empty();
		    	 $('#cont').append(redata);
		    	
		     },
		     error:function(){
		    	 alert("error");
		    	 
		     }
			
		});
	});//$(".subjectview").click


	$("#cont").on('click','.list_bt',function() {
		
		senddata = 'ntpage='  + $("#page").val();
		
		$.ajax({
		url:'./nt_list.nhn',
		data: senddata ,
		dataType : 'html',
	     success: function(redata){
	    	 output = $(redata).find("#cont").html()	    	
	    	 
	    	 $('#cont').empty();
	    	 
	         $('#cont').append(output);
	    	
	     },
	     error:function(){
	    	 alert("error");
	    	 
	     }
	});

});  //list_bt end
	});//ready end
</script>



<style>

#qalist_wrap1 {
	margin-top: 10%
}

#qalist_title {
	font-size: 30pt;
	font-weight: bold;
	margin-left: 15%;
	color: #2ABCB4
}

.menu {
	font-size: 15pt;
	margin-left: 13%;
	 font-family: roboto;
	color: black;
	list-style: none;
	line-height: 300%;
	cursor: pointer;
}

.menu1:hover {
	color: #2ABCB4;
}

.menu2:hover {
	color: #2ABCB4;
}

.menu3:hover {
	color: #2ABCB4;
}

.menu4:hover {
	color: #2ABCB4;
}

.menu1, .menu2, .menu3, .menu4 {
	border-bottom: 2px solid lightgray;
	width: 300px
}

.qt {
	font-size: 30pt;
	font-weight: bold;
	margin-left: 37%;
	margin-top: -13%
}

.qt1 {
	font-size: 15pt;
	font-weight: bold;
	margin-left: 37%;
	margin-top: 3%
}

.hrstyle {
	width: 900px;
	margin-left: 37%
}

.qt2 {
	font-size: 15pt;
	padding-left: 37%
}

.searchdiv {
	border: 2px solid #F2EFEF;
	width: 900px;
	height: 130px;
	margin-left: 37%;
	margin-top: 5%;
	background-color: #F2EFEF
}

#ntfind_field {
	padding-left: 37%
}

.imgsearch {
	margin-top: 2.5%;
	margin-left: 2%
}

.ntfind {
	width: 8%;
	height: 40px;
}

.ntfint1 {
	margin-left: 30%;
	margin-top: -6.6%;
	width: 100%;
	height: 40px;
}

.input_find {
	height: 40px;
	width: 420px;
}

.input_findbt {
	width: 100px;
	height: 40px;
	background: #2ABCB4;
	color: white;
	border: 0px;
}

.input_adminbt {
	width: 900px;
	height: 40px;
	border: o;
	background: #2ABCB4;
	margin-left: 37%;
	color: white;
	font-size: 15pt;
	font-weight: bold
}

.eleven {
	width: 400px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
}

#qalist_t {
	margin-left: 20%;
	margin-top: 10%;
	text-align: center
}

.ten {
	font-size: 13pt;
	height: 50px;
	border-bottom: 2px solid lightgray
}

.paging {
	padding-left: 48%;
	font-size: 15pt;
	margin-top: 5%
}

.show1div {
	margin-left: 24.5%;
	margin-top: 10%
}

.endqnalist{}

.qna_searchdiv{	border: 2px solid #F2EFEF;
	width: 900px;
	height: 130px;
	margin-left: 37%;
	margin-top: 5%;
	background-color: #F2EFEF}
	
.qna_img{margin-top: 2.5%; margin-left: 2%}
#qnafind_field{	width: 8%; height: 40px;}
#qnafind_name{	height: 40px; width: 420px;}
.input_qnabutton{	width: 100px;
	height: 40px;
	background: #2ABCB4;
	color: white;
	border: 0px;}
.qna_searchdiv1{	margin-left: 30%;
	margin-top: -6.6%;
	width: 100%;
	height: 40px;}
.qna_button{	width: 900px;
	height: 40px;
	border: o;
	background: #2ABCB4;
	margin-left: 37%;
	color: white;
	font-size: 15pt;
	font-weight: bold}


</style>

</head>
<body>

  <input type="hidden" name="num" value="${ntbean.nt_num}" />
  <input type="hidden" name="page" value="${page}" />
	<input type="hidden" name="login_email" id="login_email"
		value="${login_email}" />
	<c:if test="${login_email == null}">
		<%@ include file="../include/menubar_nologin.jsp"%>
	</c:if>
	<c:if test="${login_email != null}">
		<%@ include file="../include/menubar_login.jsp"%>
	</c:if>

	<div id="qalist_wrap1">
		<!-- 		<span>
		<h2 id="qalist_title" onclick="location='qa_list.nhn?page=1'" >REVIEW</h2>
		</span> -->
		<span>
			<h2 id="qalist_title">고객센터</h2>
		</span>
		<ul class="menu">
			<li class="menu1">자주찾는 질문</li>
			<li class="menu2">1:1문의</li>
			<li class="menu3">공지사항</li>
		</ul>

		<div class="show1">
			<div class="qt">자주찾는 질문</div>
			<div class="qt1">KHCC가 궁금하세요?자주찾는 질문을 이용하세요</div>
			<div class="qt2">고객님의 궁금하신 사항을 빠르고 정확하게 해결하실 수 있습니다.</div>
		</div>

		<div class="show2">
			<div class="qt">1:1문의</div>
			<div class="qt1"> 이용 중에 궁금하신 점이 있으신가요? </div>
			<div class="qt2">문의사항을 접수하시면 최선을 다해 답변 드리겠습니다. </div>
		</div>
		
		
		<div class="show3">
			<div class="qt">공지사항</div>
			<div class="qt1">아는 것이 힘! 그린카 공지/뉴스정보를 확인하세요!</div>
			<div class="qt2">그린카의 다양한 상품 및 할인정보, 공지사항을 확인하실 수 있습니다.</div>
		</div>

		<hr class="hrstyle">
		<div class="show3">
			
				<div class="searchdiv">
					<img src="./resources/images/nt/search.png" height="80" width="239"
						class="imgsearch">
					<div class="ntfint1">
						<select name="ntfind_field" class="ntfind">
							<option value="nt_subject">제목</option>
							<option value="nt_content">내용</option>
						</select> <input name="ntfind_name" id="ntfind_name" size="45"
							class="input_find" /> <input type="submit" value="SEARCH"
							class="input_findbt">
					</div>
				</div>
			 
		</div>
		<%-- 지수만의 헤더 >..< --%>

	</div>

	<div class="show3">
	
		<table>

			<tr>

				<c:if test="${login_email eq 'admin@khcc.com'}">
					<div id="qalist_w">
						<input type="button" value="공지사항 등록(관리자 전용)" class="input_adminbt"
							onclick="javascript:ntwrite_window()">
					</div>
				</c:if>
			</tr>

		</table>
	</div>
	<div class="show1">
		<div class="show1div">
			<%@ include file="../nt/qna_add.jsp"%>
		</div>
	</div>

	<div class="show2">
	 	

		
			<div class="qna_searchdiv">
			
	
					<img src="./resources/images/nt/search.png" height="80" width="239" class="qna_img">
					   <div class="qna_searchdiv1">
					<select name="qnafind_field" id="qnafind_field">
							<option value="qna_name">EMAIL</option>
							<option value="qna_subject">제목</option>
							<option value="qna_content">내용</option>
					</select>
					
				 
				
					<input name="qnafind_name" id="qnafind_name" size="45"
						class="input_box" /> <input type="submit" value="SEARCH"
						class="input_qnabutton">
					</div>

						</div>
				
					<input type="button" value="Q&A 등록" class="qna_button"
							onclick="qnawrite_window()">
		

					
	<div id="qnalist">
	<input type="hidden" name="qnapage" value="${page}" id="qnapage" /> 
		<%-- <%@ include file="../qna/qna_list.jsp"%> --%>
		</div>
	</div>
	
	
	
	<div class="show3">
		<%--지수 수정
	
		&nbsp;
		<div id="qalist_wrap2"
			style="float: left; width: 30%; margin-left: 15px;"
			onclick="location='faq_list.nhn?page=${faqpage}'">
				<img src="./resources/images/faq_c.png" height="80" width="239"
					style="border-radius: 18px; align: center; margin-top: 0.5px" />
		</div>
		<!-- &nbsp; -->
		<div id="qalist_wrap2"
			style="float: left; width: 30%; margin-left: 15px;"
			onclick="location='qna_list.nhn?page=${qnapage}'">
				<img src="./resources/images/qna_c.png" height="80" width="239"
					style="border-radius: 18px; align: center; margin-top: 0.5px" />
			<br>
		</div>
		 --%>


    <div id="cont">
		<table id="qalist_t">
			<tr align="center" valign="middle">
				<td class="eleven">
					<div>No.</div>
				</td>
				<td class="eleven">
					<div>TITLE</div>
				</td>
				<td class="eleven">
					<div>DATE</div>
				</td>
			</tr>

    

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="ntnum" value="${ntlistcount-(ntpage-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${ntlist}">

				<tr>
					<td class="ten">
						<!-- 번호 출력 부분 --> <c:out value="${ntnum}" /> <c:set var="ntnum"
							value="${ntnum-1}" />
					</td>

					<td class="ten">
						<div>
							<!-- 답글인 경우 -->
							<c:if test="${b.nt_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.nt_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>

							</c:if>
                      
							<!-- 제목 출력 부분 -->
					<a href="#" class="ajaxtest"> 
							

								${b.nt_subject} </a>
								<input type="hidden" value="${b.nt_num}" id="num">
							
						</div>
						
					</td>

					<%-- <td class="ten">
						<div>${b.nt_name}</div>
					</td> --%>
					<td class="ten">
						<div>
							<c:set var="TextValue" value="${b.nt_date}" />
							${fn:substring(TextValue,0,16)}
						</div>
					</td>
					<%-- <td class="ten">
						<div>${b.nt_readcount}</div>
					</td> --%>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>


		<!-- </div> -->
		<c:if test="${ntlistcount >= 1}">
			<div class="paging">
				<c:if test="${ntpage <=1 }">
			   &nbsp;
				<a href="nt_list.nhn?ntpage=${ntpage}">&lt &nbsp;</a>
				</c:if>

				<c:if test="${ntpage > 1 }">
					<a href="nt_list.nhn?ntpage=${ntpage-1}">&lt &nbsp;</a>
				</c:if>

				<c:forEach var="a" begin="${ntstartpage}" end="${ntendpage}">
					<c:if test="${a == ntpage }">
					${a}
				</c:if>
					<c:if test="${a != ntpage }">
						<a href="nt_list.nhn?ntpage=${a}">${a}</a>
					</c:if>
				</c:forEach>

				<c:if test="${ntpage >= ntmaxpage }">
					<span>&gt &nbsp;</span>

				</c:if>
				<c:if test="${ntpage < ntmaxpage }">
					<a href="nt_list.nhn?ntpage=${ntpage+1}">&gt &nbsp;</a>
				</c:if>
			</div>
		</c:if>
</div>
		<!-- 검색 부분 -->
		<div id="qafind">
			<script>
				function ntfind_check() {
					if ($.trim($("#ntfind_name").val()) == "") {
						alert("검색내용을 입력하세요!");
						$("#ntfind_name").val("").focus();
						return false;
					}
				}
			</script>

		</div>

	</div>

</body>
</html>