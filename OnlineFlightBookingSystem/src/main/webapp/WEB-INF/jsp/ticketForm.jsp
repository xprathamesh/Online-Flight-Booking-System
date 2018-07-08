<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
var i=0;
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Fill the ticket</h2>
	<div>
		<label>FlightMaster ID <p> ${flight.flightId}</p></label>
		<label>Arrival Time <p> ${flight.arrivalTime}</p></label>
		<label>Source Location <p>${flight.locationMaster1.code}</p></label>
		<label>Destination Location <p> ${flight.locationMaster2.code}</p></label>
	</div>
	<div id="jj">
<button onclick="add()" id="old_button1">Add</button> 
	<form action="bookTicket" method="post">
	<input type="number" id="seat" name="seat" value="1"><br>
	<input type="hidden" name="flightId" value="${flight.flightId }">
	<input type="hidden" name="classType" value="economy" >
	<input type="text" name="username0" placeholder="First Name">
	<input type="text" name="middlename0" placeholder="Middle Name">
	<input type="text" name="lastname0" placeholder="Last Name">
	<input type="number" name="age0" placeholder="Enter Age">
	<input type="text" name="passport0" placeholder="Enter passport">
	<select name="gender0">
		<option value="M">Male</option>
		<option value="F">Female</option>
	</select>
	<select name="passengerType0">
		<option value="adult">Adult</option>
		<option value="child">Child</option>
	</select>
	<select name="meal0">
		<option value="veg">VEG</option>
		<option value="nvg">NON-VEG</option>
	</select>
	<div id="formMore">
		
	</div>
	<script type="text/javascript">
		function add()
			{
				var d=document.getElementById('seat').value;
				document.getElementById('seat').value=parseInt(d)+1;
				i=i+1;
				document.getElementById('formMore').style.visibility='visible';
				document.getElementById('formMore').innerHTML+='<br><input type="text" name="username'+i+'" placeholder="First Name"><input type="text" name="middlename'+i+'" placeholder="Middle Name"><input type="text" name="lastname'+i+'" placeholder="Last Name"><input type="number" name="age'+i+'" placeholder="Enter Age"><input  type="text" name="passport'+i+'" placeholder="Enter passport"><select name="gender'+i+'"><option value="M">Male</option><option value="F">Female</option></select><select name="passengerType0"><option value="adult">Adult</option><option value="child">Child</option></select><select name="meal0"><option value="veg">VEG</option><option value="nvg">NON-VEG</option></select>';
	}
	</script>
	
	<input type="submit" value="submit" name="submit"/>

	</form>
</body>
</html>