<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/tabele.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prikaz usluga</title>

<style type="text/css">

input[type=submit] {
  background-color: #A96AA5;
  border: none;
  color: white;
  padding: 15px 200px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  font-family: serif;
}

ul {
  list-style-type: none;
  margin-left: 100px;
  padding: 0;
  overflow: hidden;
  position: fixed;
  bottom: 0;
  width: 100%;
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

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}

	
</style>

</head>
<body>
	<h1>Usluge koje salon pruza</h1>
	<br><br>
		<table border="1" class="center">
			<tr>
				<th>Naziv usluge</th>
				<th>Cena</th>
				<th>Slobodni termini</th>
			</tr>
			<c:forEach items="${usluge }" var="u">
				<tr>
					<td>${u.naziv }</td>
					<td>${u.cena }</td>
					<td><a href="/SalonLepote/usluge/slobodnitermini?idUsluga=${u.idUsluga }">klik</a></td>
				</tr>
			</c:forEach>
		</table>

<br><br>

	<security:authorize access="hasRole('Administrator')">
		<div class="dugmici">
			<ul>
				<li>
					<form action="/SalonLepote/usluge/dodajUsluguDugme" method="get">
						<input type="submit" value="Dodaj novu uslugu">
					</form>
				</li>
				<li>
					<form action="/SalonLepote/usluge/getSveUsluge" method="get">
						<input type="submit" value="Azuriraj cenu">
					</form>
				</li>
				<li><form action="/SalonLepote/usluge/getSveUslugeZaBrisanje"
					method="get">
					<input type="submit" value="Obrisi uslugu">
				</form>
				</li>
				</ul>
</div>	
</security:authorize>

</body>
</html>