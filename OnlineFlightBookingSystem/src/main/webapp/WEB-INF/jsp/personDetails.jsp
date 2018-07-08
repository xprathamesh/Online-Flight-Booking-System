<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
${message}  <br>
	<form action="addAddressDetails" method="post">
		<select name="Type">
			<option value="">Select address type</option>
			<option value="Home">Home</option>
			<option value="Office">Office</option>

		</select><br>
		
		 Address Line1:<input type="text" name="line1" /><br /> 
		 Address Line2:<input type="text" name="line2" /><br /> 
		 Address Line3:<input type="text" name="line3" /><br /> 
		 Pin code:<input type="text" name="pincode" /><br /> 
		 City:<input type="text" name="city" /><br /> 
		 Country:<input type="text" name="country" /><br /> 
		 <input type="submit"
			value="addAddressDetails" />
	</form>
</body>
</html>
