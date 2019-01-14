function card_check() {
	if ($.trim($("#cardName").val()) == "") {
		alert("카드 이름을 입력하세요");
		$("#cardName").val("").focus();
		return false;
	}
	if ($.trim($("#cardNum1").val()) == "") {
		alert("카드 번호를 정확히 입력하세요");
		$("#cardNum1").val("").focus();
		return false;
	}
	if ($.trim($("#cardNum2").val()) == "") {
		alert("카드 번호를 정확히 입력하세요");
		$("#cardNum2").val("").focus();
		return false;
	}
	if ($.trim($("#cardNum3").val()) == "") {
		alert("카드 번호를 정확히 입력하세요");
		$("#cardNum3").val("").focus();
		return false;
	}
	if ($.trim($("#cardNum4").val()) == "") {
		alert("카드 번호를 정확히 입력하세요");
		$("#cardNum4").val("").focus();
		return false;
	}
	if ($.trim($("#expiryMonth").val()) == "") {
		alert("유효기간을 입력하세요");
		$("#expiryMonth").val("").focus();
		return false;
	}
	if ($.trim($("#expiryYear").val()) == "") {
		alert("유효기간을 입력하세요");
		$("#expiryYear").val("").focus();
		return false;
	}
	if ($.trim($("#cardbirth").val()) == "") {
		alert("생년월일을 입력하세요");
		$("#cardbirth").val("").focus();
		return false;
	}
	if ($.trim($("#cardpass").val()) == "") {
		alert("비밀번호를 입력하세요");
		$("#cardpass").val("").focus();
		return false;
	}
}