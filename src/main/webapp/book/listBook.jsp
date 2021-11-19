<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 11/19/2021
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Danh sách sách </h1>

</center>
<div align="center">
    <table border="1px">
        <caption>List of book</caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>author</th>
            <th>description</th>
            <th>quantity</th>
            <th>action</th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>
                    <c:out value="${book.id}"/>
                </td>
                <td>
                    <c:out value="${book.name}"/>
                </td>
                <td>
                    <c:out value="${book.author}"/>
                </td>
                <td>
                    <c:out value="${book.description}"/>
                </td>
                <td>
                    <c:out value="${book.quantity}"/>
                </td>
                <td>
                    <a href="books?action=borrow&id=${book.id}">borrow</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
