<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
       padding-left:20%;
       padding-right:20%;
   }
</style>
</head>
<body>

   <div id="main">
       <center>
       <h2>欢迎你</h2>
      
           <table class="table table-condensed">
                <tr class="success">
                    <th>标号</th><th>姓名</th><th>密码</th><th>修改</th><th>删除</th><th>添加</th>
                </tr>
                <!-- 注意forEach中e要大写 --> 
                <c:forEach items = "${teachers}" var = "teacher">
                
                    <tr>
                        <td>${teacher.id}</td> 
                        <td>${teacher.name}</td>
                        <td>${teacher.password}</td>
                        <td><a href="http://127.0.0.1:8080/spring-mybatis/teacher/delete?id=${teacher.id}">删除</a></td> 
                        <td><a href="http://127.0.0.1:8080/spring-mybatis/teacher/find?id=${teacher.id}">修改</a></td> 
                        <td><a href="http://127.0.0.1:8080/spring-mybatis/teacher/add">添加</a></td>
                    </tr>
                    
                </c:forEach>
           
           </table>
         </center>
   </div>      
</body>
</html>