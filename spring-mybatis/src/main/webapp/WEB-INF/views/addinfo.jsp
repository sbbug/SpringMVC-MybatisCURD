<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
<style>
   #main{
       height:0;
       padding-bottom:30%;
       padding-left:30%;
       padding-right:30%;
       padding-top:20%;
   }
</style>
</head>
<body>
      <div id="main">
        <center>
                <form class="form-horizontal" action="http://127.0.0.1:8080/spring-mybatis/teacher/addinfo" method="post"> 
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">教师名字</label>
					    <div class="col-sm-10">
					      <input type="text" name = "name" class="form-control" id="inputEmail3" value="${teacher.name}">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					    <div class="col-sm-10">
					      <input type="text" name = "password" class="form-control" id="inputPassword3" value="${teacher.password}">
					    </div>
					  </div>
					      <input type="hidden" name="id" value="${teacher.id}">
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-info">添加</button>
					    </div>
					  </div>
          </form>      
        </center>
   </div>             
</body>
</html>