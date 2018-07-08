<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Source</td>
		<td>Destination</td>
		<td>Departure</td>
		<td>Arrival</td>
		<td>Cost</td>
		<td></td>
	</tr>
	 <c:forEach var="flight" items="${lists}">
		<tr>
		<td>${flight.locationMaster1.code }</td>
        <td>${flight.locationMaster2.code }</td>
        <td>${flight.departureTime }</td>
        <td>${flight.arrivalTime }</td>
        <td>${flight.fareMaster.economyClass }</td>
        <td><a href="bookflight?flightId=${flight.flightId }">Book Now</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>