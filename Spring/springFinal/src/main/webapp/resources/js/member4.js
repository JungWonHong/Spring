 function check(){
	 if($.trim($("#m_email").val())==""){
		 alert("메일 아이디를 입력하세요");
		 $("#join_mailid").val("").focus();
		 return false;
	 }
	 if($.trim($("#m_maildomain").val())==""){
		 alert("메일 주소를 입력하세요");
		 $("#join_maildomain").val("").focus();
		 return false;
	 }	
	 if($.trim($("#m_pwd1").val())==""){
		 alert("비밀번호를 입력하세요");
		 $("#m_pwd1").val("").focus();
		 return false;
	 }
	 if($.trim($("#m_pwd2").val())==""){
		 alert("비밀번호 확인을 입력하세요");
		 $("#m_pwd2").val("").focus();
		 return false;
	 }
	 if($.trim($("#m_birth").val())==""){
		 alert("생년월일을 입력하세요");
		 $("#m_birth").val("").focus();
		 return false;
	 }
	 if($.trim($("#m_pwd1").val()) != $.trim($("#m_pwd2").val())){
		 //!=같지않다 연산. 비번이 다를 경우
		 alert("입력한 비밀번호가 다릅니다!");
		 $("#m_pwd1").val("");
		 $("#m_pwd2").val("");
		 $("#m_pwd1").focus();
		 return false;
	 }
	 if($.trim($("#m_name").val())==""){
		 alert("회원이름을 입력하세요!");
		 $("#m_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#m_phone2").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#join_phone2").val("").focus();
		 return false;
	 }
	 if($.trim($("#m_phone3").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#join_phone3").val("").focus();
		 return false;
	 } 	 
 }
 
function post_search(){
	alert("우편번호 검색 버튼을 클릭하세요!");
}

function post_check(){
	window.open("zipcode_find.nhn","우편번호검색",
			     "width=420,height=200,scrollbars=yes");
	//폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

/* 아이디 중복 체크*/
function id_check(){
	
	$("#idcheck").hide();//idcheck span 아이디 영역을 숨긴다.
	
	var memid=$("#m_email").val();
	
	//1.입력글자 길이 체크
	if($.trim($("#m_email").val()).length < 4){
		var newtext='<font color="red">아이디는 4자 이상이어야 합니다.</font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
		$("#m_email").val("").focus();
		return false;
	};
	
	if($.trim($("#m_email").val()).length > 12){
		var newtext='<font color="red">아이디는 12자 이하이어야 합니다.</font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
		$("#m_email").val("").focus();
		return false;
	};
	
	//입력아이디 패턴 유효성 검사
	if(!(validate_userid(memid))){		
		var newtext='<font color="red">아이디는 영문소문자, 숫자, _ 조합만 가능합니다.</font>';
		$("#idcheck").text('');//문자 초기화
		$("#idcheck").show();//span 아이디 영역을 보이게 한다.
		$("#idcheck").append(newtext);
		$("#m_email").val("").focus();
		return false;
	};
	
	function validate_userid(memid)
	{ /* 
	     /^[a-z0-9_]+$/  : 영문 소문자,숫자 ,_ 가능한 정규표현식
	     1. /   : 시작과 끝에 붙입니다.
	     2. ^   : 문자열의 시작을 의미합니다.
	     3. a-z : 영어 소문자 a부터 z까지
	     4. 0-9 : 숫자 0부터 9까지
	     5.   + : 앞의 문자나 부분식을 1개 이상 찾습니다. 
	     6.   $ : 문자열의 끝을 의미합니다. 
	     
	          예)/^[a-z0-9_-]{3,16}$/
	       / : 시작과 끝은 나타납니다.
	               문자열의 시작부분을 찾는 ^ 다음에 소문자(a-z)나 숫자(0-9), 언더스코어(_), 하이픈(-)가 
	               나올 수 있고 {3, 16}은 앞의 캐릭터들( [a-z0-9_-] )이 최소 3개에서 16개 이하로 
	               나와야 하고 문자열의 끝을 의미하는 $가 마지막에 나옵니다
	          예) var pattern = /a/;
	        pattern.test('abcd'); //true
	        pattern.test('bcd');  //false
	   */
	  var pattern = /^[a-z0-9_]+$/;
	  //var pattern= new RegExp(/^[a-z0-9_]+$/);
	  var result = pattern.test(memid);
	  //test 메서드는 문자열 안에 패턴이 있는지 확인하여 있으면 true를, 없으면 false를 반환합니다. 
	  return result;
	};
	
	
	//아이디 중복확인
    $.ajax({
        type:"POST",
        url:"member_idcheck.nhn",
        cache:false,
        data: {"memid" : memid},
        success: function (data) { 
      	  if(data==1){//중복 아이디가 있으면
      		var newtext='<font color="red">중복 아이디입니다.</font>';
      			$("#idcheck").text('');
        		$("#idcheck").show();
        		$("#idcheck").append(newtext);
        		
          		$("#m_email").val('').focus();
          		return false;
      	  }else{//중복아이디가 없으면
      		var newtext='<font color="blue">사용가능한 아이디입니다.</font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append(newtext);
      		$("#mem_pwd").focus();
      	  }  	    	  
        }
        ,
    	  error:function(){
    		  alert("data error" + memid);
    	  }
      });//$.ajax	
};
/*아이디 중복 체크 끝*/


 
function domain_list() {
	
	//selectedIndex속성은 select객체하위의 속성으로서 해당리스트 목록번호를 반환
	 var num = f.mail_list.selectedIndex;
	 
	//num==-1은 해당 리스트목록이 없다
	/*if ( num == -1 ) {
	    return true;
	 }
	*/
	/*리스트에서 직접입력을 선택했을때*/
	 if(f.mail_list.value=="0") // 직접입력
	 {
		//@뒤의 도메인입력란을 공백처리
	    f.m_maildomain.value="";
	    
	    //@뒤의 도메인입력란을 쓰기 가능
	    f.m_maildomain.readOnly=false;
	    
	    //도메인입력란으로 입력대기상태
	    f.m_maildomain.focus();
	}
	 
	 else if(num>=0){ //리스트목록을 선택했을때
		 /* num변수에는 해당리스트 목록번호가 저장되어 있습니다.
		  * 해당리스트 번호의 option value값이 도메인입력란에 선택됩니다.
		  * options속성은 select객체의 속성으로서 해당리스트 번호의 value값을 가져온다
		*/
	     f.m_maildomain.value=f.mail_list.options[num].value;
	
	     f.m_maildomain.readOnly=true;
	 }
 }

/* 휴대폰 번호 변경 창 */
function phone_check() {
	if($.trim($("#new_phone2").val())=="" || $.trim($("#new_phone3").val())==""){
		 alert("휴대폰 번호를 정확히 입력하세요");
		 $("#new_phone2").val("").focus();
		 return false;
	}
}

/* 비밀번호 변경 경고창 */
function pass_check() {
	if($.trim($("#new_pass1").val())==""){
		 alert("새 비밀번호를 입력하세요!");
		 $("#new_pass1").val("").focus();
		 return false;
	}
	if($.trim($("#new_pass2").val())==""){
		 alert("비밀번호 확인을 입력하세요!");
		 $("#new_pass2").val("").focus();
		 return false;
	}
	if($.trim($("#new_pass1").val()) != $.trim($("#new_pass2").val())){
		 //!=같지않다 연산. 비번이 다를 경우
		 alert("비밀번호가 다릅니다!");
		 $("#new_pass1").val("");
		 $("#new_pass2").val("");
		 $("#new_pass1").focus();
		 return false;
	}
}

/* 면허 정보 등록 경고창 */
function dcode_check() {
	if($.trim($("#m_drivercode2").val())==""){
		 alert("빈칸 없이 입력해 주세요");
		 $("#m_drivercode2").val("").focus();
		 return false;
	}
	if($.trim($("#m_drivercode3").val())==""){
		 alert("빈칸 없이 입력해 주세요");
		 $("#m_drivercode3").val("").focus();
		 return false;
	}
	if($.trim($("#m_drivercode4").val())==""){
		 alert("빈칸 없이 입력해 주세요");
		 $("#m_drivercode4").val("").focus();
		 return false;
	}
}

 /* 회원정보 수정 경고창 */
function edit_check(){
	 if($.trim($("#join_name").val())==""){
		 alert("회원이름을 입력하세요!");
		 $("#join_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_zip1").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#join_zip1").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_zip2").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#join_zip2").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_addr1").val())==""){
		 alert("주소를 입력하세요!");
		 $("#join_addr1").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_addr2").val())==""){
		 alert("나머지 주소를 입력하세요!");
		 $("#join_addr2").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_tel2").val())==""){
		 alert("전화번호를 입력하세요!");
		 $("#join_tel2").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_tel3").val())==""){
		 alert("전화번호를 입력하세요!");
		 $("#join_tel3").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_phone2").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#join_phone2").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_phone3").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#join_phone3").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_mailid").val())==""){
		 alert("메일 아이디를 입력하세요!");
		 $("#join_mailid").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_maildomain").val())==""){
		 alert("메일 주소를 입력하세요!");
		 $("#join_maildomain").val("").focus();
		 return false;
	 }	 	 
}

