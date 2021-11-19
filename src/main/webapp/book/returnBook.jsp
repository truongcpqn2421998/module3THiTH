<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 11/19/2021
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Return BOOK</legend>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${card.id}" readonly ></td>
            </tr>
            <tr>
                <td>Name Book</td>
                <td><input type="text" name="nameBook" value="${card.book.name}" readonly></td>
            </tr>
            <tr>
                <td>Name Student</td>
                <td><input type="text" name="nameStudent" value="${card.student.name}" readonly></td>
            </tr>
            <tr>
                <td>Borrow Date</td>
                <td><input type="text" name="borrow"value="${card.borrowDay}" readonly ></td>
            </tr>
            <tr>
                <td>Return Book </td>
                <td><input type="text" name="return"value="${card.returnDay}" readonly></td>
            </tr>
            <tr>
                <td><input type="submit" value="Return"></td>
                <td><a href="/borrows">cancel</a> </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
