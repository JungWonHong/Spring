		$(document).ready(function(){
			$(function(){
				$('#rc_sal').keyup(function(){
		                  if(!$.isNumeric($('#rc_sal').val())) {
		                     alert('숫자로 입력하세요.');
		                     $('#rc_sal').val('');
		                     $('#rc_sal').focus();
		                  }
		            });
				
				
				$("#addrecruit").click(function(){
					if($.trim($("#rc_company").val())==""){
						alert("기업명을 입력하세요");
						$("#rc_company").focus();
						return false;
					}
					
					if($("#rc_hirekind").val()==""){
						alert("고용형태를 선택하세요");
						$("#rc_hirekind").focus();
						return false;
					}
					
					if($("#rc_career").val()==""){
						alert("경력여부를 선택하세요");
						$("#rc_career").focus();
						return false;
					}
					
					if($.trim($("#rc_sal").val())==""){
						alert("급여를 입력하세요");
						$("#rc_sal").focus();
						return false;
					}
					
					if($.trim($("#rc_ability").val())==""){
						alert("채용분야를 입력하세요");
						$("#rc_ability").focus();
						return false;
					}
					
					if($.trim($("#rc_worktime").val())==""){
						alert("근로시간을 입력하세요");
						$("#rc_worktime").focus();
						return false;
					}
					
					if($("#rc_expire").val()==""){
						alert("마감날짜를 선택하세요");
						$("#rc_expire").focus();
						return false;
					}
					
					if($.trim($("#rc_title").val())==""){
						alert("제목을 입력하세요");
						$("#rc_title").focus();
						return false;
					}
				});
			});
		})