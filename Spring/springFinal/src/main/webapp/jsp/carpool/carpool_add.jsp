<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
  <style>
    .sub_car{
       width: 60px;
      height: 30px;
      background: #2ABCB4;
      color: white;
      border: 0px;
     
     }
     .close_car{
        width: 60px;
      height: 30px;
      background: #2ABCB4;
      color: white;
      border: 0px;    
     
     }
    .btdiv{
      margin-left:33%;
      margin-top:2%;
     }
  </style>
</head>
<form name="carpool" method="post" action="cprequest_ok">
   <b>이용일 : </b> ${time }<br>
   <input type="hidden" name="CP_TIME" value=${date }>
   <b>출발지 : </b> ${depart }<br>
   <input type="hidden" name="CP_DEPART" value=${start }>
   <b>목적지 : </b> ${arrive }<br>
   <input type="hidden" name="CP_ARRIVE" value=${end }>
   <b>거리 : 약 </b> ${distance }km<br>
   <b>비용 : </b> ${sum }원<br>
   <input type="hidden" name="CP_SUM" value=${fee }>
   <input type="hidden" name="CP_DISTANCE" value=${distance }>
   <input type="hidden" name="cr_num" value=${cp_num } >
   <input type="hidden" name="cr_driver" value="${login_email}"/>
   <input type="hidden" name="cr_rider" value="${cp_id }"/>
   <b>신청하는 내용이 맞습니까?<br> 신청 후 취소가 불가능하니 한번 더 확인해 주세요.</b><br>
   
   <div class="btdiv">
   <input type="submit" value="신청" class="sub_car" />
   <input type="button" value="취소" class="close_car" onclick="javascript:self.close()"/>
   </div>
</form>
    