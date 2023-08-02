<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="BootStrap-Bundles/bootstrap.min.css">
<script src="BootStrap-Bundles/bootstrap.bundle.min.js"></script>
<title>Update Profile</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<div class="container">
		<%
			UserBean bean = (UserBean) request.getAttribute("bean");
		%>
		<form action="UpdateUserCtl" method="post">
			<h2 style="margin-top: 20px; padding-bottom: 20px; color: blue;"
				align="center">Update your details here...!!</h2>

			<input type="hidden" name="no" value="<%=bean.getNo()%>">

			<table align="center">
				<tr>
					<th>Full Name :</th>
					<td><input type="text" name="name" value="<%=bean.getName()%>"
						placeholder="Enter your full name"></td>
				</tr>
				<tr>
					<th>Login ID :</th>
					<td><input type="text" name="loginId"
						value="<%=bean.getLoginId()%>" placeholder="Enter your email id"></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"
						value="<%=bean.getPassword()%>" placeholder="Enter your password"></td>
				</tr>
				<tr>
					<th>Confirm Password :</th>
					<td><input type="password" name="confirmPass"
						value="<%=bean.getConfirmPass()%>"
						placeholder="Re-enter your password"></td>
				</tr>
				<tr>
					<th>Contact :</th>
					<td><input type="text" name="contact"
						value="<%=bean.getContact()%>"
						placeholder="Enter your mobile number"></td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" name="Operation" value="Update"
					style="margin-left: 30px; margin-top: 10px;">
				<input type="submit" name="Operation" value="Delete"
					style="margin-left: 30px; margin-top: 10px;">
			</div>
		</form>
	</div>
</body>
</html>