<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Svi zaposleni</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/tabele.css">
	


</head>
<body>
<h1>Svi zaposleni radnici</h1>
	<div class="container">
		<table class="tabela">
			<thead>
				<tr>
					<th>IME</th>
					<th>PREZIME</th>
					<th>TELEFON</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${zaposleni }" var="z">
					<tr>
						<td>${z.ime }</td>
						<td>${z.prezime }</td>
						<td>${z.tel }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



</body>
</html>