//addboard()가 호출되면 폼을 submit 합니다.

function addboard() {
	boardform.submit();
}

$(document).ready(function() {
	$("a:first-child").click(function() {
		if ($.trim($("input:eq(0)").val()) == "") {
			alert("글쓴이를 입력하세요");
			$("input:eq(0)").focus();
			return false;
		}
		if ($.trim($("input").eq(1).val()) == "") {
			alert("비밀번호를 입력하세요");
			$("input:eq(1)").focus();
			return false;
		}
		if ($.trim($("input").eq(2).val()) == "") {
			alert("제목을 입력하세요");
			$("input:eq(2)").focus();
			return false;
		}
		if ($.trim($("textarea").val()) == "") {
			alert("내용을 입력하세요");
			$("textarea").focus();
			return false;
		}
	});
})