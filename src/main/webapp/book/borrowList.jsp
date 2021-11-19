<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 11/19/2021
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <th>CardId</th>
            <th>name of book</th>
            <th>author</th>
            <th>Name of student</th>
            <th>Class</th>
            <th>Borrow Day</th>
            <th>Return Day</th>
            <th>Action</th>
        </tr>
        <c:forEach var="card" items="${cardList}">
            <tr>
                <td>
                    <c:out value="${card.id}"/>
                </td>
                <td>
                    <c:out value="${card.book.name}"/>
                </td>
                <td>
                    <c:out value="${card.book.author}"/>
                </td>
                <td>
                    <c:out value="${card.student.name}"/>
                </td>
                <td>
                    <c:out value="${card.student.className}"/>
                </td>
                <td>
                    <c:out value="${card.borrowDay}"/>
                </td>
                <td>
                    <c:out value="${card.returnDay}"/>
                </td>
                <td>
                    <a href="borrows?action=returnBook&id=${card.id}">payBook</a>
                </td>
            </tr>
        </c:forEach>

<%--        <tr>--%>
<%--            <form action="/borrows" method="get">--%>
<%--                <td>Search By Name</td>--%>
<%--                <td><input type="text" name="search"></td>--%>
<%--                <td><input type="submit" value="Search"></td>--%>
<%--                <td><input name="action" value="search" hidden></td>--%>
<%--            </form>--%>
<%--            <td><a href="/borrows">home</a></td>--%>
<%--        </tr>--%>
    </table>
</div>
</body>
</html>
