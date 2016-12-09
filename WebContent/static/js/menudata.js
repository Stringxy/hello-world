var id;

function edit(obj){
	id=$(obj).parent().parent().children().eq(0).text();
	var name=$(obj).parent().parent().children().eq(1).text();
	var url=$(obj).parent().parent().children().eq(2).text();
	var typename=$(obj).parent().parent().children().eq(3).text();
	var statename=$(obj).parent().parent().children().eq(4).text();
	var sortno=$(obj).parent().parent().children().eq(5).text();
	var perms=$(obj).parent().parent().children().eq(6).text();
	if(typename=="导航菜单"){
		$("#type1").attr("selected","selected");
	}else{
		$("#type0").attr("selected","selected");
	}
	if(statename=="是"){
		$("#state1").attr("selected","selected");
	}else{
		$("#state0").attr("selected","selected");
	}
	$('#menuname').attr('value',name);
	$('#url').attr('value',url);
	$('#sortno').attr('value',sortno);
	$('#perms').attr('value',perms);
	$('#myModal').modal('show');
	
}
function save(){

		$.ajax({
			cache: true,
			type: "POST",
			url:$("body").attr("data-url")+"/permission/Menu!save.action",
			data:$('#fm').serialize()+"&id="+id,
			async: false,
			error: function(request) {
				alert("Connection error");
			},
			success: function(json) {
				var result = eval('(' + json + ')');
					if(result.success){
						alert(result.message);
						$('#myModal').modal('hide');
						location.reload();
					}else{
						alert(result.message);
					}
				
			}
		});

}

function close(){
	$('#myModal').modal('hide');
}