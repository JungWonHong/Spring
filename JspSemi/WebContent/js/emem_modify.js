		$(document).ready(function(){
			$(function(){
				//회원가입버튼 클릭시
				$("#ememmodify").click(function(){
					if($.trim($("#e_pw").val())==""){
						alert("비밀번호를 입력하세요");
						$("#e_pw").focus();
						return false;
					}
					
					if($("#e_pw").val().length < 8){
						alert("비밀번호는 8자리 이상입니다.");
						$('#e_pw').val('');
						$("#e_pw").focus();
						return false;
					}
					
					if($.trim($("#e_pw2").val())==""){
						alert("비밀번호를 확인해주세요");
						$("#e_pw2").focus();
						return false;
					}
					
					if($.trim($("#e_pw").val()) != $.trim($("#e_pw2").val())){
						alert("비밀번호가 일치하지 않습니다.");
						$("#e_pw").val('');
						$("#e_pw2").val('');
						$("#e_pw").focus();
						return false;
					}
					
					if($.trim($("#e_pw").val()) == $.trim($("#orig_pw").val())){
						alert("새로운 비밀번호를 입력해 주세요");
						$("#e_pw").val('');
						$("#e_pw2").val('');
						$("#e_pw").focus();
						return false;
					}
				});
			});
		})