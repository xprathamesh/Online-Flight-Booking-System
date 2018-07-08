<!DOCTYPE html>
<html lang="en">
<head>
  <title>User Profile | KingFly</title>
  <style> 
    input.hidden {
    position: absolute;
    left: -9999px;
}

#profile-image1 {
    cursor: pointer;
  
     width: 100px;
    height: 100px;
	border:2px solid #03b1ce ;}
	.tital{ font-size:16px; font-weight:500;}
	 .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}
     
     </style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="assets/css/navbar.css" />
      <link rel="stylesheet" href="assets/css/Footer-with-button-logo.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
			  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
			  <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
					
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/submitbutton.css">
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" />
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/navbar.css" />
			  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Footer-with-button-logo.css">
</head>
<body>

  <nav id="nav" > 
          <ul>
            <li><a href="homepage" class="active" title="Home"><span class="icon fa-home"></span></a></li>          
            <li><a href="" style color="black" title="About Us"><span class="icon fa fa-font"></span></a></li>            
            <li><a href="logout" title="Logout"><span class="icon fa-sign-out"></span></a></li>			
          </ul>
        </nav>

  
<div class="container">
	<div class="row">
        
       <div class="col-md-7 ">

<div class="panel panel-default">
  <div class="panel-heading">  <h4 >User Profile</h4></div>
   <div class="panel-body">
       
    <div class="box box-info">
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 
                
                <input id="profile-image-upload" class="hidden" type="file">
<div style="color:#999;" ></div>
                <!--Upload Image Js And Css-->
           
              
					
                
				
                     
                     
                     </div>
             
    
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <h4 style="color:#00b1b1;">${person.emailAddress}</h4></span> 
					 <p align="right">
						<a href="editUser"><button type="button" class="btn btn-primary";> Edit profile</button></a>
					</p>
              <br>
            </div>
            <div class="clearfix"></div>
            <hr style="margin:5px 0 5px 0;">
    
              
<div class="col-sm-5 col-xs-6 tital " >First Name</div><div class="col-sm-7 col-xs-6 ">${person.firstName}</div>
     <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Middle Name</div><div class="col-sm-7"> ${person.middleName}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Last Name</div><div class="col-sm-7"> ${person.lastName}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<!-- <div class="col-sm-5 col-xs-6 tital " >Date Of Joining:</div><div class="col-sm-7">15 Jun 2016</div>

  <div class="clearfix"></div>
<div class="bot-border"></div> -->

<div class="col-sm-5 col-xs-6 tital " >Date Of Birth</div><div class="col-sm-7">${person.dateOfBirth}</div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<!-- <div class="col-sm-5 col-xs-6 tital " >Address</div><div class="col-sm-7">--</div> -->


            <!-- /.box-body -->
          </div>
          <!-- /.box -->

        </div>
       
            
    </div> 
    </div>
</div>  
    <!--script>
              $(function() {
        $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       
              </script--> 
       </div>
</div> 
  <footer id="myFooter">
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
                <div class="footer-copyright">
                  <p>© 2016 Copyright Text </p>
                </div>
                </footer>       
</body>
</html>
