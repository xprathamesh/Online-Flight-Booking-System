<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="admin_locationMaster">
	City Name:-<input type="text" name="city_name">
	Code:-<input type="text" name="code" placeholder="3 character code">
	Airport Name:-<input type="text" name="airport_name">
	Country Name:-<input type="text" name="country">
	<input type="submit" name="submit" />
</form>
<a href="admin_locationMaster">View Data</a>
<a href="admin_locationMaster">Delete Data</a>
<a href="admin_locationMaster">Modify data</a>
</body>
</html>