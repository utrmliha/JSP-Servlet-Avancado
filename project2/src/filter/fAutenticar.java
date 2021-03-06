package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connection.ConnectionDataBase;
import user.UserLogado;

@WebFilter(urlPatterns = {"/pages/*"})
public class fAutenticar implements Filter {	
	Connection connection;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String urlParaAutenticar = req.getServletPath();		
		UserLogado userlogado = (UserLogado) session.getAttribute("usuario");
		
		if(userlogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/ServletAutenticacao")) {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/autenticar.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			return;//para o resto do codigo e redireciona
		}
			
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		connection = ConnectionDataBase.getConnection();
	}

}
