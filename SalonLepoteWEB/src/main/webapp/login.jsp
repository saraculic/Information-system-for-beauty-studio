<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/login.css">
<meta charset="UTF-8">
<title>Prijava</title>


</head>
<body>

<div class="sidenav">
  <a href="/SalonLepote/onama.jsp">O nama</a>
  <a href="/SalonLepote/kontakt.jsp">Kontakt</a>
  
  <security:authorize access="isAuthenticated()">
	<a href="/SalonLepote/auth/logout">Odjava</a>
</security:authorize>
</div>


<div class="main">
	<div class="center" style="font-size:30px; text-align:center;">

	<c:url var="loginUrl" value="/login" />
 	<form action="${loginUrl}" method="post">
 		   <div class="con">
   <!--     Start  header Content  -->
   <header class="head-form">
      <h2>Log In</h2>
      <!--     A welcome message or an explanation of the login form -->
      <p>unesite username i password</p>
   </header>
   <!--     End  header Content  -->
   <br>
   <div class="field-set">
      <!--   user name -->
         <span class="input-item">
           <i class="fa fa-user-circle"></i>
         </span>
        <!--   user name Input-->
         <input class="form-input" id="txt-input" type="text" name="username"
					placeholder="username" required>
     
      <br>
           <!--   Password -->
      <span class="input-item">
        <i class="fa fa-key"></i>
       </span>
      <!--   Password Input-->
      <input class="form-input" type="password" placeholder="Password" id="pwd"  name="password" required>
     
<!--      Show/hide password  -->
     <span>
        <i class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>
     </span>
      <br>
<!--        buttons -->
<!--      button LogIn -->
      <button class="log-in"> Log In </button>
   </div>
  
<!--   other buttons -->
   <div class="other">
<!--    Zapamti me: <input type="checkbox" name="remember-me" /><br> -->
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	Nemate nalog? <a href="/SalonLepote/auth/uloge">Registrujte se</a>
   </div>
     
<!--   End Conrainer  -->
  </div>
	</form>
	</div>
</div>


</body>
</html>