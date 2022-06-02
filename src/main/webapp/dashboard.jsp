<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<script src="https://kit.fontawesome.com/9bff21277a.js" crossorigin="anonymous"></script>
	
</head>
<body>


	<div class="sidebar">
		<div class="img"><img src="ss.png" style="width:230px;height: 100px;"></div>	

  		<a class="active"  href="dashboard.html"><i class="fa-solid fa-chart-column"></i>  Dashboard</a>
		<a href="booking.html"><i class="fa-solid fa-notes-medical"></i>  Booking</a>
		<a href="cars.html"><i class="fa-solid fa-car"></i>  Cars Info</a>
   		<a href="return.html"><i class="fa-solid fa-arrow-left"></i> Return Car</a>
      <a href="report.html"><i class="fa-solid fa-print"></i>  Report</a>
  		<a href="customer.html"><i class="fa-solid fa-user"></i>  Customer</a>
  		<a  href="staffs.html"><i class="fa-solid fa-users"></i>  Staff</a>

  		<div id="logot"><button type="logout" href="login.html" value="logout">LOG OUT</button></div>
	</div>
<div class = "header" style=""> 
	<h3>Nama</h3></div>

<div class="content">
  <br>
  <h2>MY DASHBOARD</h2>		

  <div class="box" id="box1">
    <p><i class="fa-solid fa-car-side fa-2xl"></i><br><br>TOTAL CARS</p>
    <h5 class="itemdashboard" name="totcar">3</h5>
  </div>
  <div class="box" id="box2">
    <p><i class="fa-solid fa-arrow-right-from-bracket fa-2xl"></i><br><br>CAR IN RENT</p>
    <h5 class="itemdashboard" name="totrent">2</h5>
  </div>
  <div class="box" id="box3">
    <p><i class="fa-solid fa-hourglass fa-2xl"></i><br><br>PENDING CAR PICK</p>
    <h5 class="itemdashboard" name="totpending">0</h5>
  </div>
  <div class="box" id="box4">
    <p><i class="fa-solid fa-users fa-2xl"></i><br><br>REGISTERED CUSTOMER</p>
    <h5 class="itemdashboard" name="totreg">3</h5>
  </div>
  <div class="box" id="box5">
    <p><i class="fa-solid fa-users-gear fa-2xl"></i><br><br>TOTAL STAFF</p>
    <h5 class="itemdashboard" name="totstaff">3</h5>
  </div>
  <div class="box" id="box6">
    <p><i class="fa-solid fa-sack-dollar fa-2xl"></i><br><br>MONEY COLLECTED</p>
    <h5 class="itemdashboard" name="totmoney">RM 3,000.00</h5>
  </div>

  		  	
<br><br><br>

  
</div>

</body>
<style type="text/css">		

#logot{ margin: 0;
  position: absolute
  ;margin-left: 40px;margin-top: 20px;
  }
div.box{
  width: 400px;
  height: 250px;
  border:5px solid;
  float: left;
  margin: 25px;
  box-shadow: inset 0 -3em 3em rgba(0,0,0,0.1),
             0 0  0 2px rgb(255,255,255),
             0.3em 0.3em 1em rgba(0,0,0,0.3);
             padding: 5px;
}
#box1{background-color: #edc966;}
#box2{background-color: #fc90fb}
#box3{background-color: #adedab}
#box4{background-color: #bbf1f2}
#box5{background-color: #f5ae7f}
#box6{background-color: #f5ede9}

p{font-size: 30px; text-align: center;}
h5{font-size: 40px;text-align: center;}
</style>
</html>