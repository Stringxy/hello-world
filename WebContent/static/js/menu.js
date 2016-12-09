var submenuHeight=0; //子菜单的高度
$(function(){
	
	
	$(".first>li").click(function(){
		var obj=$(this).find("ul").is(":hidden");
		var liObj=$(this);
		if(obj){
			$(this).find("ul").slideDown("slow",function(){
				submenuHeight=liObj.find("ul").height();
				changeFrameHeight();
				$(this).parent().toggleClass('open');
			});
		}else{

			$(this).find("ul").slideUp("slow",function(){
				$(this).parent().removeClass('open');
				submenuHeight=liObj.find("ul").height();
				changeFrameHeight();
			});
		}
	});
});

function changeFrameHeight(){
	var headerHeight=$(".header").height();
	var screenHeight=$(window).height()-headerHeight;
	var menuHeight=$(".leftmenu").height()+submenuHeight;
	var iframeContentHeight=$("#mainFrame").contents().find("body").height();
	var maxHeight=Math.max(screenHeight,menuHeight,iframeContentHeight);
	$("#mainFrame").height(maxHeight);
	$(".leftmenu").height(maxHeight);
	submenuHeight=0;
}

function aAutoHeight(){
	var menuHeight=$(".leftmenu").height();
	var iframeContentHeight=$("#mainFrame").contents().find("body").height();
    var maxHeight=Math.max(menuHeight,iframeContentHeight);
    //设定iframe高度
    $("#mainFrame").height(maxHeight);
    //设定菜单高度
    $(".leftmenu").height(maxHeight);
}