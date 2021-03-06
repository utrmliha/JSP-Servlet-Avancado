<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Table</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
  

</head>
<body>

	<table id="minhatabela" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Foto</th>
				<th>Login</th>
				<th>Senha</th>
				<th>Telefone</th>
				<th>Cidade</th>
				<th>Cep</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>

	<script>
	$(document).ready( function () {//Faz o processamento na hr q a pagina abre por isso n tem uma function()
		$('#minhatabela').DataTable( {
		    ajax: 'CarregarDadosDataTable' //Url de retorno de dados do servidor (resposta do servidor)
		} );

	} );
	</script>
</body>
</html>