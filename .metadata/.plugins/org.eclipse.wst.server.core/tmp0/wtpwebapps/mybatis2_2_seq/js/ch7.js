			$(function(){
				$("form").submit(function(){
					if($.trim($("#id").val())==""){
						alert("아이디를 입력하세요");
						$("#id").focus();
						return false;
					}
					if($.trim($("#pass").val())==""){
						alert("비밀번호를 입력하세요");
						$("#pass").focus();
						return false;
					}
					if($.trim($("#name").val())==""){
						alert("이름을 입력하세요");
						$("#name").focus();
						return false;
					}
					if($.trim($("#age").val())==""){
						alert("나이를 입력하세요");
						$("#age").focus();
						return false;
					}
					//슷자인지 검사
					if(!$.isNumeric($("#age").val())){
						alert("숫자를 입력하세요");
						$("#age").val('');
						$("#age").focus();
						return false;
						
					}
					if($.trim($("#email").val())==""){
						alert("이메일을 입력하세요");
						$("#email").focus();
						return false;
					}
				});
			});