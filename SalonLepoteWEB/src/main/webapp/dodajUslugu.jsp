<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje usluge</title>

 
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
 
 h3{
 	text-align: center;
	font-family: 'Lucida Handwriting';
	font-size: 35px;
	color: #A96AA5;
 }
 
 .tabela {
 	margin: auto;
 }
 
 input[type=text] {
  width: 100%;
  padding: 10px 10px;
  margin: 5px 0;
  box-sizing: border-box;
  border: 3px solid #ccc;
}

input[type=text]:focus {
  border: 3px solid #555;
}

h4{
	color: #555;
	font-family: serif;
}

input[type=button], input[type=submit], input[type=reset] {
  background-color: #FFF5EE;
  border: none;
  color: black;
  padding: 10px 150px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  color: #555;
  font-family: serif;
}

 </style>
 
</head>
<body>

<div>
		<c:if test="${! empty dodaj}">
			<h3>${dodaj }</h3>
			<form action="/SalonLepote/usluge/dodajUslugu" method="post" enctype="multipart/form-data">
				<table class="tabela">
					<tr>
						<td><h4>Naziv usluge:</h4><input type="text" name="naziv"></td>
					</tr>
					<tr>
						<td><h4>Cena:</h4> <input type="text" name="cena"></td>
					</tr>
					<tr>
						<td><h4>Dodaj sliku:</h4> <input type="file" name="slika"></td>
					<tr>
					<tr>
						<td><input type="submit" value="DODAJ"></td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${! empty dodataUsluga }">
			<h3>${dodataUsluga }</h3>
		</c:if>
	</div>

</body>
</html>