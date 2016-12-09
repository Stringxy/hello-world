<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TreeTable</title>
<jsp:include page="../common/include_css.jsp"></jsp:include>

<link
	href="${pageContext.request.contextPath }/static/treetable/jquery.treetable.theme.default.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/static/treetable/jquery.treetable.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/static/js/menudata.js"></script>
<script
	src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath }/static/treetable/jquery.treetable.js"></script>


</head>
<body data-url="${pageContext.request.contextPath}">
	<form action="" method="post">
		<table id="example-advanced">
			<thead>
				<tr>
				<th>菜单编号</th>
					<th>菜单名称</th>
					<th>链接地址</th>
					<th>菜单类型</th>
					<th>是否显示</th>
					<th>排序</th>
					<th>权限标志</th>
					<th>操作</th>
				</tr>
			</thead>

			${table}

		</table>


	</form>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">新增菜单</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			<form action="post" id="fm">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增菜单</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon">菜单名称</span> <input type="text"
							class="form-control" placeholder="menuname" name="menuname" id="menuname">
					</div>
					<div class="input-group">
						<span class="input-group-addon">链接地址</span> <input type="text"
							class="form-control" placeholder="url" name="url" id="url">
					</div>
					<label for="name">上级菜单</label> <select class="form-control" name="parentId" id="parentId">
					<option value="" selected="selected">顶级菜单</option>
					${select}
					</select> 
					<label for="name">菜单类型</label> <select class="form-control" name="menutype" id="menutype">
						<option value="1"  id="type1">导航菜单</option>
						<option value="0" id="type0">按钮</option>
					</select> <label for="name">是否显示</label> <select class="form-control" name="state" id="state">
						<option value="1"  id="state1">显示</option>
						<option value="0" id="state0">隐藏</option>
					</select>
					<div class="input-group">
						<span class="input-group-addon">排序</span> <input type="text"
							class="form-control" placeholder="sort" name="sortno" id="sortno">
					</div>
					<div class="input-group">
						<span class="input-group-addon">权限标志</span> <input type="text"
							class="form-control" placeholder="perm" name="perms" id="perms">
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" onclick="close()">取消</button>
					<button type="button" class="btn btn-primary" onclick="save()">保存</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		$("#example-advanced").treetable({
			expandable : true
		});
	</script>
</body>
</html>
