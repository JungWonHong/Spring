			$(function(){
				$("form").submit(function(){
					if($("input:text").val()==""){
						alert("���̵� �Է��ϼ���");
						$("input:text").focus();
						return false;
					}
					if($("input:password").val()==""){
						alert("��й�ȣ�� �Է��ϼ���");
						$("input:password").focus();
						return false;
					}
				});
			});