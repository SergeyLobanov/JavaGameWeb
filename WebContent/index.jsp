<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>We are playing</title>
</head>
<body>

	<form method="POST" action="JavaGameServlet">
		Enter your name<input type="text" name="name"><br>
		Enter lower number for game<input type="number" name ="minValue" value="0"><br>
		Enter higher number for game<input type="number" name ="maxValue" value="100"><br>
		<input type="submit" value="PLAY">
	</form>
	
</body>
</html>