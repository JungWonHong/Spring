<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">
<head>
<title>REVIEW SEARCH</title>
<style>#qalist_c{font-size:15pt;}
#ntfintlist_wrap{margin-top:10%; margin-left:20%}
.paging{    padding-left: 50%;
    font-size: 15pt;
    margin-top: 5%;}
    .ten{text-align:center}
</style>
</head>
<body>
	<div id="ntfintlist_wrap">
	
		<div id="qalist_c">글 개수 : ${ntlistcount}</div>
		
		<table id="ntfindlist_t">
			<tr align="center" valign="middle" bordercolor="#333333">
				<td class="eleven" width="20%" height="26">
					<div>No.</div>
				</td>
				<td class="eleven" width="65%">
					<div>TITLE</div>
				</td>
				<!-- <td class="eleven" width="20%">
					<div>ID</div>
				</td> -->
				<td class="eleven" width="25%">
					<div>DATE</div>
				</td>
				<!-- <td class="eleven" width="15%">
					<div>VIEW</div>
				</td> -->
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="num" value="${ntlistcount-(ntpage-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${ntlist}">

				<tr align="center" valign="middle" bordercolor="#333333"
					onmouseover="this.style.background='#B1EFED'"
					onmouseout="this.style.background=''">
					<td height="23" class="ten">
						<!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
							value="${num-1}" />
					</td>
					
					<td class="ten">
						<div>
							<!-- 답글인 경우 -->
							<c:if test="${b.nt_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.nt_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>
								<img src="./resources/images/AnswerLine.png">
							</c:if>

                              <input type="hidden" name="num" value="${b.nt_num}"/>
                           <input type="hidden" name="page" value="${ntpage}" />
                           
                           <input type="hidden" name="state" value="cont" />
                           
							<!-- 제목 출력 부분 -->
							<a href="#" class="subjectview">
								${b.nt_subject} </a>
						</div>
					</td>
					
					<%-- <td class="ten">
						<div>${b.nt_name}
					</td> --%>

					<td class="ten">
						<div><c:set var="TextValue" value="${b.nt_date}"/>
						${fn:substring(TextValue,0,16)}</div>
					</td>
					<%-- <td class="ten">
						<div>${b.nt_readcount}</div>
					</td> --%>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>


		<!-- </div> -->

		<div class="paging">
			<c:if test="${ntpage <=1 }">
				<a class="direction" href="nt_find_ok.nhn?ntfind_name=${ntfind_name}&ntfind_field=${ntfind_field}">&lt</a>
			</c:if>

			<c:if test="${ntpage > 1 }">
				<a class="direction" href="nt_find_ok.nhn?ntpage=${ntpage-1}&ntfind_name=${ntfind_name}&ntfind_field=${ntfind_field}">&lt</a>
			</c:if>

			<c:forEach var="a" begin="${ntstartpage}" end="${ntendpage}">
				<c:if test="${a == ntpage }">
					<span class="number on">${a}</span>
				</c:if>
				<c:if test="${a != ntpage }">
					<a class="number" href="nt_find_ok.nhn?ntpage=${a}&ntfind_name=${ntfind_name}&ntfind_field=${ntfind_field}">${a}</a>
				</c:if>
			</c:forEach>

			<c:if test="${ntpage >= ntmaxpage }">
				<a class="direction">&gt</a> 
			</c:if>
			<c:if test="${ntpage < ntmaxpage }">
				<a class="direction" href="nt_find_ok.nhn?ntpage=${ntpage+1}&ntfind_name=${ntfind_name}&ntfind_field=${ntfind_field}">&gt</a>
			</c:if>
		</div>

		
	</div>
</body>
</html>