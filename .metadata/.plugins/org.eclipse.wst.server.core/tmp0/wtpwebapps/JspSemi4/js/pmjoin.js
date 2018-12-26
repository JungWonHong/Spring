      $(document).ready(function(){
         $(function(){
            //핸드폰번호 입력 1
            $('#p_hp').keyup(function(){
               if($('#p_hp').val().length == 3){
                  if($.isNumeric($('#p_hp').val())){
                     $('#p_hp2').focus();
                  } else {
                     alert('숫자로 입력하세요.');
                     $('#p_hp').val('');
                     $('#p_hp').focus();
                  }
               }
            });
            
            //핸드폰번호 입력 2
            $('#p_hp2').keyup(function(){
               if($('#p_hp2').val().length == 4){
                  if($.isNumeric($('#p_hp2').val())){
                     $('#p_hp3').focus();
                  } else {
                     alert('숫자로 입력하세요.');
                     $('#p_hp2').val('');
                     $('#p_hp2').focus();
                  }
               }
            });
            
            //핸드폰번호 입력 3
            $('#p_hp3').keyup(function(){
               if($('#p_hp3').val().length == 4){
                  if(!$.isNumeric($('#p_hp3').val())){
                     alert('숫자로 입력하세요.');
                     $('#p_hp3').val('');
                     $('#p_hp3').focus();
                  } else {
                     $('#p_email').focus();
                  }
               }
            });
            
            //도메인 선택 부분
            $('#emailaddr').change(function(){
               if($('#emailaddr').val() == ''){ //직접입력 선택한 경우
                  $('#email_dns').val('').focus();
                  $('#email_dns').attr('disabled', false); //활성화
               } else {
                  $('#email_dns').val($('#emailaddr').val());
                  $('#email_dns').attr('disabled', 'disabled'); //비활성화
               }
            });
            
            var btnclick = false;
            //중복검사 버튼 클릭
            $("#confirm_id").click(function(){
               btnclick = true;
            });
            
            //아이디입력창 건들면
            $("#p_id").keyup(function(){
               btnclick = false;
            });
            
            //회원가입버튼 클릭시
            $("#pjoin").click(function(){
               if($.trim($("#p_name").val())==""){
                  alert("이름을 입력하세요");
                  $("#p_name").focus();
                  return false;
               }
               
               if($.trim($("#p_age").val())==""){
                  alert("나이를 입력하세요");
                  $("#p_age").focus();
                  return false;
               }
               if(!$.isNumeric($("#p_age").val())) {
                  alert("나이는 숫자만 입력 가능합니다.");
                  $("#p_age").val("");
                  $("#p_age").focus();
                  return false;
               }
               
               if($.trim($("#p_id").val())==""){
                  alert("아이디를 입력하세요");
                  $("#p_id").focus();
                  return false;
               }
               
               if(!btnclick){
                   alert("ID중복검사를 해주세요");
                   return false;
                }
               
               if($.trim($("#p_pw").val())==""){
                  alert("비밀번호를 입력하세요");
                  $("#p_pw").focus();
                  return false;
               }
               
               if($("#p_pw").val().length < 8){
                  alert("비밀번호는 8자리 이상입니다.");
                  $('#p_pw').val('');
                  $("#p_pw").focus();
                  return false;
               }
               
               if($.trim($("#pw_check").val())==""){
                  alert("비밀번호를 확인해주세요");
                  $("#pw_check").focus();
                  return false;
               }
               
               if($.trim($("#p_pw").val()) != $.trim($("#pw_check").val())){
                  alert("비밀번호가 일치하지 않습니다.");
                  $("#p_pw").val('');
                  $("#pw_check").val('');
                  $("#p_pw").focus();
               }
               
               if($.trim($("#p_email").val())=="") {
                  alert("E-mail ID를 입력하세요");
                  $("#p_email").focus();
                  return false;
               }
               
               if($.trim($("#email_dns").val())=="") {
                  alert("E-mail 도메인 주소를 입력하세요");
                  $("#email_dns").focus();
                  return false;
               }
               
            });
         });
      })