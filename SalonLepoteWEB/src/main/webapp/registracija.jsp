<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registracija</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
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

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  margin:auto;
  width: 60%;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}

select {
	font-size: 25px;
	 width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  border: 1px solid #e7e7e7;
  background-color: #f3f3f3;
}

li {
  float: left;
}

li a {
  display: block;
  color: #666;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #ddd;
}

li a.active {
  color: white;
  background-color: #04AA6D;
}
</style>
</head>
<body>
	<jsp:useBean id="ulogeBean" class="beans.UlogeBean" scope="session"></jsp:useBean>

<ul>
	<li><a href="/SalonLepote/onama.jsp">O nama</a> </li>
	<li><a href="/SalonLepote/auth/getSveUsluge">Usluge koje salon pruza</a></li>
	<li><a href="/SalonLepote/kontakt.jsp">Kontakt</a></li>		
</ul>

	<form action="/SalonLepote/auth/saveUser" method="post">
		<div class="container">
    <h1>Registracija</h1>
    <p>Da biste se registrovali popunite naredna polja</p>
    <hr>

    <label><b>Ime</b></label>
    <input type="text" placeholder="" name="ime" id="ime" required>

    <label for="psw"><b>Prezime</b></label>
    <input type="text" placeholder="" name="prezime" id="prezime" required>
    
    <label for="psw"><b>Username</b></label>
    <input type="text" placeholder="" name="username" id="username" required>

    <label for="psw-repeat"><b>Password</b></label>
    <input type="password" placeholder="" name="password" id="password" required>
    
     <select name="idUloga">
     	<c:forEach items="${ ulogeBean.u}" var="i">
			<option value="${i.idUloga }">${i.naziv }</option>
		</c:forEach>
	</select>
	<hr>
    
    <button type="submit" class="registerbtn">Register</button>
     <div class="container signin">
    <p>Imate nalog? <a href="/SalonLepote/auth/loginPage">Prijavite se</a>.</p>
  </div>
  </div>
  
  
</form>


</body>
</html>