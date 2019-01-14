<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<style>
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
.divbt{
      margin-left:28%;
      margin-top:10%;
}
</style>
</head>
<form name="rider" method="post" action="carpool_add">
   <input type="hidden" name="cp_id" value=${sessionScope.login_email } >
   <b>출발일 : </b> ${date }<br>
   <input type="hidden" name="cp_time" value=${date }>
   <b>출발지 : </b> ${start }<br>
   <input type="hidden" name="cp_depart" value=${start }>
   <b>목적지 : </b> ${end }<br>
   <input type="hidden" name="cp_arrive" value=${end }>
   <b>소요시간 : 약 </b> ${duration }<br>
   <b>비용 : </b> ${fee }원<br>
   <input type="hidden" name="cp_sum" value=${fee }>
   <input type="hidden" name="cp_distance" value=${distance }>
   
   <div class="divbt">
   <input type="submit" value="등록" class="bt"/>
   <input type="button" value="취소" class="bt1" onclick="javascript:self.close()"/>
   </div>
</form>