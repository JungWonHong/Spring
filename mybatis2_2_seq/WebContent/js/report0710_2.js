			$(function(){
				$("form").submit(function(){
					if($("input:eq(0)").val()==""){
						alert("e-mail�� �Է��ϼ���");
						$("input:eq(0)").focus();
						return false;
					}
					if($("input:eq(1)").val()==""){
						alert("�ּҸ� �Է��ϼ���");
						$("input:eq(1)").focus();
						return false;
					}
					if($("input:eq(2)").val()==""){
						alert("��ȭ��ȣ�� �Է��ϼ���");
						$("input:eq(2)").focus();
						return false;
					}
				});
			});