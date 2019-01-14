<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/jsp/include/time.jsp"%>
<html>
<title>KHCC - 실시간 예약</title>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/map2.css" />
<link href="./resources/bootstrap-css/bootstrap.min.css"
   rel="stylesheet">
<link href="./resources/bootstrap-css/prettyPhoto.css" rel="stylesheet">
<link href="./resources/bootstrap-css/font-awesome.min.css"
   rel="stylesheet">
<link href="./resources/bootstrap-css/animate.css" rel="stylesheet">
<link href="./resources/bootstrap-css/main.css" rel="stylesheet">
<link href="./resources/bootstrap-css/responsive.css" rel="stylesheet">
<script src="./resources/js/jquery-3.2.1.js"></script>
<style>
#menu_wrap {
   position: absolute;
   overflow: scroll;
   top: 5px;
   left: 35%;
   margin-left: -280px;
   /* margin-top: 70px; */ 
   margin-top: 150px;   /*include 하면서 마진 조정함(순일)*/
   z-index: 5;
   background-color: #fff;
   padding: 5px;
   border: 1px solid #999;
   height: 40%;
   width: 30%;
}
#keyword{width:300px; height:30px; margin-left:1%; margin-top:1%;}
.font{margin-left:10%; font-size:13pt; margin-top:2%;}
.subbt{  
     width: 80px;
   height: 28px;
   background: #2ABCB4;
   color: white;
   border: 0px; }
</style>
</head>
<body>
<c:if test="${!empty login_email}">
<%@ include file = "../include/menubar_login.jsp" %>
</c:if>

