			$(function(){
				$("form").submit(function(){
					if($("input:eq(0)").val()==""){
						alert("이름을 입력하세요");
						$("input:eq(0)").focus();
						return false;
					}
					if($("input:eq(1)").val()==""){
						alert("ID를 입력하세요");
						$("input:eq(1)").focus();
						return false;
					}
				});
			});