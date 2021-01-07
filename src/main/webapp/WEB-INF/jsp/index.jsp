<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoronaTracker</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    <a href="index"><img alt="logo" src="img/corona.png" style="height: 50px;width: 170px;"></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index" class="a" style="color:blue;">COVID-19 World</a></li>
      <li><a href="index2" class="a" style="color:blue;">COVID-19 AU MAROC</a></li>
    </ul>
  </div>
</nav>
<center>
	<h1 style="color: blue;">PANDÉMIE DE CORONAVIRUS AU COVID-19</h1>
	<h4>Dernière mise à jour: 6 septembre 2020 à 19:05 UTC</h4>
	<div id="container"  style="height: 300px;border-style: ridge; width:40%;">&nbsp;</div><br>
	
	 <button id="demo" class="btn btn-primary" onclick="downloadtable()">Telecharger Le Graphe</button><br><br>
	 
	<div id="container1" style="height: 300px;border-style: ridge; width:40%;"></div><br>
	
	<button id="demo" class="btn btn-primary" onclick="downloadtable2()">Telecharger Le Graphe</button><br><br>
	<br> 
	<div style="border-style: ridge; width:41%;border-color: rgb(201, 76, 76);">
	  <strong>Search:</strong>&nbsp;&nbsp;
	  <input type="text" id="txtSearch2" name="txtSearch2" placeholder="Entrez une lettre" required/>&nbsp;&nbsp;
				<a href="/users/export2" style="font-size: 20px;color: red;">Telecharger La DataSet Excel</a>&nbsp;&nbsp;
				<a href="/users/exportPDF2" style="font-size: 20px;color: red;">Telecharger La DataSet PDF</a>
				
	</div>
	<div class="container">	
		<table class="content-table">
		<thead>
			<tr>
				<th>Pays</th>
				<th>Total des cas</th>
				<th>Nouveaux cas</th>
				<th>Total décès</th>
				<th>Actualités Décès</th>
				<th>Total récupéré</th>
				<th>Cas actifs</th>
				<th>Critique</th>
				<th>Tests</th>
				<th>Population</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach var="dataServiceW" items="${dataServiceW}">
					<tr>
						<td>${dataServiceW.getPlace()}</td>
						<td>${dataServiceW.getTotal_Cases()}</td>
						<td>${dataServiceW.getNew_Cases()}</td>
						<td>${dataServiceW.getTotal_Deaths()}</td>
						<td>${dataServiceW.getNews_Deaths()}</td>
						<td>${dataServiceW.getTotal_Recovered()}</td>
						<td>${dataServiceW.getActives_Cases()}</td>
						<td>${dataServiceW.getCritical()}</td>
						<td>${dataServiceW.getTests()}</td>
						<td>${dataServiceW.getPopulation()}</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>	
</center>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dom-to-image/2.6.0/dom-to-image.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/jquery.js"></script>
<script src="js/index.js"></script>
<script src="js/filter.js"></script>
<script src="js/dow.js"></script>
</html>































