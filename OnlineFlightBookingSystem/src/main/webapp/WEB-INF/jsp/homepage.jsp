<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>KingFly Airlines</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
			  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
			  <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
					
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/submitbutton.css">
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" />
			  <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/navbar.css" /> --%>
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Footer-with-button-logo.css">
	<!--
			<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath()%>/resources/js/jquery.poptrox.min.js"></script>
			<script src="<%=request.getContextPath()%>/resources/js/jquery.scrolly.min.js"></script>
			<script src="<%=request.getContextPath()%>/resources/js/skel.min.js"></script>
			<script src="<%=request.getContextPath()%>/resources/js/util.js"></script>
			<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
			 <script src="assets/angular/angular.min.js"></script>
			<script src="<%=request.getContextPath()%>/resources/js/calendar.js"></script>
		 -->
			

		
		<script>
		p.italic {
    font-style: italic;
}
</script>
</head>
<body>
<div class="page-wrap">	
	</div>

			
			<!-- Nav -->
				<nav id="nav" > 
					<ul>
						<li><a href="homepage" class="active" title="Home"><span class="icon fa-home"></span></a></li>
						<li><a href="register" title="Registration Form"><span class="icon fa fa-file-o"></span></a></li>
						<li><a href="" title="About Us"><span class="icon fa fa-font"></span></a></li>
						<li><a href="logout" title="Logout"><span class="icon fa-sign-out"></span></a></li>
						<li><a href="user" title="Edit profile"><span class="icon fa-user"></span></a></li>
					</ul>
				</nav>

  </div>
		<div class="page-wrap">

			
			<!-- Main -->
				<section id="main">

					<!-- Banner -->
						<section id="banner">
							<div class="inner" align="bottom"> 
								<ul class="actions" align="right">
									
									<li><a href="login" class="button alt scrolly big">Login</a> &nbsp <a href="register" class="button alt scrolly big">Register</a></li>
									<li></li>
									<li></li>
								</ul><br/><br/><br/><br/><br/><br/><br/><br/><br/>
								<ul>
								<div class="col-xs-12">
								<div id="1" class="tab1 active" >
								<!-- 
									<form method="get" action="flightList">
										
										

											<div class="col-sm-3 col-xs-16 ctrl">	
											<i aria-hidden="true"></i>
											<input id="source" type="text" class="form-control" name="source" list="datalist1" placeholder="From Source" required>
											<datalist id="datalist1">
											<%-- <select name="source">
    											<c:forEach var="line" items="${total}">
        											<option value="${line.locationMasterId}"><c:out value="${line.name}"/>( ${line.code} )</option>
    											</c:forEach>
											</select> --%>
											<option value="Mumbai">Mumbai</option>
											<option value="New York">New York</option>
											<option value="London">London</option>
											<option value="Los Angeles">Los Angeles</option>
											<option value="Bangalore">Bangalore</option>										
										
										</div>
										
 										<div class="col-sm-3 col-xs-12 ctrl">
											<i  aria-hidden="true"></i>
											<input id="destination" type="text" class="form-control" name="destination" list="datalist2"  placeholder="To Destination" >
											<datalist id="datalist2">
											<%-- <select name="destination">
    											<c:forEach var="line" items="${total}">
        											<option value="${line.locationMasterId}"><c:out value="${line.name}"/>( ${line.code} )</option>
    											</c:forEach>
											</select> --%>
											<option value="Mumbai">Mumbai</option>
											<option value="New York">New York</option>
											<option value="London">London</option>
											<option value="Los Angeles">Los Angeles</option>
											<option value="Bangalore">Bangalore</option>											
										</div>
										
										<div  class="col-sm-3 col-xs-12 ctrl">
											
											<div class="input-group registration-date-time">
												<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
												<input class="form-control" name="dateOfJourney" id="date" type="date">
											</div>
										</div>
		
										<div class="col-sm-1 col-xs-12 ctrl">	
											<i  aria-hidden="true"></i>
											<input id="seats" type="number" class="form-control" name="seats" value="" placeholder="seats" min="1" max="10" pattern="[0-9]{2}" required>
										</div>		
										<div class="btn-group"	class="col-sm-2 col-xs-10 ctrl">
												<select button type="button" class="btn btn-default" class= "btn btn-primary dropdown-toggle" data-toggle="dropdown">Menu <span class="caret"></span>
													<option value="Economy">Economy</option>
													<option value="Business">Business</option>
													<option value="Premium">Premium</option>
												</select>
											  
										</div>
									
									
									<div class="btn-group">
										<!-- <button type="submit" form="form1" value="Submit">SEARCH</button> -->	
										<div>
										<form action="flightResult" method="get">
											<input type="submit" value="Search for Flights"/>
										</form>
									</div>	
									
									<!-- </form> --> 

								</div>
								</div>
								
								</ul>
							</div>
						</section>

		</div>
					
							<!-- Contact -->
						<section id="contact">
							<!-- Social -->
								<div class="social column">
									<h3>About Us</h3>
									<p>Mus sed interdum nunc dictum rutrum scelerisque erat a parturient condimentum potenti dapibus vestibulum condimentum per tristique porta. Torquent a ut consectetur a vel ullamcorper a commodo a mattis ipsum class quam sed eros vestibulum quisque a eu nulla scelerisque a elementum vestibulum.</p>
									<p>Aliquet dolor ultricies sem rhoncus dolor ullamcorper pharetra dis condimentum ullamcorper rutrum vehicula id nisi vel aptent orci litora hendrerit penatibus erat ad sit. In a semper velit eleifend a viverra adipiscing a phasellus urna praesent parturient integer ultrices montes parturient suscipit posuere quis aenean. Parturient euismod ultricies commodo arcu elementum suspendisse id dictumst at ut vestibulum conubia quisque a himenaeos dictum proin dis purus integer mollis parturient eros scelerisque dis libero parturient magnis.</p>									
								</div>

							<!-- Form -->
								<div class="column">
									<h3>Get in Touch</h3>
									<form action="#" method="post">
										<div class="field half first">
											<label for="name">Name</label>
											<input name="name" id="name" type="text" placeholder="Name">
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input name="email" id="email" type="email" placeholder="Email">
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="6" placeholder="Message"></textarea>
										</div>
										<ul class="actions">
											<li><input value="Send Message" class="button" type="submit"></li>
										</ul>
									</form>
								</div>

								
								<footer id="myFooter" >
								<div class="container">
									<div class="row">
										<div class="col-sm-3">
											<h2 class="logo"><a href="#"> LOGO </a></h2>
										</div>
										<div class="col-sm-2">
											<h5>Get started</h5>
											<ul>
												<li><a href="#">Home</a></li>
												<li><a href="#">Sign up</a></li>
												<li><a href="#">Downloads</a></li>
											</ul>
										</div>
										<div class="col-sm-2">
											<h5>About us</h5>
											<ul>
												<li><a href="#">Company Information</a></li>
												<li><a href="#">Contact us</a></li>
												<li><a href="#">Reviews</a></li>
											</ul>
										</div>
										<div class="col-sm-2">
											<h5>Support</h5>
											<ul>
												<li><a href="#">FAQ</a></li>
												<li><a href="#">Help desk</a></li>
												<li><a href="#">Forums</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<div class="social-networks">
												<a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
												<a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
												<a href="#" class="google"><i class="fa fa-google-plus"></i></a>
											</div>
											<button type="button" class="btn btn-default" >Contact us</button>
										</div>
									</div>
								</div>
								<div class="copyright">
								&copy; Untitled Design: <a href="https://templated.co/">TEMPLATED</a>. Images: <a href="">Unsplash</a>.
							</div>
								</footer>
						</section>
				</section>
		</div>

</div>		

	</body>
</html>