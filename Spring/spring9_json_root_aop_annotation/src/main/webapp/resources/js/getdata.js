$(document).ready(function() {
	// 데이터를 보여주는 함수
	function selectData() {
		// #output 내부의 내용물을 제거합니다.
		$('#output').empty();

		// Ajax를 수행합니다.
		$.getJSON('./jsontest3', function(data) {
			$(data).each(function(index, item) {
				var output = '';
				output += '<tr>';
				output += '	<td>' + item.id + '</td>'; // this.id
				output += '	<td>' + item.name + '</td>';
				output += '	<td>' + item.modelnumber + '</td>';
				output += '	<td>' + item.series + '</td>';
				output += '</tr>'
				$('#output').append(output);
			});
		});// getJSON end
	} // selectData end

	// 초기 화면에 데이터를 표시합니다.
	selectData();

	// 데이터를 추가합니다.
	$('#insert_form').submit(function(event) {
		if ($("#name").val() == "") {
			alert("상품명 입력하세요");
			return false;
		}
		if ($("#modelnumber").val() == "") {
			alert("모델 번호를 입력하세요");
			return false;
		}
		if ($("#series").val() == "") {
			alert("시리즈를 입력하세요");
			return false;
		}

		// 전송할 데이터틀을 직렬화 합니다.
		// 입력 양식에 입력한 데이터를 쿼리 스트링으로 바꿉니다.
		var data = $(this).serialize();

		// Ajax를 수행합니다.
		$.ajax({url : './jsontest2',
				data: data,
				dataType : "json",
				cache:false,
				headers : {"cache-control":"no-cache","pragma":"no-cache"},
				success: function(data) {
					$(data).each(function(index, item) {
						var output = '';
						output += '<tr>';
						output += '	<td>' + item.id + '</td>';
						output += '	<td>' + item.name + '</td>';
						output += '	<td>' + item.modelnumber + '</td>';
						output += '	<td>' + item.series + '</td>';
						output += '</tr>'
						$('#output').append(output);
					})},
				error : function(data){
					alert("오류 발생");
					}
				});

		// 기본 이벤트를 제거합니다.
		event.preventDefault();
	}); // submit end
}); // ready end
