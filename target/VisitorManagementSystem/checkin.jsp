<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 9/29/2017
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="navReceptionist.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Check-in</title>
</head>
<body>
<form action="CheckIn" method="post">
    <table>
        <tr>
            <td>Purpose:</td>
            <td><textarea cols="10" rows="10" name="purpose"></textarea></td>
        </tr>
        <tr>
            <td>Person Visited:</td>
            <td><input type="text" name="personvisited" required/></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><input type="date" name="date"></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Check-in"/></td>
        </tr>
    </table>
</form>
</body>
</html>
