<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Books</h1>
<table>
    <tr>
        <td>ISBN</td>
        <td>Title</td>
        <td>Publisher</td>
        <td></td>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.ISBN}</td>
            <td>${book.title}</td>
            <td>${book.publisher}</td>
            <td><a href="books/${book.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>

<a href="books/add"> Add a Book</a>
</body>
</html>
