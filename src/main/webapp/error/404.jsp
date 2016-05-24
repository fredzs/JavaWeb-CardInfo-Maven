<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% response.setStatus(404); %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>页面不存在</title>
  <s:include value="/template/_head.jsp" />
</head>
<body>

<s:include value="/template/_banner.jsp" />
<div id="inner">
	<div class="content">
		<h1>对不起，您所访问的页面不存在！o(╯□╰)o</h1>
		<a href="javascript:void(0)" onclick="showes()">查看错误</a>
		<div id="es" class="hidden">${exceptionStack}</div>
	</div>
</div>
<s:include value="/template/_footer.jsp" />
</body>
</html>
