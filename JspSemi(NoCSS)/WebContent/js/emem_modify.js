		$(document).ready(function(){
			$(function(){
				//ȸ�����Թ�ư Ŭ����
				$("#ememmodify").click(function(){
					if($.trim($("#e_pw").val())==""){
						alert("��й�ȣ�� �Է��ϼ���");
						$("#e_pw").focus();
						return false;
					}
					
					if($("#e_pw").val().length < 8){
						alert("��й�ȣ�� 8�ڸ� �̻��Դϴ�.");
						$('#e_pw').val('');
						$("#e_pw").focus();
						return false;
					}
					
					if($.trim($("#e_pw2").val())==""){
						alert("��й�ȣ�� Ȯ�����ּ���");
						$("#e_pw2").focus();
						return false;
					}
					
					if($.trim($("#e_pw").val()) != $.trim($("#e_pw2").val())){
						alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						$("#e_pw").val('');
						$("#e_pw2").val('');
						$("#e_pw").focus();
						return false;
					}
					
					if($.trim($("#e_pw").val()) == $.trim($("#orig_pw").val())){
						alert("���ο� ��й�ȣ�� �Է��� �ּ���");
						$("#e_pw").val('');
						$("#e_pw2").val('');
						$("#e_pw").focus();
						return false;
					}
				});
			});
		})