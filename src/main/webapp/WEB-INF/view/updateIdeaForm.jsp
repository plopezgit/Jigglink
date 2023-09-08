<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store an idea</title>
<style>
body {
	font-family: Arial;
	padding: 20px;
	background-color: #white;
}

h1 {
	text-align: left;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #feff9c;
}
</style>
</head>
<body>
	<c:forEach var="temp" items="${tableListItinerary}">
		<h1>
			<em>${temp.itineraryname}</em> itinerary
		</h1>
	</c:forEach>
	<br>
	<h2>Update an idea</h2>

	<form:form action="updateIdea" modelAttribute="idea" method="POST">
		<table>
			<form:hidden path="ideaID" />
			<form:hidden path="concept.idconcept" />
			<tr>
				<td>Idea:</td>
				<td><form:textarea rows="6" cols="50" path="titleIdea" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:textarea rows="6" cols="50" path="descriptionIdea" /></td>
			</tr>
		</table>
		<br />
		<td colspan="2"><input type="submit" value="Update"></td>
	</form:form>


</body>
</html>