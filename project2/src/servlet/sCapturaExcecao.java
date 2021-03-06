package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/sCapturaExcecao")
public class sCapturaExcecao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sCapturaExcecao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{//vai pegar o valor passado no form e tenar converter para int, se for um texto, dará erro
			String valor = request.getParameter("nomeParam");
			Integer.parseInt(valor);
			
			response.setStatus(200);// 200: tudo OK
			response.getWriter().write("Processada com sucesso");
		}catch (Exception e){
			response.setStatus(500);// 500: Erro interno do servidor
			response.getWriter().write("Erro ao processar: "+e.getMessage());
			
		}
	}

}
