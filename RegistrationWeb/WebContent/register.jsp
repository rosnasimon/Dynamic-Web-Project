<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign UP</title>
<style>
p
{
	color:red;
}
</style>
</head>
<body>
    <!--Form Elements starts here-->
	<form action="RegisterServlet" method="post">
		<table align="center">
			  <tr ><td><h1><u>Register Here..</u></h1></td></tr>
		      <tr><td>Full Name</td><td><input type="text" name="fname" id="name" size="30" autofocus placeholder="Full Name" onblur="checkName()"/></td><td><p id="nm"></p></td></tr>	      
		      <tr><td>User Name</td><td><input type="text" name="username" id="un" size="30" placeholder="User Name" onblur="checkUname()"/></td><td><p id="us"></p></td></tr>
		      <tr><td>Password</td><td><input type="password" name="pwd" id="p" size="30" placeholder="Password" onblur="checkPwd()"/></td><td><p id="pw"></p></td></tr>
		      <tr><td>Confirm Password</td><td><input type="password" name="cpwd" id="cp" size="30" placeholder="Confirm Password" onblur="checkCpwd()"/></td><td><p id="cpw"></p></td></tr>
		      <tr><td>Email ID</td><td><input type="email" name="email" size="30" id="eid" placeholder="Email" onblur="checkEmail()"/></td><td><p id="em"></p></td></tr>
		      <tr><td>Mobile No</td><td><input type="text" name="mob" size="30" id="mob" placeholder="Mobile Number" onblur="checkMobile()"/></td><td><p id="mo"></p></td></tr>
		      <tr><td></td><td><input type="submit" name="register" value="Sign Up"/></td>
		</table>
	</form>   
	<!--End of Elements-->
	<script>
    	function checkName()
    	{
    		var n=document.getElementById("name");
    		var nm=document.getElementById("nm");
    		if(n.value.length==0)
    			nm.innerHTML="This is Required!!";
    		else
    			nm.innerHTML=" ";
    	}
    	function checkUname()
    	{
    		var n=document.getElementById("un");
    		var nm=document.getElementById("us");
    		if(n.value.length==0)
    			nm.innerHTML="This is Required!!";
    		else
    			nm.innerHTML=" ";
    	}
    	function checkPwd()
    	{
    		var n=document.getElementById("p");
    		var nm=document.getElementById("pw");
    		if(n.value.length==0)
    			nm.innerHTML="This is Required!!";
    		else
    			nm.innerHTML=" ";
    	}
    	function checkCpwd()
    	{
    		var n=document.getElementById("cp");
    		var nm=document.getElementById("cpw");
    		if(n.value.length==0)
    			nm.innerHTML="This is Required!!";
    		else
    			nm.innerHTML=" ";
    	}
    	function checkEmail()
    	{
    		var n=document.getElementById("eid");
    		var nm=document.getElementById("em");
    		if(n.value.length==0)
    			nm.innerHTML="This is Required!!";
    		else
    			nm.innerHTML=" ";
    	}
    	function checkMobile()
    	{
    		var n=document.getElementById("mob");
    		var nm=document.getElementById("mo");
    		if(n.value.length==0)
    			nm.innerHTML="This is Required!!";
    		else
    			nm.innerHTML=" ";
    	}
    </script>  
</body>
</html>