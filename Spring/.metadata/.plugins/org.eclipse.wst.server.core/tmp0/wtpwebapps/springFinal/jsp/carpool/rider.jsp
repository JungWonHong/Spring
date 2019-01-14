<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<title>Directions service</title>
<style type="text/css">
html, body {
   height: 100%;
   margin: 0;
   padding: 0;
}

#map-canvas, #map_canvas {
   margin: auto;
   width: 100%;
   height: 100%;
}

@media print {
   html, body {
      height: auto;
   }
   #map_canvas {
      height: 650px;
   }
}

#panel {
   position: absolute;
   top: 5px;
   left: 35%;
   margin-left: -180px;
   /* margin-top: 70px; */ 
   margin-top: 150px;   /*include 하면서 마진 조정함(순일)*/
   z-index: 5;
   background-color: #fff;
   padding: 5px;
   border: 1px solid #999;
}
.bt{
    width: 80px;
   height: 28px;
   background: #2ABCB4;
   color: white;
   border: 0px; 
}
.bt1{
    width: 80px;
   height: 28px;
   background: #2ABCB4;
   color: white;
   border: 0px; 
}
.btdiv{
      margin-left:20%;
      margin-top:2%;
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
   src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVzXMfk5f2-AMrdg37MSS911r1xuBCEFE"></script>
<script src="./resources/js/carpool_rider2.js"></script>
</head>
<body>
<%--    <c:if test="${!empty login_email}">
      <jsp:include page="../include/menubar_login.jsp"></jsp:include>
   </c:if>

   <c:if test="${empty login_email}">
      <jsp:include page="../include/menubar_nologin.jsp"></jsp:include>
   </c:if>
    --%>
   <div id="panel">
      <b>출발일: </b> <input type="datetime-local" id="date" name="date" /><br>
      <b>출발지: </b> <input type="text" id="start" name="start" /><br> <b>목적지:
      </b> <input type="text" id="end" name="end" />
      <div class="btdiv">
         <input type="button" value="경로보기" class="bt" onclick="Javascript:calcRoute();" />
         <input type="button" value="카풀신청" class="bt1" onclick="Javascript:calcFee();" />
      </div>
   </div>
   <div id="map-canvas"></div>
</body>
</html>