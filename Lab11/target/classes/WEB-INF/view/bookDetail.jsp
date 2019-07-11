<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book</title>
</head>
<body>
<c:if test="${msg == 'Update'}">
<form action="../books/${book.id}" method="post">
    </c:if>
    <c:if test="${msg == 'Add'}">
    <form action="../books" method="post">
        </c:if>
        <table>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" value="${book.title}" /> </td>
            </tr>
            <tr>
                <td>Publisher:</td>
                <td><input type="text" name="publisher" value="${book.publisher}" /> </td>
            </tr>
        </table>
        <input type="submit" />
    </form>
    <c:if test="${msg == 'Update'}">
    <form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
    </c:if>
</body>
</html>
