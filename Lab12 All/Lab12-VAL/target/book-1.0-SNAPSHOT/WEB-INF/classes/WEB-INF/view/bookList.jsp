<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
        <td>Author</td>
        <td>price</td>
        <td></td>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.ISBN}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <sec:authorize access="hasRole('ADMIN')">
            <td><a href="books/${book.id}">edit</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>
<sec:authorize access="hasRole('ADMIN')">
<a href="books/add"> Add a Book</a>
</sec:authorize>


<a href="logout">Logout</a>

</body>
</html>
