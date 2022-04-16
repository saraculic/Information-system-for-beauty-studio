<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>GALERIJA</title>

<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #999999
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>

</head>
<body>

	<div class="w3-container w3-teal">
		<h1>SVE USLUGE U SALONU</h1>
	</div>

	<ul>
		<c:forEach items="${sveUsluge }" var="u">
			<li><a
				href="/SalonLepote/usluge/prikaziSlike?idUsluga=${u.idUsluga }">${u.naziv }</a>
			</li>
		</c:forEach>
	</ul>
	<br>

	<c:if test="${! empty slike}">
	Slike za uslugu: ${izabranaUsluga.naziv }<br>
		<div class="w3-row-padding w3-margin-top">
			<c:forEach var="i" items="${slike}">
				<div class="w3-third">
					<div class="w3-card">
						<img src="${i.url }" alt="Slika" style="width: 100%">
						<div class="w3-container">
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
	</c:if>
</body>
</html>