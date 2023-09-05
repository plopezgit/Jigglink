<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update a concept</title>
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
	<h2>Check-in a concept</h2>

	<form:form action="updateConcept" modelAttribute="concept"
		method="POST">
		<form:hidden path="idconcept" />
		<form:hidden path="itinerary.itineraryID" />
		<table>
			<tr>
				<td>Concept:</td>
				<td><form:input size="50" path="titleConcept" /></td>
			</tr>
			<tr>
				<td>Size your estimated effort:</td>
				<td><form:radiobutton path="effortEstimationConcept" value="S"
						label="Small" /> <form:radiobutton path="effortEstimationConcept"
						value="M" label="Medium" /> <form:radiobutton
						path="effortEstimationConcept" value="L" label="Large" /></td>
			</tr>
			<tr>
				<td>Notes:</td>
				<td><form:textarea rows="6" cols="50" path="notesconcept" /></td>
			</tr>
			<tr>
				<td>What is it?":</td>
				<td><form:textarea rows="6" cols="50" path="whatConcept" /></td>
			</tr>
			<tr>
				<td>How is it?":</td>
				<td><form:textarea rows="6" cols="50" path="howConcept" /></td>
			</tr>
			<tr>
				<td>Why is it?":</td>
				<td><form:textarea rows="6" cols="50" path="whyConcept" /></td>
			</tr>
			<form:hidden path="checkInCounterConcept" />
		</table>
		<br />
		<td colspan="2"><input type="submit" value="Check-in"></td>
	</form:form>
	<br />
	<br />
</body>
</html>