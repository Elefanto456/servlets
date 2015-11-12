<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='UTF-8'>
    <title>Registration</title>
</head>
<body>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<form action="" form method="POST">
    <p>Email:<br><input type="text" name="email"></p>

    <p>Password:<br><input type="password" name="password" value=""></p>

    <input type="radio" name="gender" value="1">Male</br>
    <input type="radio" name="gender" value="0">Female </br>


    <p><input type="checkbox" name="subscription" value="on" checked>I want to receive the latest news</p>

    <p><input type="submit" value="Registrate">
</form>
</body>
</html>