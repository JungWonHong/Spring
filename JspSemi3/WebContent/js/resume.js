$(document).ready(function() {
	$(function() {
		$('#comment').keyup(function() {
			// 남은 글자 수를 구합니다.
			var inputLength = $(this).val().length;
			var cur = inputLength;
			var remain = 500 - inputLength;

			// 문서 객체에 입력합니다.
			$('#remain').html(cur + "/500");

			if (remain <= 0) {
				alert("글자수 초과");
			}
		});

		$("#addResume").click(function() {

			if ($("#comment").val().length < 100) {
				if ($.trim($("#comment").val()).length == 0) {
					alert("입사 후 포부를 작성해주세요")
				} else {
					alert("입사 후 포부는 100 ~ 500자 입니다");
				}
				$("#comment").focus();
				return false;
			}
		});
	});
})