<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
body
{
	background-image:url("bg.png");
	background-repeat: no-repeat;
  	background-size: 100% 500%;
}
input[type=button]:hover
{
	background-color:red;
	font-weight:bold;
	color:white;
}
input[type=button]
{
	
	padding:2px;
	margin-left:43%;
	margin-right:30%;
	width:15%;
	border-radius:3em;
	border:2px solid black;
	padding-top:5px;
	padding-bottom:5px;
}
</style>
</head>
<body>
	<h1 align="center">Welcome!!</h1>
	<a id="first" href="signin.jsp"><input type="button" value="Sign In"></a>
	<a id="second" href="register.jsp"><input type="button" value="Sign Up"></a>

</body>
</html>