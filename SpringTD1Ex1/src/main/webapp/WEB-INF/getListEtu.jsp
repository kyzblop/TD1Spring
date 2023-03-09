<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.inti.model.Etudiant"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getListeEtudiant</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>

	<h1>Liste de tous les etudiants</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">nom</th>
				<th scope="col">prenom</th>
				<th scope="col">tel</th>
				<th scope="col">mail</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="etu" items="${ etuAll }">
			<tr>
				<th scope="row">${ etu.getId() }</th>
				<td>${ etu.getNom() }</td>
				<td>${ etu.getPrenom() }</td>
				<td>${ etu.getTel() }</td>
				<td>${ etu.getMail() }</td>
			</tr>	
		</c:forEach>
		
		</tbody>
	</table>
</body>
</html>