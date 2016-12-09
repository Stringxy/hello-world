<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>excel</title>
<jsp:include page="../common/include_css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/fileinput/css/fileinput.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/fileinput/js/locales/zh.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/fileinput/js/fileinput.min.js"></script>
</head>
<body>

		<div class="navbar">
			<b>权限设置</b>>管理员信息
		</div>
			<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>学生编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
			</thead>

             <!-- 使用循环，来取得requet转发过来的paging对象中的List<T>名data -->
      
			<tbody>
			    <c:forEach items="${students}" var="s">			    
					<tr>
						<td>${s.stuId }</td>
						<td>${s.stuName }</td>
						<td>${s.sex }</td>
						<td>
							<a href="javascript:void(0)" onclick="edit()" >编辑</a>
							
						</td>
					</tr>
				
				 </c:forEach>
				
			</tbody>			

		</table>

<form action="${pageContext.request.contextPath }/permission/Upload.action" method="post" enctype="multipart/form-data">

	
	<label class="control-label">请选择要导入的Excel文件：</label>
<input name="excel" id="input-1a" type="file" class="file" data-show-preview="false">
<input type="submit" value="上传">
${result}
  <s:fielderror></s:fielderror>
</form>
</body>
</html>