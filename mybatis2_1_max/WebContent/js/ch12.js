		$(document).ready(function(){
			$(function(){
				$("a:first-child").click(function(){
					if($.trim($("input:eq(0)").val())==""){
						alert("���̵� �Է��ϼ���");
						$("input:eq(0)").focus();
						return false;
					}
					if($.trim($("input").eq(1).val())==""){
						alert("��й�ȣ�� �Է��ϼ���");
						$("input:eq(1)").focus();
						return false;
					}
					if($.trim($("input").eq(2).val())==""){
						alert("�̸��� �Է��ϼ���");
						$("input:eq(2)").focus();
						return false;
					}
					if($.trim($("input").eq(3).val())==""){
						alert("���̸� �Է��ϼ���");
						$("input:eq(3)").focus();
						return false;
					}
					//�������� �˻�
					if(!$.isNumeric($("input").eq(3).val())){
						alert("���ڸ� �Է��ϼ���");
						$("input:eq(3)").val('');
						$("input:eq(3)").focus();
						return false;
						
					}
					if($.trim($("input").eq(6).val())==""){
						alert("�̸����� �Է��ϼ���");
						$("input:eq(6)").focus();
						return false;
					}
				});
			});
		})