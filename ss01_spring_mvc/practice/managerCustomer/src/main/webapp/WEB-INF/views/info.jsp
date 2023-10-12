<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 10/12/23
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Information</title>
</head>
<body>
<form>
  <fieldset>
    <legend>Customer information: </legend>
    <label>Customer id: <input type="number" name="id" value="${customer.id}"></label>
    <label>Name: <input type="text" name="name" value="${customer.name}"></label>
    <label>Email: <input type="text" name="email" value="${customer.email}"></label>
    <label>Address: <input type="text" name="address" value="${customer.address}"></label>
  </fieldset>
</form>

</body>
</html>
