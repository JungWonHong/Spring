			$(function(){
				$("form").submit(function(){
					if($.trim($("#id").val())==""){
						alert("���̵� �Է��ϼ���");
						$("#id").focus();
						return false;
					}
					if($.trim($("#pass").val())==""){
						alert("��й�ȣ�� �Է��ϼ���");
						$("#pass").focus();
						return false;
					}
					if($.trim($("#name").val())==""){
						alert("�̸��� �Է��ϼ���");
						$("#name").focus();
						return false;
					}
					if($.trim($("#age").val())==""){
						alert("���̸� �Է��ϼ���");
						$("#age").focus();
						return false;
					}
					//�������� �˻�
					if(!$.isNumeric($("#age").val())){
						alert("���ڸ� �Է��ϼ���");
						$("#age").val('');
						$("#age").focus();
						return false;
						
					}
					if($.trim($("#email").val())==""){
						alert("�̸����� �Է��ϼ���");
						$("#email").focus();
						return false;
					}
				});
			});