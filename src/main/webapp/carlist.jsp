<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/4/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="ic"
                   driver="org.postgresql.Driver"
                   url = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj"
                    user = "ruosfovocnllbi"
                    password = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790"/>

<sql:query dataSource="${ic}" var="oc">
    SELECT * from cars;
</sql:query>
<div >
    <table border="1" cellpadding="5">
        <caption><h2>List of users</h2></caption>
        <tr>
            <th>Plate</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Price</th>
            <th>Years</th>
            <th>Pic</th>
            <th>Status</th>

        </tr>
        <c:forEach var="user" items="${oc.rows}">
            <tr>
                <td><c:out value="${carplate}" /></td>
                <td><c:out value="${carbrand}" /></td>
                <td><c:out value="${carmodel}" /></td>
                <td><c:out value="${carprice}" /></td>
                <td><c:out value="${caryears}" /></td>
                <td><c:out value="${carpic}" /></td>
                <td><c:out value="${carstatus}" /></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
