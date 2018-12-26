<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>CSV 형식의 데이터 가져오기</title>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
		/*
		 * jQuery.get() = $.get()
		 - 서버에 데이터를 HTTP GET방식으로 보내고 서버측 응답을 XML, CSV 형식으로 받습니다.
		 - $.get() 함수를 이용해서 data.csv 파일을 불러옵니다.
		 - $.get() 함수의 첫번째 매개변수에는 서버의 URL 주소를 지정합니다.
		 - $.get() 함수의 두번째 매개변수인 콜백함수를 이용해서 서버에서 보내온 csv 형식의
		       데이터를 input으로 받습니다.
		*/
		$(function(){
			$("button").click(function(){ //버튼을 클릭하면
				$.get("data.csv", function(input){
					//input에는 data.csv의 내용이 들어있습니다.
					
					alert(input);
					
					//한 줄씩 자릅니다.
					input = input.split('\n');
					
					$("pre").empty(); //pre태그 안을 비웁니다.
					
					for(var i=0; i< input.length; i++){
						//쉼표를 기준으로 자릅니다.
						input[i] = input[i].split(',');
						for(var j=0; j< input[i].length; j++){
							input[i][j] = input[i][j].trim();
							$("pre").append(input[i][j] + '\n');
						}
					}
				}); //get end
			});	//click end
		});	//ready end
		</script>
	</head>
	<body>
		<button>데이터 불러오기</button>
		<pre>변경전</pre>
	</body>
</html>