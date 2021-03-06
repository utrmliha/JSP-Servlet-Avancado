<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Captura de Exceções</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>Capturando Exceção</h1>
		<input type="text" value="teste" id="txtValor" name="txtValor">
		<input type="button" onclick="testeJquery();" value="testar">
<script>
	function testeJquery(){
		var valor = $('#txtValor').val();
		
		$.ajax({
			method: "post", //método 
			url: "sCapturaExcecao", //para qual servlet
			data: {nomeParam: valor}
			})
				.done(function(response){ //resposta ok - nenhum erro
					alert("Sucesso "+ response);
					//faz algo 
				})
				.fail(function(xhr, status, errorThrown){ //resposta erro - algum erro ocorreu
					alert("Error: "+ xhr.responseText);//xhr.responseText pega a msg de erro do servidor
					//faz algo se der errado
				});		
	}
</script>
</body>
</html>