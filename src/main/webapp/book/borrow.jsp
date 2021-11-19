<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 11/19/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<form method="post">
    <input type="hidden" name="id" value="${book.id}">
    <fieldset>
        <legend>BORROW BOOK</legend>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${book.id}" ></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${book.name}" readonly></td>
            </tr>
            <tr>
                <td>Student Name</td>
                <td>
                    <select name="student">
                        <c:forEach items="${students}" var="student">
                            <option value="${student.id}">${student.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Borrow Date</td>
                <td><input type="text" name="borrow" ></td>
            </tr>
            <tr>
                <td>Return Book </td>
                <td><input type="text" name="return"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Borrow"></td>
                <td><a href="/books">cancel</a> </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

