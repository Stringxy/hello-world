<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>后台管理主页面</title>

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/style.css" />
<jsp:include page="common/include_css.jsp"></jsp:include>
<jsp:include page="common/include_js.jsp"></jsp:include>

  <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/menu.js"></script>
</head>
<body>

  
  <div class="crm">
       
       <div class="header">       
          		<h1>欢迎<shiro:principal/>！</h1>
          		  
       </div>
       
       <div class="leftmenu ">
           <div class="clearfix">
               <jsp:include page="common/menu.jsp"></jsp:include>
           </div>
              
       </div>
       
       <div class="content">
          <!-- 必须通过js来自适应高度，否则，奇丑无比 -->
       
           <iframe id="mainFrame" name="mainFrame" scrolling="no" 
                 frameborder="0" 
                 width="100%"
                 height="100%"
                 onload="changeFrameHeight()"
                  ></iframe>		
         		
       </div>
         
    
  </div>

</body>
</html>