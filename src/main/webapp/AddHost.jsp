<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 9/29/2017
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Add-Receptionist</title>
</head>
<body>
<form action="addHost" method="post">
    <table>
        <tr>
            <td>Work ID:</td>
            <td><input type="number" name="workid" required/></td>
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
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>


        <tr>
            <td colspan="2" align="center"><input type="submit" value="Add Host"/></td>
        </tr>
    </table>
</form>
</body>
</html>
