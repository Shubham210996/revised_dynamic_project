<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="BootStrap-Bundles/bootstrap.min.css">
<script src="BootStrap-Bundles/bootstrap.bundle.min.js"></script>
<title>User Registration</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<br>
<div class="container">
	<form action="UserRegCtl" method="post">
		<h2 style="margin-top: 20px; padding-bottom: 20px; color: blue;"
			align="center">Enter your details here for Registration..!!</h2>
		<table align="center">
			<tr>
				<th>Full Name :</th>
				<td><input type="text" name="name"
					placeholder="Enter your full name"></td>
			</tr>
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
			<tr>
				<th>Confirm Password :</th>
				<td><input type="password" name="confirmPass"
					placeholder="Re-enter your password"></td>
			</tr>
			<tr>
				<th>Contact :</th>
				<td><input type="text" name="contact"
					placeholder="Enter your mobile number"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name ="userreg" value="Sign Up"
					style="margin-left: 30px; margin-top: 10px;"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>