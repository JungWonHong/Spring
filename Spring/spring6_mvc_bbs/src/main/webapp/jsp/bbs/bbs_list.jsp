<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
   <title>게시판 목록</title>
   <link rel="stylesheet" href="./resources/css/admin.css" type="text/css">   
   <link rel="stylesheet" href="./resources/css/bbs.css" type="text/css">   
   <link rel="stylesheet" href="./resources/css/list.css" type="text/css">   
</head>
<body>
<div id="bbslist_wrap">
  <h2 class="bbslist_title">자료실 목록</h2>
  <div id="bbslist_c">글 개수 : ${listcount}</div>
   
   <table id="bbslist_t">
   <tr align="center" valign="middle" bordercolor="#333333">
      <td class="eleven" width="8%" height="26">
         <div>번호</div>
      </td>
      <td class="eleven" width="47%">
         <div>제목</div>
      </td>
      <td class="eleven" width="14%">
         <div>작성자</div>
      </td>
      <td class="eleven" width="17%">
         <div>날짜</div>
      </td>
      <td class="eleven" width="14%">
         <div>조회수</div>
      </td>
   </tr>
   
   <!-- 화면 출력 번호  변수 정의 -->      
   <c:set var="num" value="${listcount-(page-1)*10}"/>    
   
   <!-- 반복문 시작 -->
   <c:forEach var="b" items="${bbslist}">
   
   <tr align="center"  bordercolor="#333333"
      onmouseover="this.style.background='#FFF8F8'"
      onmouseout="this.style.background=''">
      <td height="23" class="ten">
         <!-- 번호 출력 부분 -->   
          <c:out value="${num}"/>         
         <c:set var="num" value="${num-1}"/>            
      </td>
      
      <td class="ten">
         <div style="text-align:left">
         
         <!-- 답글인 경우 -->
            <c:if test="${b.bbs_re_lev != 0}"> 
               <c:forEach var="k" begin="1" end="${b.bbs_re_lev}">
                  &nbsp;&nbsp;         
               </c:forEach>
               <img src="./resources/images/AnswerLine.gif">   
            </c:if>         
         
                <!-- 제목 출력 부분 -->   
            <a href="bbs_cont.nhn?num=${b.bbs_num}&page=${page}&state=cont">
               ${b.bbs_subject}
            </a>
         </div>
      </td>
      
      <td class="ten">
               <div>${b.bbs_name}</div>
            </td>
            <td class="ten">
               <div>${b.bbs_date}</div>
            </td>
            <td class="ten">
               <div>${b.bbs_readcount}</div>
            </td>
         </tr>
         
         </c:forEach>
         <!-- 반복문 끝 -->         
      </table>
      
      
   <div style="margin-left:0px;margin-top:20px" >         
         <c:if test="${page <=1 }">
            [이전]&nbsp;
         </c:if>
         
         <c:if test="${page > 1 }">
            <a href="bbs_list.nhn?page=${page-1}">[이전]</a>&nbsp;
         </c:if>         

         <c:forEach var="a" begin="${startpage}" end="${endpage}">
            <c:if test="${a == page }">
               [${a}]
            </c:if>
            <c:if test="${a != page }">
               <a href="bbs_list.nhn?page=${a}">[${a}]</a>&nbsp;
            </c:if>
         </c:forEach>         
         
         <c:if test="${page >= maxpage }">
            [다음] 
         </c:if>
         <c:if test="${page < maxpage }">
            <a href="bbs_list.nhn?page=${page+1}">[다음]</a>
         </c:if>         
      </div>
      
      <div id="bbslist_w">
        <input type="button" value="글쓰기" class="input_button"
        onclick="location='bbs_write.nhn'">
      </div>
      
      <!-- 검색 부분 -->
      <div id="bbsfind">
         <script src="./resources/js/jquery.js"></script>
        <script>
         function find_check(){
            if($.trim($("#find_name").val())==""){
               alert("검색이름을 입력하세요!");
               $("#find_name").val("").focus();
               return false;
            }
         }
        </script>

         <form method="get" action="bbs_find_ok.nhn"
            onsubmit="return find_check()">
            <table>
               <tr>
                  <th><select name="find_field">
                        <option value="bbs_name">작성자</option>
                        <option value="bbs_subject">글제목</option>
                        <option value="bbs_content">글내용</option>
                  </select></th>
                  <td><input name="find_name" id="find_name" size="18"
                     class="input_box"> <input type="submit" value="검색"
                     class="input_button">
                </td>
               </tr>
            </table>
            </form>
      </div>
</div>
</body>
</html>