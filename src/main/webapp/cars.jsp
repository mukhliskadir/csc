<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/4/2022
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="cust" action="CarServlet" method="post">
    <div class="dataa">
        No. Plate :
        <input type="text" name="carPlate">
    </div>
    <div class="dataa">
        Car Brand :
        <input type="text" name="carBrand">
    </div>
    <div class="dataa">
        Model :
        <input type="text" name="carModel">
    </div>

    <div class="dataa">
      Image :
        <input type="text" id="carImage" name="carPic" accept="image/png, image/jpeg">
    </div>
    <div class="dataa">
        Price Per Day :
        <input type="text" name="carPrice" step="any" required>
    </div>
    <div class="dataa">
        Cars Manufacture Year :
        <input type="text"  name="years" />
    </div>
    <div class="dataa">
      Car Availabality ?<br>
        <select name="carStatus" id="carAval">
            <option value="Available">Available</option>
            <option value="In Rent">In Rent</option>
        </select>
    </div>
    <input type="hidden" name="action" value="addCar">

    <button type="submit" class="button button1" name="submit" >Add car</button>

</form>

</body>
</html>
