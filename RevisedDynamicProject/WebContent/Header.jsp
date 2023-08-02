<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="BootStrap-Bundles/bootstrap.min.css">
<script src="BootStrap-Bundles/bootstrap.bundle.min.js"></script>
<title>Header Section</title>
<style>
/* Add your CSS styles here for the navbar */
body {
	font-family: Arial, sans-serif;
	margin: 10px;
}

.navbar {
	background-color: #333;
	padding: 10px;
}

.navbar a {
	color: white;
	text-decoration: none;
	padding: 8px 16px;
}

.navbar a:hover {
	background-color: #ddd;
	color: black;
}
</style>
</head>
<body>

	<%
		String name = (String) session.getAttribute("name");
		if (name != null) {
	%>
	<h2>
		Hii
		<%=name%></h2>
	<div class="navbar">
		<div align="left">
			<a href="HeaderCtl?Operation=home">Home</a> <a href="HeaderCtl?Operation=about">About</a> <a
				href="UserListCtl">User List</a> <a href="HeaderCtl?Operation=logout">Logout</a>
			<div class="offset-8"></div>
		</div>
	</div>
	<%
		} else {
	%>
	<h3>Hi, Guest</h3>
	<script type="text/javascript">
		
	</script>
	<div class="navbar">
		<a href="HeaderCtl?Operation=userlogin">Home</a>
		<a href="HeaderCtl?Operation=about">About</a>
		<div class="offset-10"></div>
	</div>
	<%
		}
	%>

</body>
</html>