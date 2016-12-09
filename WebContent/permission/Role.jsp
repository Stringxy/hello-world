<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/zTree/css/zTreeStyle/zTreeStyle.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/zTree/css/demo.css" />
  <jsp:include page="../common/include_css.jsp"></jsp:include>
  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/permission/role.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/static/zTree/js/jquery.ztree.core.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath }/static/zTree/js/jquery.ztree.excheck.js"></script>
	<script
	src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.js"></script>
  <!-- 分页 -->
  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/pageUtil.js"></script>
</head>
<body data-url="${pageContext.request.contextPath}">

<form action="" method="post">
	<div class="navbar">
		<b>权限设置</b>>角色管理
	</div>
			<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>角色编号</th>
					<th>角色名称</th>
					<th>操作</th>
				</tr>
			</thead>

             <!-- 使用循环，来取得requet转发过来的paging对象中的List<T>名data -->
      
			<tbody>
			    <c:forEach items="${paging.data}" var="p">			    
					<tr>
						<td>${p.roleId }</td>
						<td>${p.roleName }</td>
						<td>
							<a href="javascript:void(0)" onclick="edit()" >编辑</a>
							<a href="javascript:void(0)" onclick="getPermission(this)" >分配权限</a>
						</td>
					</tr>
				
				 </c:forEach>
				
			</tbody>			

		</table>
  
       <!-- 显示分页导航条 -->
       ${paging.createNavigatePost }
	
</form>


<!-- 模态框（Modal） -->
<div class="modal fade" id="permissionModal" tabindex="-1" role="dialog" aria-labelledby="permissionModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="permissionModalLabel">分配权限</h4>
            </div>
            <div class="modal-body">
<!-- tree -->
<div class="thetree">
		<ul id="treeDemo" class="ztree"></ul>
	</div>

</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="save()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>