<c:if test="${empty login_email}">
<%@ include file = "../include/menubar_nologin.jsp" %>
</c:if>
   <div class="map_wrap" style="margin-top:8%">
      <div id="map"
         style="width: 100%; height: 80%; position: relative; overflow: hidden;"></div>
      <div id="menu_wrap" class="bg_white">
         <div class="option">
            <div>
               <form onsubmit="searchPlaces(); return false;">
                  <span class="font">지역 :</span> <input type="text" value="역삼" id="keyword" name="keyword"
                     >
                  <button type="submit" class="subbt">검색하기</button>
               </form>
            </div>
         </div>
         <hr>
         <ul id="placesList"></ul>
         <div id="pagination"></div>
      </div>
   </div>

   <div id="carList" style="margin-top: 120px">
      <!-- 예약확인 / 결제 모달창 -->
   <div class="modal fade" id="reservation">
      <div class="modal-dialog">
         <div class="modal-content">
            <form method="post" action="khcc_reservation_pay.nhn"
               onsubmit="return phone_check()">
               <!-- header -->
               <div class="modal-header">
                  <h3 class="modal-title">예약확인</h3>
               </div>
               <!-- body -->
               <div class="modal-body">
                  <table>
                     <tr><th>종류</th><td>
                        <input type="text" name="c_kind" id="c_kind" readOnly></td></tr>
                     <tr><th>모델</th><td>
                        <input type="text" name="c_model" id="c_model" readOnly></td></tr>
                     <tr><th>위치</th><td>
                        <input type="text" name="c_place" id="c_place" readOnly></td></tr>
                     <tr><th>대여일</th><td>
                        <input type="date" class="datepicker" name="startDate" id="startDate">
                        <select id="starttime" name="startTime">
                           <c:forEach var="t" items="${time}">
                              <option value="${t}">${t}</option>
                           </c:forEach>
                        </select></td></tr>
                     <tr><th>반납일</th><td>
                     	<input type="hidden" name="c_id" id="c_id">
                        <input type="date" class="datepicker" name="endDate" id="endDate">
                        <select id="endtime" name="endTime">
                           <c:forEach var="t" items="${time}">
                              <option value="${t}">${t}</option>
                           </c:forEach>
                        </select></td></tr>
                  </table>
                  <script>
                     $('#endtime').change(function chageSeltime(){
                        var id = $('#c_id').val();
                        var startDate = $('#startDate').val();
                        var endDate = $('#endDate').val();
                        var startTime = $('#starttime').val();
                        var endTime = $('#endtime').val();
                        $.ajax({
                           url:'./khcc_reservation_total.nhn',
                           data:'c_id=' + id + '&startDate=' + startDate + "&endDate=" + endDate 
                                 + "&startTime=" + startTime + "&endTime=" + endTime,
                           success:function(data){
                              if(data < 0){
                                 alert('반납일은 대여일보다 작을 수 없습니다.');
                                 return false;
                              } else{
                                 $("#tot_price").text('');
                                    $("#tot_price").show();
                                    $("#tot_price").append("<hr>총 결제금액 " + data + "원").css("font-size", "20px");
                              }
                           },
                           error:function(data){
                              alert('에러' + data);
                           }
                        });
                     });
                  </script>
                  <div id="tot_price"></div>
                  <hr>
                  <h3 class="modal-title">결제 정보</h3>
                     카드 이름<input type="text" id="cardName" name="cardName" value="${cardName}" readOnly><br>
                     카드 번호<input type="text" id="cardNum" name="cardNum" value="${cardNum}" readOnly>
               </div>

               <!-- Footer -->
               <div class="modal-footer">
                  <input type="submit" class="btn btn-default" value="결제하기">
                  <button class="btn btn-default" data-dismiss="modal">닫기</button>
               </div>
            </form>
         </div>
      </div>
   </div>
      <table id="output" style="text-align:center; margin:0 auto;">
      </table>
   </div>
   
      
   <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6accf207a5a463f46a85bdffeb649e27&libraries=services,clusterer,drawing"></script>
   <script>
      // 마커를 담을 배열입니다
      var markers = [];

      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
      mapOption = {
         center : new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
         level : 3
      // 지도의 확대 레벨
      };

      // 지도를 생성합니다    
      var map = new daum.maps.Map(mapContainer, mapOption);

      // 장소 검색 객체를 생성합니다
      var ps = new daum.maps.services.Places();

      // 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
      var infowindow = new daum.maps.InfoWindow({
         zIndex : 1
      });

      // 키워드로 장소를 검색합니다
      searchPlaces();

      // 키워드 검색을 요청하는 함수입니다
      function searchPlaces() {

         var keyword = document.getElementById('keyword').value;

         if (!keyword.replace(/^\s+|\s+$/g, '')) {
            alert('키워드를 입력해주세요!');
            return false;
         }

         // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
         ps.keywordSearch(keyword, placesSearchCB); //1
      }

      // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
      function placesSearchCB(data, status, pagination) {
         if (status === daum.maps.services.Status.OK) {

            // 정상적으로 검색이 완료됐으면
            // 검색 목록과 마커를 표출합니다
            displayPlaces(data);

            // 페이지 번호를 표출합니다
            displayPagination(pagination);

         } else if (status === daum.maps.services.Status.ZERO_RESULT) {

            alert('검색 결과가 존재하지 않습니다.');
            return;

         } else if (status === daum.maps.services.Status.ERROR) {

            alert('검색 결과 중 오류가 발생했습니다.');
            return;

         }
      }

      // 검색 결과 목록과 마커를 표출하는 함수입니다
      function displayPlaces(places) {

         var listEl = document.getElementById('placesList'), menuEl = document
               .getElementById('menu_wrap'), fragment = document
               .createDocumentFragment(), bounds = new daum.maps.LatLngBounds(), listStr = '';

         // 검색 결과 목록에 추가된 항목들을 제거합니다
         removeAllChildNods(listEl);

         // 지도에 표시되고 있는 마커를 제거합니다
         removeMarker();

         for (var i = 0; i < places.length; i++) {

            // 마커를 생성하고 지도에 표시합니다
            var placePosition = new daum.maps.LatLng(places[i].y,
                  places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
                  i, places[i]); // 검색 결과 항목 Element를 생성합니다

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
            // LatLngBounds 객체에 좌표를 추가합니다
            bounds.extend(placePosition);

            // 마커와 검색결과 항목에 mouseover 했을때
            // 해당 장소에 인포윈도우에 장소명을 표시합니다
            // mouseout 했을 때는 인포윈도우를 닫습니다
            (function(marker, title) {
               daum.maps.event.addListener(marker, 'mouseover',
                     function() {
                        displayInfowindow(marker, title);
                     });

               daum.maps.event.addListener(marker, 'click', function() {
                  // title 값 넘겨주는 ajax수행합니다.
                  $.ajax({
                     url : './khcc_ajax.nhn',
                     data : "title=" + title,
                     dataType : "json",
                     cache : false,
                     headers : {
                        "cache-control" : "no-cache",
                        "pragma" : "no-cache"
                     },
                     success : function(data) {
                        var output = '';
                        output += "<tr><th>이미지</th><th>종류</th><th>모델</th><th>대여 요금</th>";
                        output += "<th>주행 요금</th><th>위치</th><th>예약하기</th></tr>";
                        $(data).each(
                              function(index, item) {
                                 $("#output").empty();
                                 output += '<tr><td><img src=./resources/images/car/' + item.c_img + '></td>';
                                 output += '    <td>' + item.c_kind + '</td>';
                                 output += '    <td>' + item.c_model + '</td>';
                                 output += '    <td>' + item.c_rentfee + '원/시간</td>';
                                 output += '    <td>' + item.c_oilfee + '원/km</td>';
                                 output += '    <td>' + item.c_place + '</td>';
                                 output += '    <td><button class="btn btn-default" data-target="#reservation"'
                                       + 'data-toggle="modal">예약하기</button></td></tr>';
                                 $('#output').append(output);
                                 $('#c_img').val(item.c_img);
                                 $('#c_kind').val(item.c_kind);
                                 $('#c_model').val(item.c_model);
                                 $('#c_place').val(item.c_place);
                                 $('#c_id').val(item.c_id);
                              })
                     },
                     error : function(data) {
                        alert("오류 발생");
                     }
                  });
               });

               daum.maps.event.addListener(marker, 'mouseout', function() {
                  infowindow.close();
               });

               itemEl.onmouseover = function() {
                  displayInfowindow(marker, title);
               };

               itemEl.onmouseout = function() {
                  infowindow.close();
               };
            })(marker, places[i].place_name);

            fragment.appendChild(itemEl);
         }

         // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
         listEl.appendChild(fragment);
         menuEl.scrollTop = 0;

         // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
         map.setBounds(bounds);
      }

      // 검색결과 항목을 Element로 반환하는 함수입니다
      function getListItem(index, places) {

         var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
               + (index + 1)
               + '"></span>'
               + '<div class="info">'
               + '   <h5>' + places.place_name + '</h5>';

         if (places.road_address_name) {
            itemStr += '    <span>' + places.road_address_name + '</span>' //2
                  + '   <span class="jibun gray">' + places.address_name
                  + '</span>';
         } else {
            itemStr += '    <span>' + places.address_name + '</span>';
         }

         itemStr += '  <span class="tel">' + places.phone + '</span>'
               + '</div>';

         el.innerHTML = itemStr;
         el.className = 'item';

         return el;
      }

      // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
      function addMarker(position, idx, title) {
         var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
         imageSize = new daum.maps.Size(36, 37), // 마커 이미지의 크기
         imgOptions = {
            spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new daum.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset : new daum.maps.Point(13, 37)
         // 마커 좌표에 일치시킬 이미지 내에서의 좌표
         }, markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
               imgOptions), marker = new daum.maps.Marker({
            position : position, // 마커의 위치
            image : markerImage
         });

         marker.setMap(map); // 지도 위에 마커를 표출합니다
         markers.push(marker); // 배열에 생성된 마커를 추가합니다

         return marker;
      }

      // 지도 위에 표시되고 있는 마커를 모두 제거합니다
      function removeMarker() {
         for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
         }
         markers = [];
      }

      // 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
      function displayPagination(pagination) {
         var paginationEl = document.getElementById('pagination'), fragment = document
               .createDocumentFragment(), i;

         // 기존에 추가된 페이지번호를 삭제합니다
         while (paginationEl.hasChildNodes()) {
            paginationEl.removeChild(paginationEl.lastChild);
         }

         for (i = 1; i <= pagination.last; i++) {
            var el = document.createElement('a');
            el.href = "#";
            el.innerHTML = i;

            if (i === pagination.current) {
               el.className = 'on';
            } else {
               el.onclick = (function(i) {
                  return function() {
                     pagination.gotoPage(i);
                  }
               })(i);
            }

            fragment.appendChild(el);
         }
         paginationEl.appendChild(fragment);
      }

      // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
      // 인포윈도우에 장소명을 표시합니다
      function displayInfowindow(marker, title) {
         var content = '<div style="padding:5px;z-index:1;">' + title
               + '</div>';

         infowindow.setContent(content);
         infowindow.open(map, marker);
      }

      // 검색결과 목록의 자식 Element를 제거하는 함수입니다
      function removeAllChildNods(el) {
         while (el.hasChildNodes()) {
            el.removeChild(el.lastChild);
         }
      }
   </script>
</body>
</html>