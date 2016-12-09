var roleid;
function getPermission(obj){
	var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
	roleid=$(obj).parent().parent().children().eq(0).text();
	$.ajax({
		type:"GET",
		url:$("body").attr("data-url")+"/permission/Menu!getTree.action",
		dataType:"json",
		data:"roleid="+roleid,
		success:function(data){
			$.fn.zTree.init($("#treeDemo"), setting, data);
		}
	});
	console.log(roleid);
	$("#permissionModal").modal('show');
	
}

function edit(){
	$("#permissionModal").modal('show');
	
}

function save(){ 
	var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
    nodes=treeObj.getChangeCheckedNodes(true);
    var v="[";
    for(var i=0;i<nodes.length;i++){
    	v+="{id:"+nodes[i].id+"}";
    	if(i==(nodes.length-1)){
    		v+="]";
    	}else{
    		v+=",";
    	}
    }
    console.log(v);
	$.ajax({
		cache: true,
		type: "POST",
		url:$("body").attr("data-url")+"/permission/Role!setPermission.action",
		data:"jsonArray="+v+"&roleid="+roleid,
		async: false,
		error: function(request) {
			alert("失败！");
		},
		success: function(data) {
			alert("成功！");
			 location.reload();
		}
	});

}