<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Home Page</h3>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="userName" value="${user.userName}"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="${user.password}"/></td>
			</tr>
			<tr>
				<td>Remember me</td>
				<td><input type="checkbox" name="rememberMe" value="Y"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"/>
					<a href="${pageContext.request.contextPath}/">Cancel</a>
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>	
</body>
</html>