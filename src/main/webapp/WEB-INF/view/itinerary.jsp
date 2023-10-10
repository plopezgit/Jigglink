<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta charset="UTF-8">
<title>Jiggilink</title>
<style type="text/css">
body {
	font-family: Arial;
	padding: 20px;
	background-color: #white;
}

.flip-cards {
	display: flex;
	flex-flow: row wrap;
	justify-content: space-around;
	/*padding: 0;*/
	margin: 0;
	list-style: none;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
}

.flip-card {
	background-color: transparent;
	width: 350px;
	height: 390px;
	perspective: 1000px;
	margin-top: 20px;
	padding: 10px 10px
}

.flip-card-inner {
	position: relative;
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 1s;
	transform-style: preserve-3d;
}

.flip-card:hover .flip-card-inner {
	transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
	position: absolute;
	border-radius: 5px;
	width: 100%;
	height: 100%;
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
}

.flip-card-front {
	background-color: #feff9c;
	color: black;
}

.flip-card-back {
	font-size: 12px;
	background-color: #feff9c;
	color: black;
	transform: rotateY(180deg);
}

.flip-cards1 {
	display: flex;
	flex-flow: row wrap;
	justify-content: space-around;
	/*padding: 0;*/
	margin: 0;
	list-style: none;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
}

.flip-card1 {
	background-color: transparent;
	width: 350px;
	height: 390px;
	perspective: 1000px;
	margin-top: 20px;
	padding: 10px 10px
}

.flip-card-inner1 {
	position: relative;
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 1s;
	transform-style: preserve-3d;
}

.flip-card1:hover .flip-card-inner1 {
	transform: rotateY(180deg);
}

.flip-card-front1, .flip-card-back1 {
	position: absolute;
	border-radius: 5px;
	width: 100%;
	height: 100%;
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
}

.flip-card-front1 {
	font-size: 30px;
	background-color: #feff9c;
	color: black;
}

.flip-card-back1 {
	font-size: 20px;
	background-color: #feff9c;
	color: black;
	transform: rotateY(180deg);
}

.flip-cards2 {
	display: flex;
	flex-flow: row wrap;
	justify-content: space-around;
	/*padding: 0;*/
	margin: 0;
	list-style: none;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
}

.flip-card2 {
	background-color: transparent;
	width: 350px;
	height: 390px;
	perspective: 1000px;
	margin-top: 20px;
	padding: 10px 10px
}

.flip-card-inner2 {
	position: relative;
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 1s;
	transform-style: preserve-3d;
}

.flip-card2:hover .flip-card-inner2 {
	transform: rotateY(180deg);
}

.flip-card-front2, .flip-card-back2 {
	position: absolute;
	border-radius: 5px;
	width: 100%;
	height: 100%;
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
}

.flip-card-front2 {
	font-size: 20px;
	background-color: #feff9c;
	color: black;
}

.flip-card-back2 {
	font-size: 20px;
	background-color: #feff9c;
	color: black;
	transform: rotateY(180deg);
}

