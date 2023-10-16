<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>CONDIMENTS</h1>
<form>
    <fieldset>
        <legend>SANDWICH CONDIMENTS</legend>
        <input type="checkbox" id="Sprout" name="condiment" value="Sprout">
        <label for="Sprout">Sprout</label><br>
        <input type="checkbox" id="Lettuce" name="condiment" value="Lettuce">
        <label for="Lettuce">Lettuce</label><br>
        <input type="checkbox" id="Mustard" name="condiment" value="Mustard">
        <label for="Mustard">Mustard</label><br>
        <input type="checkbox" id="Tomato" name="condiment" value="Tomato">
        <label for="Tomato">Tomato</label><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br>
<fieldset>
    <legend>CHOSEN SANDWICH CONDIMENTS</legend>
    <c:forEach items="${condiment}" var="condiment1">
        <c:out value="${condiment1}"/><br>
    </c:forEach>
</fieldset>
</body>
</html>