<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Carpool List</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./resources/js/carpool_driver2.js"></script>
<style>
   #cplist_wrap {
      margin: auto;
      margin-top: 13%;
   }
   
   .cplist_title{   
      font-size: 30pt;
      font-weight: bold;
      margin-left: 15%;
      color: #2ABCB4
   }
   
   #cplist_c{
      margin-top:15%;
      font-size:15pt;
      font-weight:bold;
      margin-left:13%;
   }
   
   #cplist_t{
       width:1000px;
       margin-left:15%;

       }
   
   .cptd1{
      width: 100px;
      height: 50px;
      border: 1px solid #F2EFEF;
      background: #2ABCB4;
      color: white;
      font-size: 15pt;
      font-weight: bold;
      text-align:center;
      margin-top:25%;
   }

   .cptd{
      width: 180px;
      height: 50px;
      border: 1px solid #F2EFEF;
      background: #2ABCB4;
      color: white;
      font-size: 15pt;
      font-weight: bold;
      text-align:center;
      margin-top:15%;
   }
   
   .cpcont1{
      font-size: 13pt;
      height: 50px;
      border-bottom: 2px solid lightgray;
      text-align:center;
   }
   
   .cpcont{
      font-size: 13pt;
      height: 50px;
      border-bottom: 2px solid lightgray;
      text-align:center;
   }   
   
   .paging{
       margin-top:5%;
       margin-left:43%;
       font-size:13pt;
   }
   
   #cp_sort{
      margin-top:5%;
       margin-left:32%;
   }
   
   #viewlist{
       width:100px;
       height:40px;
       font-size:13pt;
   }
   #cpfind{
      margin-top:-2.1%;
       margin-left:37.5%;
   }
   
   .find_cpfind{
       width:100px;
       height:40px;
       font-size:13pt;
   }
   .find_text{
        width:300px;
       height:40px;
    }
    .fint_bt{
       width: 100px;
      height: 40px;
      color:white;
       background: #2ABCB4;
    }
</style>
</head>
<body>
<c:if test="${!empty login_email}">
<%@ include file = "../include/menubar_login.jsp" %>
</c:if>

<c:if test="${empty login_email}">
<%@ include file = "../include/menubar_nologin.jsp" %>
</c:if>
   <div id="cplist_wrap">
      <div class="cplist_title">Carpool List</div>

      <div id="cp_sort">
         <select id="viewlist" name="viewlist">
            <option value="recent">최신순</option>
            <option value="distance">거리순</option>
            <option value="fare">요금순</option>
         </select>
      </div>
		<script>
         $(function(){
            $("#viewlist").val("${type}").prop("selected", true);
         });
        </script>
      <!-- 검색 부분 -->
      <div id="cpfind">
         <form method="get" action="cp_find"
            onsubmit="return find_check()">
            <table>
               <tr>
                  <th><select name="find_field" class="find_cpfind">
                        <option value="cp_depart">출발지</option>
                        <option value="cp_arrive">목적지</option>
                  </select></th>
                  <td>
                      <input name="find_name" id="find_name" class="find_text"> 
                      <input type="submit" value="검색" class="fint_bt">
                  </td>
               </tr>
            </table>
         </form>
      </div>

      <table id="cplist_t">
          <tr>
            <td colspan="2">
                <div id="cplist_c"><span>신규 등록된 카풀 수 : ${listcount}</span></div>
            </td>
         </tr>
         <tr>
            <td>
               <div class="cptd1">번호</div>
            </td>
            <td>
               <div class="cptd">라이더</div>
            </td>
            <td>
               <div class="cptd">출발지</div>
            </td>
            <td>
               <div class="cptd">목적지</div>
            </td>
            <td>
               <div class="cptd">이용시간</div>
            </td>
            <td>
               <div class="cptd">총거리</div>
            </td>
            <td>
               <div class="cptd">요금</div>
            </td>
         </tr>

         <!-- 화면 출력 번호  변수 정의 -->
         <c:set var="num" value="1" />

         <!-- 반복문 시작 -->
         <c:forEach var="b" items="${cplist}">

            <tr
               onmouseover="this.style.background='#FFF8F8'"
               onmouseout="this.style.background=''" 
               onclick="javascript:carpool_request();">
               <td class="cpcont1">
                  <!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
                     value="${num+1}" />
                  <input type="hidden" id="cp_num" value="${b.cp_num }"/>
               </td>

               <td class="cpcont">
                  <div>
                     ${b.cp_id}
                  </div>
                  <input type="hidden" id="cp_id" value="${b.cp_id }"/>
               </td>
               <td class="cpcont">
                  <div>${b.cp_depart}</div>
                  <input type="hidden" id="depart" value="${b.cp_depart}"/>
               </td>
               <td class="cpcont">
                  <div>${b.cp_arrive}</div>
                  <input type="hidden" id="arrive" value="${b.cp_arrive}"/>
               </td>
               <td class="cpcont">
                  <div>${b.cp_time}</div>
                  <input type="hidden" id="time" value="${b.cp_time}"/>
               </td>
               <td class="cpcont">
                  <div>${b.cp_distance}km</div>
                  <input type="hidden" id="distance" value="${b.cp_distance}"/>
               </td>
               <td class="cpcont">
                  <div>${b.cp_sum}원</div>
                  <input type="hidden" id="sum" value="${b.cp_sum}"/>
               </td>
            </tr>

         </c:forEach>
         <!-- 반복문 끝 -->
      </table>


      <div class="paging">
         <c:if test="${page <=1 }">
            [이전]&nbsp;
         </c:if>

         <c:if test="${page > 1 }">
            <a class="direction" href="cp_list?page=${page-1}&viewlist=${type}">[이전]</a>&nbsp;
         </c:if>

         <c:forEach var="a" begin="${startpage}" end="${endpage}">
            <c:if test="${a == page }">
               <span class="number on">[${a}]</span>
            </c:if>
            <c:if test="${a != page }">
               <a class="number" href="cp_list?page=${a}&viewlist=${type}">[${a}]</a>&nbsp;
            </c:if>
         </c:forEach>

         <c:if test="${page >= maxpage }">
            [다음] 
         </c:if>
         <c:if test="${page < maxpage }">
            <a class="direction"  href="cp_list?page=${page+1}&viewlist=${type}">[다음]</a>
         </c:if>
      </div>
       
   </div>
</body>
</html>