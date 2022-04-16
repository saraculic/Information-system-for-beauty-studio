<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Azuriranje zaposlenog</title>

<style type="text/css">
body {
	background-image: linear-gradient(-225deg, #E3FDF5 0%, #FFE6FA 100%);
	background-image: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);
	background-attachment: fixed;
	background-repeat: no-repeat;
	font-family: 'Vibur', cursive;
	/*   the main font */
	font-family: 'Abel', sans-serif;
	opacity: .95;
	/* background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%); */
}

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  color: black;
  background-color: #f1f1f1;
}

input[type=submit] {
  background-color: #C0C0C0;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

 h3{
 	text-align: left;
	font-family: 'Lucida Handwriting';
	font-size: 20px;
	color: #A96AA5;
 }
 
 h4 {
 	color: #555;
	font-family: serif;
	font-size: 20px;
	
 }

a {
	color: #555;
	font-family: serif;
	font-size: 20px;
}


</style>


</head>
<body>
<h3>Azuriranje podataka o zaposlenom radniku:<br> </h3>

<form action="/SalonLepote/administrator/nadjiZaposlenog" method="post">
<table>
	<tr>
		<td>Ime:</td>
		<td><input type="text" name="ime"></td>
	</tr>
	<tr>
		<td>Prezime:</td>
		<td><input type="text" name="prezime"></td>
	</tr>
	<tr>
		<td><input type="submit" value="OK"></td>
		<td></td>
	</tr>
</table>
</form>
<br><br>

<c:if test="${! empty zaposlen }">
	<table>
		<tr>
			<td>${zaposlen.ime }</td>
		</tr>
		<tr>
			<td>${zaposlen.prezime }</td>
		</tr>
		<tr>
			<td>Plata: ${zaposlen.plata }</td>
		</tr>
		<tr>
			<td>Tel:  ${zaposlen.tel }</td>
		</tr>
		<tr>
			<td>
				<form action="/SalonLepote/administrator/promeniPlatu" method="post">
					<input type="submit" value="PROMENI PLATU">
				</form>
			</td>
		</tr>
	</table>
	<br>
	<c:if test="${! empty novaPlata }">
		<h4>Unesite novu platu radnika:<br></h4>
		<form action="/SalonLepote/administrator/postaviNovuPlatu" method="post">
			<input type="text" name="plata" style="width: 150px">
			<input type="submit" value="OK">
		</form>
	</c:if>
	
	<c:if test="${! empty poruka }">
		${poruka }
	</c:if>
</c:if>


<br><br><a href="/SalonLepote/pocetna.jsp">Povratak na pocetnu stranicu</a>
</body>
</html>