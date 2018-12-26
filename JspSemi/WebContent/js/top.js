$(function(){
	var topOffset = $('.top').offset();
	$(window).scroll(function(){
		if ($(document).scrollTop() > topOffset.top){
			$('.top').addClass('topFixed');
		} else {
			$('.top').removeClass('topFixed');
		}
	});
});