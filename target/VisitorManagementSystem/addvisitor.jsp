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
    <title>Add-Visitor</title>
</head>
<body>
<form action="AddVisitor" method="post">
    <table>
        <tr>
            <td>Visitor ID:</td>
            <td><input type="number" name="idNumber" required/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" required/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" required/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" required/></td>
        </tr>
        <tr>
            <td>Contact:</td>
            <td><input type="text" name="contact" required/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>Male<input type="radio" name="gender" value="male" required/>
                Female<input type="radio" name="gender" value="female" required/></td>
        </tr>
        <tr>
            <td>Category:</td>
            <td>VIP<input type="radio" name="category" value="vip" required/>
                Normal<input type="radio" name="category" value="normal" required/></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Add Visitor"/></td>
        </tr>
    </table>
</form>
</body>
</html>
