<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./resources/js/jquery-3.2.1.js"></script>
<title>Insert title here</title>
<script>
$(document).ready(function(){
	 $(".atext").hide();
	 $(".btext").hide();
	 $(".ctext").hide();
	 $(".dtext").hide();
	 $(".aclick").click(function(){

	   $(".atext").toggle();
   
	});
	 
	 $(".bclick").click(function(){

		   $(".btext").toggle();
	   
		});
	 
	 $(".cclick").click(function(){

		   $(".ctext").toggle();
	    
		});
	 $(".dclick").click(function(){

		   $(".dtext").toggle();
	    
		});
});
</script>
<style>
   #tablea{ 
      background:#F2EFEF;
      font-size:17pt;
      color:gray;
      font-weight:bold;
      width:230px;  
      height:90px;
      text-align:center;
      }
   #a,#b,#c,#d{
   font-size:15pt;
   color:gray;
   font-weight:bold;
   border-bottom:2px solid lightgray; 
   width:1150px;
   height:100px;}
.aclick{margin-left:53%}
.bclick{margin-left:63.5%}
.cclick{margin-left:66.5%}
.dclick{margin-left:59.5%}
.atext{background:#F2EFEF; font-size:17pt; width:1150px; height:500px;}
.btext{background:#F2EFEF; font-size:17pt; width:1150px; height:700px;}
.ctext{background:#F2EFEF; font-size:17pt; width:1150px; height:300px;}
.dtext{background:#F2EFEF; font-size:17pt; width:1150px; height:1300px;}
.atext1,.btext1,.ctext1,.dtext1{margin-left:5%}
</style>
</head>
<body>

   		   <table>
		     <tr>
		     <td id="tablea">BEST 10</td>
		     <td id="tablea">가입 탈퇴</td>
		     <td id="tablea">쿠폰 포인트</td>
		     <td id="tablea">요금/결제</td>
		     <td id="tablea">사용/반납</td>
		     </tr>
		     
	
		   </table>
		      <div id="a"><br>
		      <img src="./resources/images/nt/qna.png" height="60" width="70">
		                                               친구 추천 쿠폰 발급/사용 방법을 알려주세요    <span class="aclick">▼</span> 
		     </div>
		       <div class="atext">
		       <div class="atext1">
		       <br><br>
		          친구추천 쿠폰은 두가지 방법을 통해 지급됩니다.<br><br><br>
              1. 추천인 ID 입력  > 신규 가입 친구 추천인 쿠폰     <br>
              -  발급 방법 : 가입 > 추가 혜택등록 > 추천인ID/추천코드에  <br>
                                        친구 ID를 입력 시 추천/피추천자  쿠폰 지급 <br>
             -  발급 조건 : 추천을 한 회원과 받은 회원이 모두 정회원인 경우 <br>
             -  유효 기간 : 없음 <br> <br><br>
                                    주말/시즌 이벤트에 따라  <br>
                                                    더블 혜택이 제공되며 사전 공지없이 중단될 수 있습니다. 
		      </div>         
		       </div>                                   
		      <div id="b"><br>
		      <img src="./resources/images/nt/qna.png" height="60" width="70">
		                                               결제카드 등록이 되지 않습니다  <span class="bclick">▼</span> 
		      </div>
		      <div class="btext">
		        <div class="btext1">
		       <br><br>
		          결제카드 등록이 불가능한 경우 하기 내용을 확인 부탁드리며 <br>
                             위와 같은 정보 이력 시 정상적으로 등록이 가능합니다.<br><br><br>
                              연락주시면 빠르게 확인하여 도움드릴 수 있도록 하겠습니다. <br><br>

                  * 도난/분실카드 여부 확인 <br>
                  * 한도/잔고부족 상태 확인<br>
                  * 다른 카드로 등록 시도 시 동일증상 발생여부<br><br>
                                개인정보 강화를 위해 예약 시 본인 정보를 인증하고 있습니다.<br>
 
                                          명의도용 방지를 위해 가입자와<Br>
                                        동일한 명의로 된 결제 카드(신용/체크)만 등록이 가능합니다.<Br>
                  (기존에 등록한 타인 명의 카드는 사용가능)<Br><br><Br>

                                    번거로우시겠지만 회원님의 <Br>
                                자산과 정보를 보호하기 위함이니 양해 부탁드립니다. 
		         
		        </div>
		      </div>
		      
		      
		      <div id="c"><br>
		      <img src="./resources/images/nt/qna.png" height="60" width="70">
		                                             면허 등록이 되지 않습니다. <span class="cclick">▼</span> </div>
		                                             
		       <div class="ctext">
		         <div class="ctext1">
		           <br><br>
		           2014년 7월 이후 신규 발급 된 면허의 경우  <br>
                                                      면허지역이 한글이 아닌 지역코드(숫자2자리)로 표기되어 있습니다.<br><br><Br>


                                                         면허번호 기입 란에는 그 외에 10자리만 기재해주시면 됩니다.  
		           
		         </div>
		       </div>
		     
		      <div id="d"><br>
		      <img src="./resources/images/nt/qna.png" height="60" width="70">
		                                              회원 탈퇴에 방법에 대해 알려주세요  <span class="dclick">▼</span>  </div> 
		       <div class="dtext">
		         <div class="dtext1">
		          <Br><Br>
		              회원 탈퇴 방법은 아래와 같습니다.<br><br>
              1. KHCC 회원 <BR>
                                               ▶ 회원탈퇴(홈페이지): KHCC 홈페이지 > 마이페이지 > 회원탈퇴 <br><br><br>

                                                     ※ 탈퇴 전 유의사항<br><br>
                     1) 회원 탈퇴를 신청하시면 <br>
                                                해당 아이디는 영구적으로 사용이 중지됩니다. <br>
                     2) 보유 포인트 및 쿠폰 소멸 <br>
                         -  탈퇴와 함께 미사용 쿠폰과 포인트는 소멸되며, <br>
                                                                재가입 시에도 복원되지 않습니다.    <br><br><Br>
                    
                     -  탈퇴회원 회원정보 보존기간  <br><br>

 
                                        ㅇ 소비자보호에 관한 법률  <br><br><br>
                                                      제6조(거래기록의 보전 등) 및 동법 시행령 제6조에 의거 <Br>
                                                 아래 정보들은 일정 기간 동안 보관됩니다.<Br><br>

                     1. 회사 내부 방침에 의한 정보보유 사유 부정 이용기록<Br>
                       -  보존 이유 : 부정 이용 방지(재가입 방지) <br>
                          -  보존 기간 : 3년  <br><Br>

                        2. 관련법령에 따른 정보보유 <Br>
                           -  표시/광고에 관한 기록 : 6개월 <Br>
                           (전자상거래 등에서의 소비자보호에 관한 법률)<br>
                               -  계약 또는 청약철회 등에 관한 기록 : 5년 <Br>
                             (전자상거래 등에서의 소비자보호에 관한 법률) <br>
                              -  대금결제 및 재화 등의 공급에 관한 기록 : 5년  <br>
                             (전자상거래 등에서의 소비자보호에 관한 법률)  <br>
                              -  소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 <Br>
                              (전자상거래 등에서의 소비자보호에 관한 법률)  <Br>
                            -  신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년  <Br>
                               (신용정보의 이용 및 보호에 관한 법률) <br>
		         
		         </div>
		       </div>
		       
</body>
</html>