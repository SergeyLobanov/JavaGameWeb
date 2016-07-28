<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are winner</title>
</head>
<body>
Winner <c:out value="${name}"/>
	<br>Your have used <c:out value="${model.getUserAttempts().size()}"/> 
	attempts<c:forEach var="a" items="${model.getUserAttempts()}">
		<br><c:out value="${a}"/>			
	</c:forEach>	
</body>
</html>