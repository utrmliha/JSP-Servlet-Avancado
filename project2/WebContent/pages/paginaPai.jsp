<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Página pai Load Jquery</h1>
<input type="button" value="Carregar" onclick="carregarpagina();">

<div id="mostrarPaginaFilha"></div>
<script>
	function carregarpagina(){
		$("#mostrarPaginaFilha").load("paginaFilha.jsp");//Load page em Jquery
	}
</script>
</body>
</html>