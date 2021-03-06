<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Faça o login</h1>
	<form action="ServletAutenticacao" method="post">
			<input type="hidden" id="url" name="url" value="<%= request.getParameter("url")%>">
		<table>		
			<tr>
				<td>Login</td>
				<td><input type="text" id="login" name="login"><br /></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><input type="text" id="senha" name="senha"><br /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Logar">	</td>
			</tr>
		</table>
	</form>
</body>
</html>