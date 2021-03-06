package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/calcularDataFinal")
public class calcularDataFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public calcularDataFinal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 08:00-12:00 e 13:30 e 17:30
		 * 1 dia é igual a 8 horas de trabalho*/
		
		try {
			
			int horaDia = 8;
			Date dataCalculada = null;
			Double totalDeDias = 0.0;
			
			String data = request.getParameter("data");
			int tempo = Integer.parseInt(request.getParameter("tempo"));
			
			if(tempo <= horaDia) {//se o tempo for <= a 8 é 1dia de trabalho
				
				//transforma a string do campo data do jsp em um objeto Data para ser manipulado
				Date dataInformada = new SimpleDateFormat("dd/mm/yyyy").parse(data);
				//cria uma instancia de um objeto calendario para manipulação
				Calendar calendar = Calendar.getInstance();
				
				//seta no objeto calendario a data
				calendar.setTime(dataInformada);
				//Adiciona 1 dia ao calendario
				calendar.add(Calendar.DATE, 1);
				
				//atribui á variável dataCalculada a data calculada no calendar
				dataCalculada = calendar.getTime();
				totalDeDias = 1.0;
				
			}else {//for maior que 8hrs é mais q um dia
				/*divide o tempo pela horaDia para achar a qntidade de dias ex:
				 * 16 horas / 8 = 2Dias */				 
				totalDeDias = (double) (tempo / horaDia);
				
				if(totalDeDias <= 1) {
					dataCalculada = new SimpleDateFormat("dd/mm/yyyy").parse(data);
				}else {
					//transforma a string do campo data do jsp em um objeto Data para ser manipulado
					Date dataInformada = new SimpleDateFormat("dd/mm/yyyy").parse(data);
					//cria uma instancia de um objeto calendario para manipulação
					Calendar calendar = Calendar.getInstance();
					
					//seta no objeto calendario a data
					calendar.setTime(dataInformada);
					//Adiciona os dias calculados ao calendario
					calendar.add(Calendar.DATE, totalDeDias.intValue());
					
					//atribui á variável dataCalculada a data calculada no calendar
					dataCalculada = calendar.getTime();
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/datas.jsp");
			request.setAttribute("dataFinal", new SimpleDateFormat("dd/mm/yyyy").format(dataCalculada));
			request.setAttribute("diasFinal", totalDeDias);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
