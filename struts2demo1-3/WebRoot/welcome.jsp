<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   
   <s:debug>调试</s:debug>
     
   <h1>This is Welcome Page</h1>
   
   <h1>${sessionScope.USER},欢迎你的登陆</h1>
   
    <h1>${requestScope.USERNAME},欢迎你的登陆（从request拿出来）</h1>
    
    <h1>${applicationScope.PASSWORD} 从application拿出来）</h1>
    
    <h1>传统方式拿出来值</h1>
      <h1>${sessionScope.USER2},欢迎你的登陆</h1>
      <h1>${requestScope.USERNAME2},欢迎你的登陆（从request拿出来）</h1>
    
    <h1>Struts2 Tag</h1>
    <h1><s:property value="#session.USER.say()"/>,欢迎你的登陆</h1>
    <h1><s:property value="#request.USERNAME"/>,欢迎你的登陆</h1>
    
    <h1><s:property value="#application.PASSWORD"/>,欢迎你的登陆</h1>
    
    
    
    
    
    
  </body>
</html>
