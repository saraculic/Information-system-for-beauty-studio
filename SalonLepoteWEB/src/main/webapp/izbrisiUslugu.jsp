<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brisanje usluge</title>

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

select {
  width: 20%;
  padding: 16px 20px;
  border: none;
  border-radius: 10px;
  background-color: #f1f1f1;
}

 h3{
 	text-align: left;
	font-family: 'Lucida Handwriting';
	font-size: 20px;
	color: #A96AA5;
 }
 
input[type=submit] {
  background-color: #C0C0C0;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>

</head>
<body>

<c:if test="${! empty sveUslugeZaBrisanje }">
<h3>Brisanje odredjene usluge</h3>
		<form action="/SalonLepote/usluge/brisanjeUsluge" method="post">
			<select name="idUsluga">
				<c:forEach items="${sveUslugeZaBrisanje }" var="u">
					<option value="${u.idUsluga }">${u.naziv }</option>
				</c:forEach>
			</select><br>
			<input type="submit" value="OBRISI">
		</form>
	</c:if>
	<br>
	<c:if test="${! empty obrisana }">
		${obrisana }
	</c:if>

</body>
</html>