<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<title>TreeTable</title>  
  
<link href="/rw_shop/static/treetable/jquery.treetable.theme.default.css" rel="stylesheet"  
    type="text/css" />  
<link href="/rw_shop/static/treetable/jquery.treetable.css" rel="stylesheet" type="text/css" />  
<script src="/rw_shop/static/js/jquery.min.js"></script>  
<script src="/rw_shop/static/treetable/jquery.treetable.js"></script>  
  
  
</head>  
<body>
	<form action="" method="post">
		<table id="example-advanced">
			<thead>
				<tr>
					<th>菜单名称</th>
					<th>链接地址</th>
					<th>菜单类型</th>
					<th>是否显示</th>
					<th>排序</th>
					<th>权限标志</th>
				</tr>
			</thead>
			
					 <tr data-tt-id="1" > 
		 <td>系统管理</td> 
		 <td>null</td> 
		 <td>导航菜单</td> 
		 <td>是</td> 
		 <td>1</td> 
		 <td>null</td> 
	 </tr> 
	 <tr data-tt-id="1-1"  data-tt-parent-id="1"> 
		 <td>菜单管理</td> 
		 <td>/admin/menu/search.action</td> 
		 <td>导航菜单</td> 
		 <td>是</td> 
		 <td>1</td> 
		 <td>admin:menu:search</td> 
	 </tr> 
	 <tr data-tt-id="1-1-1"  data-tt-parent-id="1-1"> 
		 <td>新增菜单</td> 
		 <td>null</td> 
		 <td>按钮</td> 
		 <td>否</td> 
		 <td>0</td> 
		 <td>admin:menu:add</td> 
	 </tr> 
	 <tr data-tt-id="1-1-2"  data-tt-parent-id="1-1"> 
		 <td>编辑菜单</td> 
		 <td>null</td> 
		 <td>按钮</td> 
		 <td>否</td> 
		 <td>0</td> 
		 <td>admin:menu:edit</td> 
	 </tr> 
	 <tr data-tt-id="1-2"  data-tt-parent-id="1"> 
		 <td>角色管理</td> 
		 <td>/admin/role/search.action</td> 
		 <td>导航菜单</td> 
		 <td>是</td> 
		 <td>1</td> 
		 <td>admin:role:search</td> 
	 </tr> 
	 <tr data-tt-id="1-2-1"  data-tt-parent-id="1-2"> 
		 <td>新增角色</td> 
		 <td>null</td> 
		 <td>按钮</td> 
		 <td>否</td> 
		 <td>0</td> 
		 <td>admin:role:add</td> 
	 </tr> 
	 <tr data-tt-id="1-2-2"  data-tt-parent-id="1-2"> 
		 <td>编辑角色</td> 
		 <td>null</td> 
		 <td>按钮</td> 
		 <td>否</td> 
		 <td>0</td> 
		 <td>admin:role:edit</td> 
	 </tr> 
	 <tr data-tt-id="2" > 
		 <td>test</td> 
		 <td>22</td> 
		 <td>导航菜单</td> 
		 <td>是</td> 
		 <td>1</td> 
		 <td>null</td> 
	 </tr> 

			
		</table>
	</form>
	<script>  
        $("#example-advanced").treetable({  
            expandable : true  
        });  
    </script>  
</body>  
</html>  