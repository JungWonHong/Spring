			$(function(){
				$("form").submit(function(){
					if($("input:eq(0)").val()==""){
						alert("�̸��� �Է��ϼ���");
						$("input:eq(0)").focus();
						return false;
					}
					if($("input:eq(1)").val()==""){
						alert("ID�� �Է��ϼ���");
						$("input:eq(1)").focus();
						return false;
					}
				});
			});