<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息</title>
<jsp:include page="../common/include_css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/css/style.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/datetimepicker/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/datetimepicker/css/bootstrap-datetimepicker.min.css" />

<jsp:include page="../common/include_js.jsp"></jsp:include>


<!-- 分页 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/pageUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/permission/admin.js"></script>

</head>
<body data-url="${pageContext.request.contextPath}">
	<form action="" method="post">
		<div class="navbar">
			<b>权限设置</b>>管理员信息
		</div>
		<div>
			<b>根据角色查询：</b> <select name="roleId">
				<option value="">全部</option>
				<c:forEach items="${roles}" var="role">

					<option <c:if test="${param.roleId==role.roleId }">selected</c:if>
						value="${role.roleId}">${role.roleName}</option>
				</c:forEach>
			</select>
			<button type="submit">查询</button>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>管理员编号</th>
					<th>登录名</th>
					<th>登录密码</th>
					<th>角色名称</th>
					<th>最后登录时间</th>
					<th>最后登录IP地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paging.data}" var="p">
					<tr>
						<td>${p.adminId}</td>
						<td>${p.loginName}</td>
						<td>${p.loginPwd}</td>
						<td>${p.role.roleName}</td>
						<td>${p.lastLoginTime}</td>
						<td>${p.lastLoginIP}</td>
						<td>${p.state}</td>
						<td><a href="javascript:void(0)" onclick="edit(this)">编辑</a>
							<a href="javascript:void(0)" onclick="deleteAdmin(this)">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="nav">${paging.createNavigatePost}</div>
	</form>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="adminModal" tabindex="-1" role="dialog"
		aria-labelledby="permissionModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="permissionModalLabel">修改管理员信息</h4>
				</div>
				<div class="modal-body">
					<!-- context -->
					<form method="post" id="fm">
						<div class="form-group">
							<label class="col-lg-3 control-label">登录名</label>
							<div class="col-lg-5">
								<input type="text" class="form-control" name="loginName"
									id="loginName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-3 control-label">登录密码</label>
							<div class="col-lg-5">
								<input type="password" class="form-control" name="loginPwd"
									id="loginPwd"  />
							</div>
						</div>

						<div class="form-group">
							<label class="col-lg-3 control-label">确认登录密码</label>
							<div class="col-lg-5">
								<input type="password" class="form-control"
									name="confirmPassword" id="confirmPassword" />
							</div>
						</div>
						<label for="roleId">所属角色</label> <select class="form-control"
							name="roleId" id="roleId" style="display: inline; width: auto">

							<c:forEach items="${roles}" var="role">
								<option value="${role.roleId}">${role.roleName}</option>
							</c:forEach>
						</select> <br /> <label for="lastLoginTime">最后登录时间:</label><input size="16"
							type="text" value="2012-06-15 14:45" readonly
							class="form_datetime" id="lastLoginTime" name="lastLoginTime">
						<div class="input-group">
							<span class="input-group-addon">最后登录IP</span> <input type="text"
								class="form-control" placeholder="ip" name="lastLoginIp"
								id="lastLoginIp">
						</div>

						<label for="state">账号状态</label> <select class="form-control"
							name="state" id="state" style="display: inline; width: auto">
							<option value="1" id="state1">启用</option>
							<option value="0" id="state0">禁用</option>
						</select>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="save()">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>