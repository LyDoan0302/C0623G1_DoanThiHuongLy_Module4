<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 10/13/23
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h1>UPDATE CUSTOMER INFORMATION</h1>
<form action="/update/${customer.id}" method="post">
  <fieldset>
    <legend>Customer information: </legend>

    <label for="${customer.name}">Name :</label>
    <input type="text" name="name" value="${customer.name}"/>

    <label for="${customer.email}">Email :</label>
    <input type="text" name="email" value="${customer.email}"/>

    <label for="${customer.address}">Address :</label>
    <input type="text" name="address" value="${customer.address}"/>

    <button type="submit">Update</button>

<%--    <legend>Customer information: </legend>--%>
<%--    <label>Customer id: <input type="number" name="id" value="${customer.id}"></label>--%>
<%--    <label>Name: <input type="text" name="name" value="${customer.name}"></label>--%>
<%--    <label>Email: <input type="text" name="email" value="${customer.email}"></label>--%>
<%--    <label>Address: <input type="text" name="address" value="${customer.address}"></label>--%>

  </fieldset>
</form>

</body>
</html>
