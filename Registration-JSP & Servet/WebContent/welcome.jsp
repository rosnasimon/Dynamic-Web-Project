<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
h1{
	font-weight:900;
	color:green;
}
h2{
	font-weight:800;
	color:orange;
}
input[type=submit]
{
	margin-left:42%;
	width:15%;
	border-radius:3em;
	border:2px solid black;
	padding-top:5px;
	padding-bottom:5px;
	
}
input[type=submit]:hover
{
	background-color:red;
	font-weight:bold;
	color:white;
}
</style>
</head>
<body>
	<form action="signin.jsp">
	<%
		List details=(List)request.getAttribute("values");
	%>
		<h1 align="center">Welcome <%out.println(details.get(0));%>to our Professional Community</h1>
		<h2 align="center">Email	:	<%out.println(details.get(1)); %></h2>
		<input type="submit" value="Logout"/>
	</form>
</body>
</html>