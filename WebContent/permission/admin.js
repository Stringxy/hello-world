var adminid;
$(function() {
	$('#fm').bootstrapValidator(
			{
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok', // 验证成功显示的图标
					invalid : 'glyphicon glyphicon-remove', // 验证失败图标
					validating : 'glyphicon glyphicon-refresh' // 验证中...
				},
				// 设定要验证的字段
				fields : {

					loginName : {

						validators : {
							// 非空验证
							notEmpty : {
								message : $("#loginName").parent().parent()
										.find("label").html()
										+ '不能为空'
							},
							stringLength : {
								min : 2,
								max : 30,
								message : '登录名的长度在2-30个字符之间'
							},
							remote : {
								url : $("body").attr("data-url")
										+ "/permission/Admin!valid.action",
										data:"adminId="+adminid,
								message : '该用户名已被占用！'
							},
							regexp : {
								regexp : /^[a-zA-Z0-9_\.]+$/,
								message : '用户名只能由字母、数字、数字和下划线组成'
							}

						}
					},
					// 以下可以自己再加东西
					loginPwd : {

						validators : {
							// 非空验证
							notEmpty : {
								message : $("#loginPwd").parent().parent()
										.find("label").html()
										+ '不能为空'
							},
							identical : {
								field : 'confirmPassword',
								message : '确认密码不一致！'
							},
							different : {
								field : 'loginName',
								message : '用户名和密码不能相同！'
							}

						}
					},
					 confirmPassword: {
			                validators: {
			                    notEmpty: {
			                        message: '请再次确认密码！'
			                    },
			                    identical: {
			                        field: 'loginPwd',
			                        message: '确认密码不一致！'
			                    }
			                }
			            }
			            

				}
			});
	$(".form_datetime").datetimepicker({
		format : 'yyyy-mm-dd hh:ii'
	});
});

function edit(obj) {
	adminid = $(obj).parent().parent().children().eq(0).text();
	console.log(adminid);
	$("#adminModal").modal('show');
	var name = $(obj).parent().parent().children().eq(1).text();
	var pwd = $(obj).parent().parent().children().eq(2).text();

	var lastLoginTime = $(obj).parent().parent().children().eq(4).text();
	var lastLoginIp = $(obj).parent().parent().children().eq(5).text();
	var state = $(obj).parent().parent().children().eq(6).text();
	console.log(name)
	console.log(lastLoginTime)
	$("#loginName").attr("value", name);
	$("#loginPwd").attr("value", pwd);
	$("#confirmPassword").attr("value", pwd);
	$("#lastLoginTime").attr("value", lastLoginTime);
	$("#lastLoginIp").attr("value", lastLoginIp);
	if (state == "1") {
		$("#state1").attr("selected", "selected");
	} else {
		$("#state0").attr("selected", "selected");
	}

}

function deleteAdmin(obj) {
	adminid = $(obj).parent().parent().children().eq(0).text();

}

function save(){

	$.ajax({
		cache: true,
		type: "POST",
		url:$("body").attr("data-url")+"/permission/Admin!save.action",
		data:$('#fm').serialize()+"&adminId="+adminid,
		async: false,
		error: function(request) {
			alert("Connection error");
		},
		success: function(json) {
			var result = eval('(' + json + ')');
				if(result.success){
					alert(result.message);
					$('#adminModal').modal('hide');
					location.reload();
				}else{
					alert(result.message);
				}
			
		}
	});

}