		$(document).ready(function(){
			$(function(){
				$("#addrecruit").click(function(){
					if($.trim($("#rc_company").val())==""){
						alert("������� �Է��ϼ���");
						$("#rc_company").focus();
						return false;
					}
					
					if($("#rc_hirekind").val()==""){
						alert("������¸� �����ϼ���");
						$("#rc_hirekind").focus();
						return false;
					}
					
					if($("#rc_career").val()==""){
						alert("��¿��θ� �����ϼ���");
						$("#rc_career").focus();
						return false;
					}
					
					if($.trim($("#rc_sal").val())==""){
						alert("�޿��� �Է��ϼ���");
						$("#rc_sal").focus();
						return false;
					}
					
					if($.trim($("#rc_ability").val())==""){
						alert("ä��о߸� �Է��ϼ���");
						$("#rc_ability").focus();
						return false;
					}
					
					if($.trim($("#rc_worktime").val())==""){
						alert("�ٷνð��� �Է��ϼ���");
						$("#rc_worktime").focus();
						return false;
					}
					
					if($("#rc_expire").val()==""){
						alert("������¥�� �����ϼ���");
						$("#rc_expire").focus();
						return false;
					}
					
					if($.trim($("#rc_title").val())==""){
						alert("������ �Է��ϼ���");
						$("#rc_title").focus();
						return false;
					}
				});
			});
		})