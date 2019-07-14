<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book</title>
</head>
<body>
<%--<c:if test="${msg == 'Update'}">--%>
<%--<form action="../books/${book.id}" method="post">--%>
<%--    </c:if>--%>
<%--    <c:if test="${msg == 'Add'}">--%>
<%--    <form action="../books" method="post">--%>
<%--        </c:if>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>ISBN:</td>--%>
<%--                <td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Title:</td>--%>
<%--                <td><input type="text" name="title" value="${book.title}" /> </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Publisher:</td>--%>
<%--                <td><input type="text" name="publisher" value="${book.publisher}" /> </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--            <sec:csrfInput />--%>
<%--        <input type="submit" />--%>
<%--    </form>--%>
<%--    <c:if test="${msg == 'Update'}">--%>
<%--    <form action="delete?bookId=${book.id}" method="post">--%>
<%--        <sec:csrfInput />--%>
<%--        <button type="submit">Delete</button>--%>
<%--    </form>--%>
<%--    </c:if>--%>

<c:if test="${msg == 'Update'}">
    <form:form action="../books/${book.id}" method="post">
        <table>
            <tr>
                <td>ttile:</td>
                <td><input type="text" name="title" value="${book.title}" /> </td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
            </tr>
            <tr>
                <td>author:</td>
                <td><input type="text" name="author" value="${book.author}" /> </td>
            </tr>
            <tr>
                <td>price:</td>
                <td><input type="text" name="price" value="${book.price}" /> </td>
            </tr>
        </table>
        <input type="submit" value="Update" name="Update"/>
    </form:form>
</c:if>
<c:if test="${msg == 'Add'}">
    <form:form modelAttribute="book" action="../books/add" method="post" >
        <form:errors path="*" cssClass="errorblock" element="div" />
        <table>
            <tr>
                <td>title:</td>
<%--                <td><input type="text" name="title" value="${book.title}" /> </td>--%>

                <td><form:input path="title" /> </td>
                <td><form:errors path="title" cssClass="error" /> </td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
            </tr>
            <tr>
                <td>author:</td>
                <td><input type="text" name="author" value="${book.author}" /> </td>
            </tr>
            <tr>
                <td>price:</td>
                <td><input type="text" name="price" value="${book.price}" /> </td>
            </tr>
        </table>
        <input type="submit" value="Add" name="Update"/>
    </form:form>
</c:if>
<c:if test="${msg == 'Update'}">
    <form:form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form:form>
</c:if>
</body>
</html>
