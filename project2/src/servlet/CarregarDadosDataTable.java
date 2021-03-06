package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoDataTable;
import entidades.Usuario;

@WebServlet("/pages/CarregarDadosDataTable")
public class CarregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CarregarDadosDataTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet sendo chamado pelo datTable");
		try {
			daoDataTable dao = new daoDataTable();
			List<Usuario> usuarios = dao.listar();
			
			if(!usuarios.isEmpty()) {
				
				String data = "";
				int totalUsuarios = usuarios.size();
				int index = 1;
				
				for (Usuario usuario : usuarios) {
					data += "["+
						        "\""+usuario.getId()+"\","+
						        "\""+usuario.getNome()+"\","+
						        "\" FOTO \","+
						        "\" "+usuario.getLogin()+" \","+
						        "\" "+usuario.getSenha()+" \","+
						        "\" "+usuario.getTelefone()+" \","+
								"\" "+usuario.getCidade()+" \","+
						        "\" "+usuario.getCep()+" \""+
						    "]";
					if(index < totalUsuarios) {
						data +=",";
					}
					index++;
				}
			
				
				String json ="{"+
					    "\"draw\": 1,"+
					    "\"recordsTotal\": "+usuarios.size()+","+
					    "\"recordsFiltered\": "+usuarios.size()+","+
					    "\"data\": ["+
					      //INICIO - processa a lista de dados
					        data +
					      //FIM - processa a lista de dados					        
					    "]"+
					"}";
				
				response.setStatus(200);//resposta completa OK
				response.getWriter().write(json);//json de resposta (escreve a resposta Http)
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
