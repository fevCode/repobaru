<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#ket {
	color: red;
	
}
body {
    text-align: center;
}
form {
    display: inline-block;
}
</style>
</head>
<body>
	<form action="login" method="GET">
		<fieldset>
			<legend>Login:</legend>
			<label> Username<input type="text" name="username">
			</label> <br /> <label> Password<input type="password" name="password">
				<br />
			</label> <input type="submit" value="go"> <br /> <label id="ket">
				Message: ${message}</label>

		</fieldset>
		<p><i> *defaultnya, username=user & password=pass</i></p>
	</form>
</body>
</html>