<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
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
input[type=text]
{
	width:100%;
	border-radius:3em;
	padding:5px;
}
input[type=password]
{
	width:100%;
	border-radius:3em;
	padding:5px;
}
</style>
</head>
<body background="lbg.jpg">
    <form action="/SampleRegistration/LoginServlet" method="post">
      <table align="center">
	      <tr><td><h1>&nbsp;Welcome Back..</h1></td></tr>
	      <tr><td><input type="text" name="username" placeholder="User Name" autofocus required="required"/></td></tr><tr></tr><tr></tr>
	      <tr><td><input type="password" name="userpwd" placeholder="Password" required="required"></td></tr><tr></tr>
	      <tr><td><input type="submit" name="signin" value="Sign In" class="submit"></td></tr>
	      <tr><td><a href="register.jsp">New Member?</a></td></tr><tr></tr>
      </table>
    </form>
</body>
</html>