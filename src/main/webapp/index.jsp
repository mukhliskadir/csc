<%--
  Created by IntelliJ IDEA.
  User: TOSHIBA
  Date: 3/1/2022
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOUSE RENTAL SYSTEM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body >

<form action="CustServlet" method="POST">
    <div class="container">
        <h2>ADMIN LOGIN</h2>
        <div class="row">

            <div class="col-25">
                <label style="">Username</label>
            </div>
            <div class="col-75">
                <input type="text" name="username" placeholder="Enter your username" value="">
            </div></div>
        <div class="row">
            <div class="col-25">
                <label>Password</label>
            </div>
            <div class="col-75">
                <input type="password" name="password" placeholder="Your password" value="">
            </div>
        </div>
        <input type="hidden" name="action" value="login">


        <button type="submit" class="button button1" name="submit" >Login</button>

    </div>
</form>
<form class="cust" method="post" action="CustServlet">
    <div class="dataa">
        Name
        <input type="text" name="name">
    </div>
    <div class="dataa">
        Phone
        <input type="Number" name="phone">
    </div>
    <div class="dataa">
        ic
        <input type="Number" name="nric">
    </div>
    <div class="dataa">
        address
        <textarea type="text" name="address"></textarea>
    </div>

    <div class="dataa">
        username
        <input type="text" name="username">
    </div>
    <div class="dataa">
        password
        <input type="password" name="password">
    </div>
    <div class="dataa">License
        <input type="Number" name="license">
    </div>
    <input type="hidden" name="action" value="signup">

    <button type="submit" class="button button1" name="submit" >Sign Up</button><br><br>
</form>
</body>
</html>