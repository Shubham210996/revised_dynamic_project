<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="BootStrap-Bundles/bootstrap.min.css">
<script src="BootStrap-Bundles/bootstrap.bundle.min.js"></script>
<title>Login/Sign Up</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<div class="container">
		<%
			String invalidMessage = (String) request.getAttribute("invalidMessage");
			String logoutMessage = (String) request.getAttribute("logoutMessage");
			String uri = (String) request.getAttribute("uri");
		%>

		<form action="LoginCtl" method="post" style="padding-top: 0px;">
			<h1 align="center" style="color: darkblue;">Login or Sign Up
				here</h1>
			<input type="hidden" name="uri" value="<%=uri%>">
			<%
				if (logoutMessage != null) {
			%>
			<!-- <h5 style="color: red" align="center"><%=logoutMessage%></h5> -->
			<script type="text/javascript">alert("<%=logoutMessage%>");
			</script>
			<%
				}
			%>
			<fieldset
				style="background-color: yellow; margin-top: 20px; margin-left: 330px; border: groove; border-color: yellow; height: 170px; width: 455px; padding-top: 20px;">
				<table align="center">
					<tr>
						<th>Login ID :</th>
						<td><input type="text" name="loginId"
							placeholder="Enter your email id"></td>
					</tr>
					<tr>
						<th>Password :</th>
						<td><input type="password" name="password"
							placeholder="Enter your password"></td>
					</tr>
				</table>
				<br> <input
					style="margin-left: 150px; color: white; background-color: blue;"
					type="submit" name="Operation" value="Login"> <input
					style="margin-left: 20px; color: white; background-color: blue;"
					type="submit" name="Operation" value="Sign up">
			</fieldset>
		</form>
		<%
			if (invalidMessage != null) {
		%>
		<br>
		<h5 style="color: red" align="center"><%=invalidMessage%></h5>
		<%
			}
		%>
	</div>
</body>
</html>