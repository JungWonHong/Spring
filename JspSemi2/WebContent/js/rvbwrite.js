// addboard()가 호출되면 폼을 submit 합니다.
function addboard() {
	boardform.submit();
};

$(document).ready(function() {
	/*
	 * var scoreclick = false; $(".star_rating").click(function(){
	 * scoreclick=true; })
	 */
	$('#rvwrite').click(function() {
		if ($.trim($("#rv_title").val()) == "") {
			alert("글제목을 입력하세요");
			$("#rv_title").focus();
			return false;
		}

		if ($.trim($("#rv_content").val()) == "") {
			alert("글내용을 입력하세요");
			$("#rv_content").focus();
			return false;
		}

		if ($.trim($("#score").val()) == "") {
			alert("평점을 입력해 주세요");
			return false;
		}
	});
});