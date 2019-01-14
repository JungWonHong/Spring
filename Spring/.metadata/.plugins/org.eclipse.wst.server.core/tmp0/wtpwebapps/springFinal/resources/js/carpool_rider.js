    var directionsDisplay;
    var directionsService = new google.maps.DirectionsService();
    var map;
 
    //화면에 지도띄우기
    function initialize() {
      directionsDisplay = new google.maps.DirectionsRenderer();
      var seoul = new google.maps.LatLng(37.499215, 127.032675);
      var mapOptions = {
        zoom:14,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: seoul
      }
      map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
      directionsDisplay.setMap(map);
    }
 
    //경로계산
    function calcRoute() {
      var start = document.getElementById('start').value;
      var end = document.getElementById('end').value;
 
      var request = {
          origin:start,
          destination:end,
          travelMode: 'TRANSIT'
      };
      
      directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        } else {
        	alert("요청하신 경로를 찾을 수 없습니다.");
        }
      });
      
    }
    
    google.maps.event.addDomListener(window, 'load', initialize);
    
    //거리계산
    function calcFee(){
    	 var start = document.getElementById('start').value;
         var end = document.getElementById('end').value;
         var date = document.getElementById('date').value;
    	 var service = new google.maps.DistanceMatrixService();
         
         service.getDistanceMatrix(
         		  {
         		    origins: [start],
         		    destinations: [end],
         		    travelMode: 'TRANSIT'
         		  }, callback);
         
         function callback(response, status) {
       	  if (status == 'OK') {
       	    var origins = response.originAddresses;
       	    var destinations = response.destinationAddresses;

       	    for (var i = 0; i < origins.length; i++) {
       	      var results = response.rows[i].elements;
       	      for (var j = 0; j < results.length; j++) {
       	        var element = results[j];
       	        var distance = element.distance.text;
       	        var duration = element.duration.text;
       	        
       	        var from = origins[i];
       	        var to = destinations[j];
       	      }
       	    }
       	    window.open("./rider_add?date=" + date + "&start=" + start 
       	    		+ "&end=" + end + "&duration=" + duration + "&distance=" + distance, 
       	    		"라이더등록", "width=420,height=200,scrollbars=yes")
       	  } else {
       		  alert("에러");
       	  }
       	}
    }
