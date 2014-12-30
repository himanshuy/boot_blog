$(function() {
    $('.header').click(function() {
    	alert($(this).text());
    	var url="/getPostContent/"+$(this).text();
    	alert(url);
    	$.get(url);
    });
});

