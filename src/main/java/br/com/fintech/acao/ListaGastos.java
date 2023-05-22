package br.com.fintech.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;

public class ListaGastos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Refactor
		int userId = 1;
		
		RegistroDAO dao = new RegistroDAO();
		
		List<Registro> registros = dao.listAllFromUser(userId);
		
		request.setAttribute("registros", registros);
		
		return "forward:gastos.jsp";
	}

}
