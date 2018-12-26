			$(function(){
				$("form").submit(function(){
					if($("input:text").val()==""){
						alert("아이디를 입력하세요");
						$("input:text").focus();
						return false;
					}
					if($("input:password").val()==""){
						alert("비밀번호를 입력하세요");
						$("input:password").focus();
						return false;
					}
				});
			});