<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Book</title>
</head>

<body>
	<c:if test="${msg == 'Update'}">
		<form:form action="../Books/${Book.id}" method="post">
			<table>
				<tr>
					<td>ttile:</td>
					<td><input type="text" name="ttile" value="${Book.ttile}" /> </td>
				</tr>
				<tr>
					<td>ISBN:</td>
					<td><input type="text" name="ISBN" value="${Book.ISBN}" /> </td>
				</tr>
				<tr>
					<td>author:</td>
					<td><input type="text" name="author" value="${Book.author}" /> </td>
				</tr>
				<tr>
					<td>price:</td>
					<td><input type="text" name="price" value="${Book.price}" /> </td>
				</tr>
			</table>
			<input type="submit" value="Update" name="Update"/>
		</form:form>
	</c:if>
	<c:if test="${msg == 'Add'}">
		<form:form action="../Books/add" method="post">
			<table>
				<tr>
					<td>ttile:</td>
					<td><input type="text" name="ttile" value="${Book.ttile}" /> </td>
				</tr>
				<tr>
					<td>ISBN:</td>
					<td><input type="text" name="ISBN" value="${Book.ISBN}" /> </td>
				</tr>
				<tr>
					<td>author:</td>
					<td><input type="text" name="author" value="${Book.author}" /> </td>
				</tr>
				<tr>
					<td>price:</td>
					<td><input type="text" name="price" value="${Book.price}" /> </td>
				</tr>
			</table>
			<input type="submit" value="Add" name="Update"/>
	    </form:form>
	</c:if>
	<c:if test="${msg == 'Update'}">
		<form:form action="delete?BookId=${Book.id}" method="post">
			<button type="submit">Delete</button>
		</form:form>
	</c:if>
</body>

</html>