.img-container {
	text-align: right;
}
</style>
</head>
	<c:forEach var="temp" items="${tableListItinerary}">
		<c:url var="storeConceptLink" value="/itinerary/storeConceptForm">
			<c:param name="iid" value="${temp.itineraryID}" />
		</c:url>
		<c:url var="putBadge" value="/itinerary/putBadges">
			<c:param name="iid" value="${temp.itineraryID}" />
		</c:url>
		<h1>
			<em>${temp.itineraryname}</em> itinerary
		</h1>
		<p>
			Hi ${temp.user.username}, <b>Target date:</b> ${temp.targetDate} / <b>Remaining
				days:</b> ${itineraryRemainingDays} / <b>Itinerary points:</b>
			${temp.itinerarypoints}
	</c:forEach>
	<h2>Concepts</h2>
	<p style="text-align: center;">
		<a href="${storeConceptLink}"><i class="material-icons"
			style="font-size: 40px; color: black;">add</i></a>
	</p>
	<div class="flip-cards">
		<c:url var="storeConceptLink" value="/itinerary/storeConceptForm">
		</c:url>
		<c:forEach var="temp" items="${tableListConcept}">
			<c:url var="updateLink" value="/itinerary/updateConceptForm">
				<c:param name="id" value="${temp.idconcept}" />
				<c:param name="iid" value="${temp.itinerary.itineraryID}" />
			</c:url>
			<c:url var="updateWithTimerLink" value="/itinerary/updateConceptThroughTimerForm">
				<c:param name="id" value="${temp.idconcept}" />
				<c:param name="iid" value="${temp.itinerary.itineraryID}" />
			</c:url>
			<c:url var="storeIdeaLink" value="/itinerary/storeIdeaForm">
				<c:param name="id" value="${temp.idconcept}" />
				<c:param name="iid" value="${temp.itinerary.itineraryID}" />
			</c:url>
			<c:url var="deleteLink" value="/itinerary/delete">
				<c:param name="id" value="${temp.idconcept}" />
			</c:url>
			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<h1>${temp.titleConcept}</h1>
						<p style="padding: 10px 10px">${temp.notesconcept}</p>
					</div>
					<div class="flip-card-back">
						<p style="padding: 10px 10px">${temp.whatConcept}</p>
						<p style="padding: 10px 10px">${temp.howConcept}</p>
						<p style="padding: 10px 10px">${temp.whyConcept}</p>
						<p style="padding: 10px 10px">
							<b>Effort size:</b> ${temp.effortEstimationConcept} / <b>Check-in
								counter:</b> ${temp.checkInCounterConcept}
						</p>
						<br /> <a href="${updateLink}"><i class="material-icons"
							style="font-size: 34px; color: black; fontsize: 14px;">edit</i></a>
							<a href="${updateWithTimerLink}"><i class="material-icons"
							style="font-size: 34px; color: black; fontsize: 14px;">timer</i></a>
						<a href="${storeIdeaLink}"><i class="material-icons"
							style="font-size: 34px; color: black;">lightbulb</i></a> <a
							href="${deleteLink}"><i class="material-icons"
							style="font-size: 34px; color: black;"
							onclick="if(!(confirm('The concept will be deleted. Are you sure?'))) return false">delete</i></a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<br />
	<h2>Ideas</h2>
	<div class="flip-cards1">

		<c:forEach var="temp" items="${tableListIdeas}">
			<c:url var="updateLink" value="/itinerary/updateIdeaForm">
				<c:param name="id" value="${temp.ideaID}" />
				<c:param name="cid" value="${temp.concept.idconcept}" />
			</c:url>
			<c:url var="deleteIdeaLink" value="/itinerary/deleteIdea">
				<c:param name="id" value="${temp.ideaID}" />
			</c:url>
			<div class="flip-card1">
				<div class="flip-card-inner1">
					<div class="flip-card-front1">
						<p style="padding: 10px 10px">${temp.titleIdea}</p>
					</div>
					<div class="flip-card-back1">
						<p style="padding: 10px 10px">${temp.descriptionIdea}</p>
						<a href="${updateLink}"><i class="material-icons"
							style="font-size: 24px; color: black;">edit</i></a> <a
							href="${deleteIdeaLink}"><i class="material-icons"
							style="font-size: 24px; color: black;"
							onclick="if(!(confirm('The idea will be deleted. Are you sure?'))) return false">delete</i></a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<br />
	<h2>Badges</h2>
	<p style="text-align: center;">
		<a href="${putBadge}"> <i class="material-icons"
			style="font-size: 40px; color: black; vertical-align: middle;"
			onclick="if(${temp.itinerarypoints}=0) if(!(confirm('Do you want to redeem ${temp.itinerarypoints} points?'))) return false">refresh</i></a>
	</p>
	<div class="flip-cards2">
		<c:forEach var="temp" items="${tableListBadge}">
			<div class="flip-card2">
				<div class="flip-card-inner2">
					<div class="flip-card-front2">
						<p style="padding: 10px 10px">
							<i class="material-icons"
								style="font-size: 300px; color: #ccbd20;">${temp.icon}</i>
						</p>
					</div>
					<div class="flip-card-back2">
						<p style="padding: 10px 10px">
							<b>${temp.badgeName}</b>
						</p>
						<p style="padding: 10px 10px">${temp.coachMessage}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>