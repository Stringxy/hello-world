<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="UTF-8">

<title>menu</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Iconos -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="menu clearfix">
		<ul id="accordion" class="first">
			<li>
				<div class="link">
					用户数据管理<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="#">平台用户管理</a></li>
					<li><a href="#">收货地址管理</a></li>
					<li><a href="#">系统提示信息</a></li>

				</ul>
			</li>
			<li>
				<div class="link">
					商品数据管理<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="#">商品分类管理</a></li>
					<li><a href="#">商品属性管理</a></li>
					<li><a href="#">商品相册管理</a></li>
				</ul>
			</li>
			<li>
				<div class="link">
					商城设置<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="#">商城基础设置</a></li>
					<li><a href="#">商城广告设置</a></li>
					<li><a href="#">商城配送方式</a></li>
					<li><a href="#">城市地址管理</a></li>
				</ul>
			</li>
			<li><div class="link">
					购物车数据管理<i class="fa fa-chevron-down"></i>
				</div></li>

			<li><div class="link">
					订单数据管理<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="#">订单基础信息</a></li>
					<li><a href="#">订单商品信息</a></li>
					<li><a href="#">订单处理信息</a></li>
					<li><a href="#">退货/取消订单</a></li>
				</ul></li>
			<li><div class="link">
					兑换卡数据管理<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="#">兑换卡信息</a></li>
				</ul></li>
			<li><div class="link">
					商城固定模板<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="#">固定模板基础信息</a></li>
					<li><a href="#">模板商品</a></li>

				</ul></li>
				<shiro:hasRole name="管理员">
			<li><div class="link">
					权限设置<i class="fa fa-chevron-down"></i>
				</div>
				<ul class="submenu">
					<li><a href="${pageContext.request.contextPath }/permission/Admin!search.action" target="mainFrame">管理员信息</a></li>
					<li><a href="${pageContext.request.contextPath }/permission/Role!search.action" target="mainFrame">角色管理</a></li>
<shiro:hasPermission name="admin:menu:*"><li><a href="${pageContext.request.contextPath }/permission/Menu!search.action" target="mainFrame">菜单管理</a></li></shiro:hasPermission>
<li><a href="${pageContext.request.contextPath }/permission/Upload!search.action" target="mainFrame">excel导入数据库</a></li>
				</ul></li></shiro:hasRole>
		</ul>
		<script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
	</div>

</body>

</html>