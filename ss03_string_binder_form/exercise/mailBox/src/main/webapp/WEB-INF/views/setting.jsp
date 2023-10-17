<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 10/17/23
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<form:form modelAttribute="mailBox" method="post" action="/update">
    <table>
        <tr>
            <td>
                Languages:
            </td>
            <td>
                <form:select path="language">
                    <c:forEach items="${languageList}" var="language">
                        <form:option value="${language}">${language}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                Page size:
            </td>
            <td>
                Show:
                <form:select path="pageSize">
                    <c:forEach items="${pageSizeList}" var="ps">
                        <form:option value="${ps}">${ps}</form:option>
                    </c:forEach>
                </form:select>
                </span> emails per page</td>
            </td>
        </tr>
        <tr>
            <td>
                Spams Filter
            </td>
            <td>
                <form:checkbox path="spamsFilter" value="true" label="Enable spam filter"/>
            </td>
        </tr>
        <tr>
            <td>
                Signature
            </td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="align-content: center;justify-content: center">
                <button style="background-color: dodgerblue; horiz-align: center"
                        type="submit" value="update">Update</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
