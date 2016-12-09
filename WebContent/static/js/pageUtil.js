$(function(){
	$('#rows').change(function(){
		$("#page").val("1");
		$("form").submit();
	});
	
	$("#mypage a[data-page]").click(function(){

		 $("#page").val( $(this).attr("data-page"));
		$("form").submit();
	});
});