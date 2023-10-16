<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>CALCULATOR</h1><br/>

<form method="post">
    <fieldset>
        <legend>CALCULATOR</legend>
        <input type="number" name="number1" placeholder="Enter number 1" required/><br/><br/>
        <input type="number" name="number2" placeholder="Enter number 2" required/><br/><br/>
        <button type="submit" name="type" value="addition">Addition(+)</button>
        <button type="submit" name="type" value="subtraction">Subtraction(-)</button>
        <button type="submit" name="type" value="multiplication">Multiplication(*)</button>
        <button type="submit" name="type" value="division">Division(/)</button>
        <br/>
        <br/>
        <c:if test="${not empty result}">
            <p>Result: ${result}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p>${error}</p>
        </c:if>
    </fieldset>
</form>

</body>
</html>