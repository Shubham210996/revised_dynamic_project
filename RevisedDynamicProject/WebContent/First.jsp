<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="BootStrap-Bundles/bootstrap.min.css">
<script src="BootStrap-Bundles/bootstrap.bundle.min.js"></script>
<title>First JSP Page</title>
</head>
<body class="container">
<% for(int i=1;i<=5;i++) {%>

<h3><%=i%>&nbsp;&nbsp;Shubham Prajapati's First JSP Page</h3>
<%} %>

</body>
</html>