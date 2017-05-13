$(document).ready(function(e) {
	//Changing padding dynamically to match the navbar height
	var h = $('nav').height() + 20;
	
	
	$('body').animate({
		paddingTop : h
	});
});
