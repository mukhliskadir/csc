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
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post">

    <table border="2">
        <tr>
            <td>Plate</td>
            <td>Brand</td>
            <td>Model</td>
            <td>Price</td>
            <td>Years</td>
            <td>Pic</td>
            <td>Status</td>
            <td>Action</td>
        </tr>
        <%
            try
            {
                Class.forName("org.postgresql.Driver");
                String dbURL = "jdbc:postgresql://ec2-54-227-248-71.compute-1.amazonaws.com/dbg69f8o5aj3pj";
                String user = "ruosfovocnllbi";
                String pass = "4c5eb370559357ded07f3ea6e699d8d7a41249752c9011caf5ac8c6d215bd790";
                String query="select * from cars";
                Connection con=DriverManager.getConnection(dbURL, user, pass);
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                while(rs.next())
                {

        %>
        <tr>
            <td><%=rs.getString("carplate") %></td>
            <td><%=rs.getString("carbrand") %></td>
            <td><%=rs.getString("carmodel") %></td>
            <td><%=rs.getString("carprice") %></td>
            <td><%=rs.getString("caryears") %></td>
            <td><%=rs.getString("carpic") %></td>
            <td><%=rs.getString("carstatus") %></td>
            <td>
                <a href="/edit?carPlate=<c:out value='${carplate}' />">Edit</a>
                <a href="/delete?carPlate=<c:out value='${carplate}' />">Delete</a>
            </td>
        </tr>

        <%

            }
        %>
    </table>
    <%
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    %>
</form>
</body>
</html>
