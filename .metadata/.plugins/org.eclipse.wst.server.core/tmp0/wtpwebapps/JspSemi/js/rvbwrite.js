// addboard()�� ȣ��Ǹ� ���� submit �մϴ�.
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
			alert("�������� �Է��ϼ���");
			$("#rv_title").focus();
			return false;
		}

		if ($.trim($("#rv_content").val()) == "") {
			alert("�۳����� �Է��ϼ���");
			$("#rv_content").focus();
			return false;
		}

		if ($.trim($("#score").val()) == "") {
			alert("������ �Է��� �ּ���");
			return false;
		}
	});
});