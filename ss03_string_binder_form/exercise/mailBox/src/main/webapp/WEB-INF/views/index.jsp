<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<table style="border: 1px solid" >
    <tr>
        <td>
            Languages:
        </td>
        <td>
            ${mailBox.language}
        </td>
    </tr>
    <tr>
        <td>
            Page size:
        </td>
        <td>
            Show:
            ${mailBox.pageSize}
            </span> emails per page
        </td>
        </td>
    </tr>
    <tr>
        <td>
            Spams Filter:
        </td>

        <c:choose>
            <c:when test="${mailBox.spamsFilter == true}">
                <td>Enable spam filters</td>
            </c:when>
            <c:when test="${mailBox.spamsFilter == false}">
                <td>Disable spam filters</td>
            </c:when>
        </c:choose>
    </tr>
    <tr>
        <td>
            Signature
        </td>
        <td>
            ${mailBox.signature}
        </td>
    </tr>
</table>
</body>
</html>