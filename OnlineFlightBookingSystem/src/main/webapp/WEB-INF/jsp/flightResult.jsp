<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search flights | KingFly</title>
</head>
<body>
<h1>Search for flights</h1>

<form method="get" action="flightList">
Source:
<select name="source">
    <c:forEach var="line" items="${total}">
        <option value="${line.locationMasterId}"><c:out value="${line.name}"/>( ${line.code} )</option>
    </c:forEach>
</select>

Destination:
<select name="destination">
    <c:forEach var="line" items="${total}">
        <option value="${line.locationMasterId}"><c:out value="${line.name}"/>( ${line.code} )</option>
    </c:forEach>
</select>

Date:
<input type="date" name="dateOfJourney" /> 

<input type="submit" value="submit" name="submit">
</form>

</body>
</html>