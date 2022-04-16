<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje termina</title>

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
  padding: 8px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  color: black;
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

select {
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 12px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

</style>

</head>

<body>

<h3>Dodavanje termina: </h3><br><br>

<form action="/SalonLepote/administrator/dodajTermin" method="post">
	Datum: <input type="date" name="datum"><br>
	Vreme: <input type="text" name="vreme"><br>
	Usluga: 
	<select name="idUsluga">
		<c:forEach items="${usluge }" var="u">
				<option value="${u.idUsluga }">${u.naziv }</option>
			</c:forEach>
	</select>
	Zaposleni:
	<select name="idZaposlen">
		<c:forEach items="${zaposleni }" var="z">
				<option value="${z.idZaposlen }">${z.ime } ${z.prezime }</option>
			</c:forEach>
	</select><br><br>
	<input type="submit" value="DODAJ">
</form>

<c:if test="${! empty porukaUspesnosti }">
	${porukaUspesnosti }
</c:if>

</body>
</html>