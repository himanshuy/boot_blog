$(function() {
    $('.header').click(function() {
    	var url="/getPostContent/"+$(this).text();
    	$.get(url);
    });
});

