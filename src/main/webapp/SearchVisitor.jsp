<%--
  Created by IntelliJ IDEA.
  User: Machine Learning
  Date: 10/2/2017
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navReceptionist.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="SearchVisitor" method="post">
    <table>
        <tr>
            <td>Visitor Id:</td>
            <td><input type="number" name="idNumber" required/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Search Visitor"/></td>
        </tr>
    </table>
</body>
</html>
