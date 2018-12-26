			$(function(){
				$("form").submit(function(){
					if($("input:eq(0)").val()==""){
						alert("e-mail을 입력하세요");
						$("input:eq(0)").focus();
						return false;
					}
					if($("input:eq(1)").val()==""){
						alert("주소를 입력하세요");
						$("input:eq(1)").focus();
						return false;
					}
					if($("input:eq(2)").val()==""){
						alert("전화번호를 입력하세요");
						$("input:eq(2)").focus();
						return false;
					}
				});
			});