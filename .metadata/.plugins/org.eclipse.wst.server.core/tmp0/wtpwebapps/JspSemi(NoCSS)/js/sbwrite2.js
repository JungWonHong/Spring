// addboard()가 호출되면 폼을 submit 합니다.
function addboard() {
	boardform.submit();
}

$(document).ready(function() {
	$('#sbwrite').click(function() {
		if ($.trim($("#sb_title").val()) == "") {
			alert("글제목을 입력하세요");
			$("#sb_title").focus();
			return false;
		}

		if ($.trim($("#sb_content").val()) == "") {
			alert("글내용을 입력하세요");
			$("#sb_content").focus();
			return false;
		}

	})
})