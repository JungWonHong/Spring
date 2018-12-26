		$(document).ready(function(){
			$(function(){
				$("a:first-child").click(function(){
					if($.trim($("input:eq(0)").val())==""){
						alert("아이디를 입력하세요");
						$("input:eq(0)").focus();
						return false;
					}
					if($.trim($("input").eq(1).val())==""){
						alert("비밀번호를 입력하세요");
						$("input:eq(1)").focus();
						return false;
					}
					if($.trim($("input").eq(2).val())==""){
						alert("이름을 입력하세요");
						$("input:eq(2)").focus();
						return false;
					}
					if($.trim($("input").eq(3).val())==""){
						alert("나이를 입력하세요");
						$("input:eq(3)").focus();
						return false;
					}
					//슷자인지 검사
					if(!$.isNumeric($("input").eq(3).val())){
						alert("숫자를 입력하세요");
						$("input:eq(3)").val('');
						$("input:eq(3)").focus();
						return false;
						
					}
					if($.trim($("input").eq(6).val())==""){
						alert("이메일을 입력하세요");
						$("input:eq(6)").focus();
						return false;
					}
				});
			});
		})