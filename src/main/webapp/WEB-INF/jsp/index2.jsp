<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<h1 style="color: blue;">PANDIAMIE DE CORONAVIRUS COVID-19 AU MAROC </h1>
	<div id="container2" style="height: 400px;border-style: ridge; width:40%;"></div><br>
		 <button id="demo" class="btn btn-primary" onclick="downloadtable3()">Telecharger Le Graphe</button><br><br>
	<div id="container4" style="height: 400px;border-style: ridge; width:40%;"></div><br>
	<button id="demo" class="btn btn-primary" onclick="downloadtable4()">Telecharger Le Graphe</button><br><br>
	<div id="container5" style="height: 400px;border-style: ridge; width:40%;"></div><br>
	<button id="demo" class="btn btn-primary" onclick="downloadtable5()">Telecharger Le Graphe</button><br><br>
	<div class="container">	
		<div style="border-style: ridge; width:75%;">
		<strong>Search:</strong>&nbsp;&nbsp;
			<input type="text" id="txtSearch" name="txtSearch" placeholder="Entrez une lettre" required/> &nbsp;
			<a href="/users/export3" style="font-size: 20px;color: red;">Telecharger La DataSet Excel</a>&nbsp;&nbsp;
			<a href="/users/exportPDF3" style="font-size: 20px;color: red;">Telecharger La DataSet PDF</a>			
		</div>
		<table class="content-table">
		<thead>
			<tr>
				<th>Lieu</th>
				<th>Cas</th>
				<th>Guérisons</th>
				<th>Décès</th>
			</tr>
		</thead>
			<tbody>
					<c:forEach var="dataService2" items="${dataService2}">
					<tr>
						<td>${dataService2.getLieu()}</td>
						<td>${dataService2.getCas()}</td>
						<td>${dataService2.getGuerisons()}</td>
						<td>${dataService2.getDeces()}</td>
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
<script src="js/filter2.js"></script>
<script src="js/dow2.js"></script>
</html>