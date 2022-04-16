<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/tabele.css">
<title>Slobodni termini</title>
</head>
<body>

	<h1>Slobodni termini za izabranu uslugu:</h1>
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Vreme</th>
			<th>Kod radnika</th>
			<th>Zakazi</th>
		</tr>
		<c:forEach items="${slobodnitermini}" var="s">
			<tr>
				<td>${s.datum }</td>
				<td>${s.vreme}</td>
				<td>${s.zaposlen.ime } ${ s.zaposlen.prezime}</td>
				<td><a href="/SalonLepote/usluge/zakaziTermin?idSlobodanTermin=${s.idSlobodanTermin }">klik</a></td>
			</tr>
		</c:forEach>
	</table><br>
	
</body>
</html>