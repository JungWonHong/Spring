$(document).ready(function(){
	
	//ID중복검사 부분
	$('#idcheck').click(function(){
		if($.trim($('#id').val()) == ''){
			alert('ID를 입력 하세요');
			$('#id').focus();
			return false;
		} else {
			var ref = 'idcheck.html';
			window.open(ref, 'idcheck', 'width=350, height=200');
		}
	});
	
	//우편검색 버튼 부분
	$('#postcode').click(function(){
		window.open('post.html', 'post', 'width=400, height=500, scrollbars=yes');
	});
	
	//도메인 선택 부분
	$('#sel').change(function(){
		if($('#sel').val() == ''){ //직접입력 선택한 경우
			$('#domain').val('').focus();
			$('#domain').attr('disabled', false); //활성화
		} else {
			$('#domain').val($('#sel').val());
			$('#domain').attr('disabled', 'disabled'); //비활성화
		}
	});
	
	//주민번호 뒷자리로 포커스 이동
	$('#jumin1').keyup(function(){
		if($('#jumin1').val().length == 6){
			if($.isNumeric($('#jumin1').val())){
				$('#jumin2').focus();
			} else {
				alert('숫자로 입력하세요.');
				$('#jumin1').val('');
				$('#jumin1').focus();
			}
		}
	});
	
	$('#jumin2').keyup(function(){
		if($('#jumin2').val().length == 7){
			if(!$.isNumeric($('#jumin2').val())){
				alert('숫자로 입력하세요.');
				$('#jumin2').val('');
				$('#jumin2').focus();
			}
		}
	});
	
	//회원가입 버튼 클릭할때 이벤트 처리 부분
	$('form').submit(function(){
		if($.trim($('#id').val()) == ''){
			alert('ID를 입력 하세요');
			$('#id').focus();
			return false;
		}
		
		if($.trim($('#pass').val()) == ''){
			alert('비밀번호를 입력 하세요');
			$('#pass').focus();
			return false;
		}
		
		if($.trim($('#jumin1').val()) == ''){
			alert('주민번호 앞자리를 입력 하세요');
			$('#jumin1').focus();
			return false;
		}
		
		if($.trim($('#jumin1').val().length) != 6){
			alert('주민번호 앞자리 6자리를 입력하세요');
			$('#jumin1').val('');
			$('#jumin1').focus();
			return false;
		}
		
		if(!$.isNumeric($('#jumin1').val())){
			alert("주민번호 앞자리는 숫자만 입력 가능합니다.");
			$('#jumin1').val('');
			$('#jumin1').focus();
			return false;
		}
		
		if($.trim($('#jumin2').val()) == ''){
			alert('주민번호 뒷자리를 입력 하세요');
			$('#jumin2').focus();
			return false;
		}
		
		if($.trim($('#jumin2').val().length) != 7){
			alert('주민번호 뒷자리 7자리를 입력하세요');
			$('#jumin2').val('');
			$('#jumin2').focus();
			return false;
		}
		
		if(!$.isNumeric($('#jumin2').val())){
			alert("주민번호 뒷자리는 숫자만 입력 가능합니다.");
			$('#jumin2').val('');
			$('#jumin2').focus();
			return false;
		}
		
		if($.trim($('#email').val()) == ''){
			alert("E-Mail id를 입력 하세요");
			$('#email').focus();
			return false;
		}
		
		if($.trim($('#domain').val()) == ''){
			alert("E-Mail 도메인을 입력 하세요");
			$('#domain').focus();
			return false;
		}
		
		//방법1
		var gender1 = $('#gender1').is(':checked');
		var gender2 = $('#gender2').is(':checked'); 
		if(gender1 == false && gender2 == false){
			alert("남, 여 중에서 1개를 선택 하세요.");
			return false;
		}
		
	    //방법2.
/*	    if(!$('#gender1').is(':checked') && !$('#gender2').is(':checked')){
	    	alert('남, 여 중에서 1개를 선택하세요');
	        return false;
	    }*/
		
		var cnt = 0;
		//방법1
/*		if($("#hobby1").is(":checked"))
			cnt++;
		if($("#hobby2").is(":checked"))
			cnt++;
		if($("#hobby3").is(":checked"))
			cnt++;
		if($("#hobby4").is(":checked"))
			cnt++;
		if($("#hobby5").is(":checked"))
			cnt++;*/
			   
		//방법2
		$('input:checkbox').each(function(index) {
			id="#hobby"+index;
			if($(id).is(":checked"))
				cnt++;
		});

		//방법3
/*		for(var i=0; i<5; i++){
			if($('#hobby' + (i+1)).is(':checked'))
				cnt++;
		}*/
		if(cnt<2){
			alert("2개 이상 취미를 선택 하세요.");
			return false;
		}
		
		if($.trim($('#post1').val()) == ''){
			alert("우편번호 앞자리 입력하세요");
			$('#post1').focus();
			return false;
		}
		
		if(!$.isNumeric($('#post1').val())){
			alert('숫자만 입력 가능 합니다.');
			$('#post1').val('');
			$('#post1').focus();
			return false;
		}
		
		if($.trim($('#post2').val()) == ''){
			alert("우편번호 뒷자리 입력하세요");
			$('#post2').focus();
			return false;
		}
		
		if(!$.isNumeric($('#post2').val())){
			alert('숫자만 입력 가능 합니다.');
			$('#post2').val('');
			$('#post2').focus();
			return false;
		}
		
		if($.trim($('#address').val()) == ''){
			alert("주소를 입력하세요");
			$('#address').focus();
			return false;
		}
		
		if($.trim($('#intro').val()) == ''){
			alert("자기소개를 입력하세요");
			$('#intro').focus();
			return false;
		}
		
	})
});