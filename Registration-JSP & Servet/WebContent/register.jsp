<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
a
{
	color:white;
}
a:hover
{
	color:yellow;
}
h1
{
	color:white;
}
</style>
</head>
<body background="regbg.jpg">
	<form action="/SampleRegistration/RegisterServlet" method="post">
		<h1 align="center">Sign Up</h1>
		<table align="center">
			<tr>
				<td>Full Name</td>
				<td><input type="text" name="fname" placeholder="Your full name" required></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="uname" placeholder="User name" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd" placeholder="password" required></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="cpwd" placeholder="Re-typr your password" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" placeholder="Your email id" required></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="Sign Up"/><a href="signin.jsp">Already Registered?</a></td>
			</tr>
		</table>
	</form>
</body>
</html>