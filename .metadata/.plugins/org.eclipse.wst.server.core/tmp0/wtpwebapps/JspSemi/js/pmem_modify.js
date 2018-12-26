		$(document).ready(function(){
			$(function(){
				//회원가입버튼 클릭시
				$("#pmemmodify").click(function(){
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
					
					if($.trim($("#p_pw2").val())==""){
						alert("비밀번호를 확인해주세요");
						$("#p_pw2").focus();
						return false;
					}
					
					if($.trim($("#p_pw").val()) != $.trim($("#p_pw2").val())){
						alert("비밀번호가 일치하지 않습니다.");
						$("#p_pw").val('');
						$("#p_pw2").val('');
						$("#p_pw").focus();
						return false;
					}
					
					if($.trim($("#p_pw").val()) == $.trim($("#orig_pw").val())){
						alert("새로운 비밀번호를 입력해 주세요");
						$("#p_pw").val('');
						$("#p_pw2").val('');
						$("#p_pw").focus();
						return false;
					}
				});
			});
		})