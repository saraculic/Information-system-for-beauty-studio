<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos zaposlenog</title>

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

<security:authorize access="hasRole('Administrator')">
 	<form action="/SalonLepote/administrator/saveZaposlen" method="post">
 	<h3>Unos novog zaposlenog:</h3>
 	<table>
 		<tr>
 			<td><h4>Ime:</h4></td>
 			<td><input type="text" name="ime"></td>
 		<tr>
 		<tr>
 			<td><h4>Prezime:</h4></td>
 			<td><input type="text" name="prezime"></td>
 		</tr>
 		<tr>
 			<td><h4>Telefon:</h4></td>
 			<td><input type="text" name="tel"></td>
 		</tr>
 		<tr>
 			<td><h4>Plata:</h4></td>
 			<td><input type="text" name="plata"></td>
 		</tr>
 		<tr>
 			<td><input type="submit" value="SACUVAJ"></td>
 			<td></td>
 		</tr>
 		</table>
 	</form>
 	
 	<c:if test="${! empty poruka }">
 		${poruka }
 	</c:if>
	<br><br><a href="/SalonLepote/pocetna.jsp">Povratak na pocetnu stranicu</a>
 </security:authorize>

</body>
</html>