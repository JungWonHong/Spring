		$(document).ready(function(){
			$(function(){
				//ȸ�����Թ�ư Ŭ����
				$("#pmemmodify").click(function(){
					if($.trim($("#p_pw").val())==""){
						alert("��й�ȣ�� �Է��ϼ���");
						$("#p_pw").focus();
						return false;
					}
					
					if($("#p_pw").val().length < 8){
						alert("��й�ȣ�� 8�ڸ� �̻��Դϴ�.");
						$('#p_pw').val('');
						$("#p_pw").focus();
						return false;
					}
					
					if($.trim($("#p_pw2").val())==""){
						alert("��й�ȣ�� Ȯ�����ּ���");
						$("#p_pw2").focus();
						return false;
					}
					
					if($.trim($("#p_pw").val()) != $.trim($("#p_pw2").val())){
						alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						$("#p_pw").val('');
						$("#p_pw2").val('');
						$("#p_pw").focus();
						return false;
					}
					
					if($.trim($("#p_pw").val()) == $.trim($("#orig_pw").val())){
						alert("���ο� ��й�ȣ�� �Է��� �ּ���");
						$("#p_pw").val('');
						$("#p_pw2").val('');
						$("#p_pw").focus();
						return false;
					}
				});
			});
		})