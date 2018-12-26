$(document).ready(function(){
  $("#viewcount").change(function(){

	   var limit = $(this).val();

	   $.ajax({
	    type : "post",
	    data : {"limit" : limit},
	    url : "./BoardList.bo", 
	    cache: false,  //브라우저의 캐시 사용을 막습니다.
	    headers : {"cache-control" : "no-cache", "pragma" : "no-cache"},//요청시 헤더 정보를 추가로 보냅니다.
	    success : function(data){ //data에 결과를 받아옴
	    	$('body').html(data);
	    },
	    error : function(){
	     alert("에러");
	    }
	   })//ajax end
	  });//change end
})//ready end