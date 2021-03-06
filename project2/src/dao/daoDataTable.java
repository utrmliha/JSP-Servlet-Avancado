package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDataBase;
import entidades.Usuario;

public class daoDataTable {
	Connection connection;
	
	public daoDataTable() {
		connection = ConnectionDataBase.getConnection();
	}

	public List<Usuario> listar(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
		String sql = "select * from usuarios";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery();
		
		while(resultado.next()) {
			Usuario user = new Usuario();
			user.setId(resultado.getString("id"));
			user.setNome(resultado.getString("nome"));
			user.setLogin(resultado.getString("login"));
			user.setSenha(resultado.getString("senha"));
			user.setTelefone(resultado.getString("telefone"));
			user.setCidade(resultado.getString("cidade"));
			user.setCep(resultado.getString("cep"));
			
			usuarios.add(user);
		}		
		return usuarios;
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
