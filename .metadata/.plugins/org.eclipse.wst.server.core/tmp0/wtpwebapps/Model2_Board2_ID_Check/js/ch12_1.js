$(document).ready(function() {
	// 영역을 숨깁니다.
	$("#result").hide();
	var data_check = -1; //아이디 중복 확인 버튼 클릭 유무를 확인하기 위한 변수
						//DB에 아이디가 없으면(data_check==-1)
	sid=$("#id").val();
	$("a:first-child").click(function() {
		sid2 = $("#id").val(); //사용가능한 아이디인데 변경한 경우를 체크하기 위해 값을 저장힙니다.
		/*
		  1.(data_check==1) : DB에 아이디가 있으면
		  2.(sid != sid2) : 중복 체크 후 사용가능한 아이디라고 메시지 나왔지만
		  					아이디를 변경하고 중복 체크하지 않은 경우
		 */
		if(sid != sid2 || data_check == 1){
			alert("ID중복검사를 해주세요");
			return false;
		}
		
		
		if ($.trim($("input").eq(0).val()) == "") {
			alert("ID를 입력하세요");
			$("input:eq(0)").focus();
			return false;
		}
		if ($.trim($("input").eq(2).val()) == "") {
			alert("비밀번호를 입력하세요");
			$("input:eq(2)").focus();
			return false;
		}
		if ($.trim($("input").eq(3).val()) == "") {
			alert("이름을 입력하세요");
			$("input:eq(3)").focus();
			return false;
		}
		if ($.trim($("input").eq(4).val()) == "") {
			alert("나이를 입력하세요");
			$("input:eq(4)").focus();
			return false;
		}
		if (!$.isNumeric($("input").eq(4).val())) {
			alert("나이는 숫자로 입력하세요");
			$("input:eq(4)").val('');
			$("input:eq(4)").focus();
			return false;
		}

		if ($.trim($("input").eq(7).val()) == "") {
			alert("이메일을 입력하세요");
			$("input:eq(7)").focus();
			return false;
		}
	});

	// id 중복 확인 클릭시
	$("#idcheck").click(function() {
		// id를 입력하지 않은 경우
		if ($.trim($("#id").val()) == "") {
			alert("ID를 입력하세요");
			$("#id").focus();
			return false;
		}

		// 아이디 중복확인 아작스
		sid = $("#id").val();
		$.ajax({
			type : "post",
			url : "Idcheckajax.net",
			data : {
				"id" : sid
			},
			cache : false,
			success : function(data) {
				data_check = data;
				if (data == 1) {// DB에 아이디가 있으면
					// $("#result").text("아이디가 이미 존재합니다.").css("color", "red");
					// $("#result").css("color", "red");
					// $("#result").show();
					var newtext = '중복 아이디입니다.';
					$("#result").text('');
					$("#result").show();
					$("#result").css('color', 'red').append(newtext);
					$("#id").val('').focus();
				} else if (data == -1) {// DB에 아이디가 없으면
					// $("#result").text("아이디 사용 가능합니다.").css("color", "blue");
					// $("#result").show();
					var newtext = '사용가능한 아이디입니다.';
					$("#result").text('');
					$("#result").show();
					$("#result").css('color', 'blue').append(newtext);
					check = true;
				}
			},
			error : function() {
				alert("data error2");
			}
		});// $.ajax
	}); // 아이디 중복체크 end
});// ready() end
