<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "DICTIONARY" %>
</h1>
<form method="post">
    <fieldset>
        <legend>English_Vietnamese Dictionary</legend>
        <label>English: </label>
        <input type="text" name="english" placeholder="Enter word...">
        <button type="submit">Search</button><br>
        Vietnameses:
       <p>${vietnamese}</p>

    </fieldset>
</form>
</body>
</html>