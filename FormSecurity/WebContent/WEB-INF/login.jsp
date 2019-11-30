<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#cccccc">
<blockquote>
	<h2> Please enter your user name and password:</h2>
	<form method="POST" action="j_security_check">
		<table border="1">
			<tr>
				<td> Username: </td>
				<td> <input type="text" name="j_username"/> </td>
			</tr>
			<tr>
				<td> Password: </td>
				<td> <input type="password" name="j_password"/> </td>
			</tr>
			<tr>
				<td colspan="2" align="right"> <input type="submit" value="Submit"/> </td>
			</tr> 
		</table>
	</form>
</blockquote>

</body>
</html>