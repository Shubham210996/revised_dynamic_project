<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List View</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<div class="container">
		<%
			String updateMessage = (String) request.getAttribute("updateMessage");
			String deleteMessage = (String) request.getAttribute("deleteMessage");
		%>
		<form>
			<%
				List list = (List) request.getAttribute("list");
				Iterator it = list.iterator();
			%>

			<table class="table border-info ">
				<tr align="center">
					<th>No</th>
					<th>Full Name</th>
					<th>Login ID</th>
					<th>Password</th>
					<th>Confirm Password</th>
					<th>Contact</th>
					<th>Settings</th>
				</tr>
				<%
					while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
				%>
				<tr align="center">
					<td><%=bean.getNo()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getConfirmPass()%></td>
					<td><%=bean.getContact()%></td>
					<td align="center"><a href="UserCtl?no=<%=bean.getNo()%>">Edit / Delete</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				if (updateMessage != null) {
			%>
			<br>
			<h5 style="color: red" align="center"><%=updateMessage%></h5>
			<%
				}
			%>
			<%
				if (deleteMessage != null) {
			%>
			<br>
			<h5 style="color: red" align="center"><%=deleteMessage%></h5>
			<%
				}
			%>
		</form>
	</div>
</body>
</html>