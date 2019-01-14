    //검색 유효성검사
    function find_check() {
		if ($.trim($("#find_name").val()) == "") {
			alert("검색이름을 입력하세요!");
			$("#find_name").val("").focus();
			return false;
		}
	}
    
    //드라이버가 카풀 신청시
    function carpool_request() {
    	var num = document.getElementById('cp_num').value;
    	var time = document.getElementById('time').value;
    	var depart = document.getElementById('depart').value;
    	var arrive = document.getElementById('arrive').value;
    	var sum = document.getElementById('sum').value;
    	var distance = document.getElementById('distance').value;
    	var id = document.getElementById('cp_id').value;
    	window.open("./carpool_request?cp_id=" + id +"&cp_num=" + num + "&time=" + time + "&depart=" + depart 
   	    		+ "&arrive=" + arrive + "&sum=" + sum + "&distance=" + distance, 
   	    		"카풀신청", "width=420,height=200,scrollbars=yes,left=400,top=200")
    }
    
    $(document).ready(function(){
    	//리스트 뷰 방식 
    	  $("#viewlist").change(function(){
    		   var type = $(this).val();
    		   $.ajax({
    		    type : "post",
    		    data : {"viewlist" : type},
    		    url : "./cp_list", 
    		    cache: false,  
    		    headers : {"cache-control" : "no-cache", "pragma" : "no-cache"},//요청시 헤더 정보를 추가로 보냅니다.
    		    success : function(data){
    		    	$('body').html(data);
    		    },
    		    error : function(){
    		     alert("에러");
    		    }
    		   })//ajax end
    		  });//change end
    	})//ready end