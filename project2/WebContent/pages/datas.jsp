<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<form method="post" action="calcularDataFinal">
		<label>Data Inicial</label>
		<input id="data" name="data">
		<label>Tempo em horas</label>
		<input type="text" id="tempo" name="tempo">
		<input type="submit" value="calcular">
	</form>
	
	<br />
	<br />
	
	<label>Data Final</label>
	<input type="text" id="dataFinal" name="dataFinal" readonly="readonly" value="${dataFinal}">
	<label>Dias</label>
	<input type="text" id="dias" name="dias" readonly="readonly" value="${diasFinal}">
	
</body>
<script type="text/javascript">
$( function() {
    $( "#data" ).datepicker({
    	dateFormat: 'dd/mm/yy',
    	dayNamesMin: ["D", "S", "T", "Q", "Q", "S", "S" ],
    	monthNames: [ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" ]
    });
  } );
</script>
</html>