<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭나와</title>
<link rel="shortcut icon" type="resources/admin/image/x-icon" href="resources/css/public/playground_assets/logo.png">
</head>
<body>

	<%@ include file="menubar.jsp" %>

	<br><br>
	<h1 align="center" style="color : red;"><%= errorMsg %></h1>
	
	<%@ include file="../common/footer.jsp"%>
</body>
</html>