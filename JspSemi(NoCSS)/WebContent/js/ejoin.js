$(document).ready(function() {
	$(function() {
		// 핸드폰번호 입력 1
		$('#e_hp').keyup(function() {
			if ($('#e_hp').val().length == 3) {
				if ($.isNumeric($('#e_hp').val())) {
					$('#e_hp2').focus();
				} else {
					alert('숫자로 입력하세요.');
					$('#e_hp').val('');
					$('#e_hp').focus();
				}
			}
		});

		// 핸드폰번호 입력 2
		$('#e_hp2').keyup(function() {
			if ($('#e_hp2').val().length == 4) {
				if ($.isNumeric($('#e_hp2').val())) {
					$('#e_hp3').focus();
				} else {
					alert('숫자로 입력하세요.');
					$('#e_hp2').val('');
					$('#e_hp2').focus();
				}
			}
		});

		// 핸드폰번호 입력 3
		$('#e_hp3').keyup(function() {
			if ($('#e_hp3').val().length == 4) {
				if (!$.isNumeric($('#e_hp3').val())) {
					alert('숫자로 입력하세요.');
					$('#e_hp3').val('');
					$('#e_hp3').focus();
				} else {
					$('#email').focus();
				}
			}
		});

		// 도메인 선택 부분
		$('#sel').change(function() {
			if ($('#sel').val() == '') { // 직접입력 선택한 경우
				$('#domain').val('').focus();
				$('#domain').attr('disabled', false); // 활성화
			} else {
				$('#domain').val($('#sel').val());
				$('#domain').attr('disabled', 'disabled'); // 비활성화
			}
		});

		var btnclick = false;
		// 중복검사 버튼 클릭
		$("#memcheck").click(function() {
			btnclick = true;
		});

		// 아이디입력창 건들면
		$("#e_id").keyup(function() {
			btnclick = false;
		});

		// 회원가입버튼 클릭시
		$("#esubmit").click(function() {
			if ($.trim($("#e_memname").val()) == "") {
				alert("이름을 입력하세요");
				$("#e_memname").focus();
				return false;
			}

			if ($.trim($("#e_id").val()) == "") {
				alert("아이디를 입력하세요");
				$("#e_id").focus();
				return false;
			}

			if (!btnclick) {
				alert("ID중복검사를 해주세요");
				return false;
			}

			if ($.trim($("#e_pw1").val()) == "") {
				alert("비밀번호를 입력하세요");
				$("#e_pw1").focus();
				return false;
			}

			if ($("#e_pw1").val().length < 8) {
				alert("비밀번호는 8자리 이상입니다.");
				$('#e_pw1').val('');
				$("#e_pw1").focus();
				return false;
			}

			if ($.trim($("#e_pw2").val()) == "") {
				alert("비밀번호를 확인해주세요");
				$("#e_pw2").focus();
				return false;
			}

			if ($.trim($("#e_pw1").val()) != $.trim($("#e_pw2").val())) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#e_pw1").val('');
				$("#e_pw2").val('');
				$("#e_pw1").focus();
			}

			if ($.trim($("#e_hp").val()) == "" || $.trim($("#e_hp2").val()) || $.trim($("#e_hp3").val())) {
				alert("휴대폰 번호를 입력하세요");
				$("#e_hp").val('');
				$("#e_hp2").val('');
				$("#e_hp3").val('');
				$("#e_hp").focus();
			}
			
			if ($.trim($("#email").val()) == "") {
				alert("E-mail ID를 입력하세요");
				$("#email").focus();
				return false;
			}

			if ($.trim($("#domain").val()) == "") {
				alert("E-mail 도메인 주소를 입력하세요");
				$("#domain").focus();
				return false;
			}

			if ($.trim($("#e_company").val()) == "") {
				alert("회사명을 입력해주세요");
				$("#e_company").focus();
				return false;
			}
		});
	});
})