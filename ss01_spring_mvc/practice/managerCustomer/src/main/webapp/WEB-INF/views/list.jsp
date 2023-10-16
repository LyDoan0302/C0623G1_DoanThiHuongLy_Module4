<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 10/12/23
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table border="1px" width="90%" solid>
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Detail</th>
    <th>Update</th>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="info?id=${customer.id}">Detail</a></td>
            <td><a href="update/${customer.id}">Update</a></td>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>
