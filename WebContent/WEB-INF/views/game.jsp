<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>We are playing</title>
</head>
<body>
<b>hello <c:out value="${name}"/></b>
<br>random <c:out value="${randValue}"/>
<br>min <c:out value="${minValue}"/>
<br>max <c:out value="${maxValue}"/>

	<form method="POST" action="JavaGameServlet">
		Attempt<input type="number" name ="attempt"><br>
		<input type="submit" value="TRY">
	</form>
	
<c:if test="${hint ne null}">
	<c:out value="${hint}"/>
	<br>Your attempts   
	<c:forEach var="a" items="${model.getUserAttempts()}">
		<br><c:out value="${a}"/>			
	</c:forEach>
</c:if>

</body>
</html>