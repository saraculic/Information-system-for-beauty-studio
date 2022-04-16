<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Pocetna</title>
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
	body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
	.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
	.w3-third img:hover{opacity: 1}
</style>
</head>
<body>

<div class="vertical-menu">
<div class="sidenav">
  <a href="/SalonLepote/onama.jsp">O nama</a><br>
  <a href="/SalonLepote/auth/getSveUsluge">Usluge koje salon pruža</a><br>
  <a href="/SalonLepote/usluge/sveUsluge">Galerija</a><br>
  <a href="/SalonLepote/kontakt.jsp">Kontakt</a><br>

  <security:authorize access="hasRole('Administrator')">
	<a href="/SalonLepote/administrator/sviZaposleni">Prikaz svih zaposlenih</a><br>
	<a href="/SalonLepote/unosZaposlenog.jsp">Unos novog zaposlenog</a><br>
	<a href="/SalonLepote/azuriranjeZaposlenog.jsp">Azuriranje podataka o zaposlenom</a><br>
	<a href="/SalonLepote/brisanjeZaposlenog.jsp">Brisanje zaposlenog</a><br>
	<a href="/SalonLepote/administrator/getUslugeIZaposleni">Dodavanje slobodnih termina</a><br>
	<a href="/SalonLepote/administrator/getUsluge">Dodavanje slika</a><br>
	<a href="/SalonLepote/administrator/getSviZaposleniReport">Svi zaposleni - izvestaj</a><br>
	<a href="/SalonLepote/auth/logout">Odjava</a><br>
</security:authorize>
 
 <security:authorize access="hasRole('Zaposlen')">
 	<a href="/SalonLepote/zaposlen/prikazPlate">Prikaz plate</a><br>
 	<a href="/SalonLepote/zaposlen/prikazZakazanihTermina">Prikaz svojih zakazanih termina</a><br>
 </security:authorize>
 
 <security:authorize access="hasRole('Korisnik')">
 	<a href="/SalonLepote/musterija/ostavljanjeKomentara">Napisi komentar</a><br>
 </security:authorize>

</div>
</div>


<div class="main">
<div class="center" style="font-size:25px; text-align:center;">
Dobrodosli 
	<security:authorize access="isAuthenticated()">
	     <security:authentication property="principal.username" /> 
	</security:authorize>
 
 <security:authorize access="hasRole('Korisnik')">
 	<c:if test="${! empty komentar }">
 	<form action="/SalonLepote/musterija/saveKomentar" method="post">
 		Napisi komentar: <br>
		 	<input type="text" name="kom">
		 	<input type="submit" value="OK">
 	</form>
 	 </c:if>
 	<c:if test="${! empty ostavljenKomentar }">
 		${ostavljenKomentar }
 	</c:if>
 </security:authorize>
 
 
  <security:authorize access="hasRole('Zaposlen')">
  <br>
  	<c:if test="${! empty plata }">
  		Tvoja plata je ${plata } RSD.
  	</c:if>
  	<c:if test="${! empty zakazaniTermini }">
  		<c:forEach items="${zakazaniTermini }" var="z">
  			Datum: ${z.datum }, ${z.vreme }h, ${z.usluga.naziv } <br>
  		</c:forEach>
  	</c:if>
 </security:authorize>

</div>
</div>
</body>
</html>