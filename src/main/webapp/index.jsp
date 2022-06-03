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
<div class="header">
    <p>UiTM JASIN NON-RESIDENT HOUSE RENTAL SYSTEM</p>
</div>
<form action="AdminServlet" method="POST">
    <div class="container">
        <h2>ADMIN LOGIN</h2>
        <div class="row">

            <div class="col-25">
                <label style="">Username</label>
            </div>
            <div class="col-75">
                <input type="text" name="staffusername" placeholder="Enter your username" value="">
            </div></div>
        <div class="row">
            <div class="col-25">
                <label>Password</label>
            </div>
            <div class="col-75">
                <input type="password" name="staffpassword" placeholder="Your password" value="">
            </div>
        </div>
        <input type="hidden" name="action" value="login">


        <button type="submit" class="button button1" name="submit" >Login</button>

    </div>
</form>
</body>
</html>