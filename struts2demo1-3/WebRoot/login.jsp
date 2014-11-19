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
  <form action="login.action">
    
    	用户名：<input type="text"  name="user.username"/><br/>
    	密码：<input type="password"  name="user.password"/><br/>
    <input type="submit" value="提交"/>
  </form>
  
  <h1>${message}</h1>
  
  <h1>**************************************</h1>
  
  <s:form action="login">
  <s:textfield label="用户名" name="user.username" ></s:textfield>
  <s:password  label="密码" name="user.password"></s:password>
  <s:submit value="提交"></s:submit>
  </s:form>
  <h1><s:property value="message"/></h1>
  
  
  
  
  
   
  </body>
</html>
