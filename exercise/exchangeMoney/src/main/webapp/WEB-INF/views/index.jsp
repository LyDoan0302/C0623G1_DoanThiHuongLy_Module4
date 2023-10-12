<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "EXCHANGE MONEY" %>
</h1>

<form action="/result" method="get">
    <fieldset>
        <legend>Exchange Money</legend>
        <label>USD :</label>
        <input type="number" placeholder="Enter USD" name="usd">
        <button type="submit">Exchange</button> </br>
        VND :
        ${vnd}
    </fieldset>
</form>
</body>
</html>