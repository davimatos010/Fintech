package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;

public class SelecionaGasto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Refatorar
		int codigoUsuario = 1;
		
		
		Integer codigoGasto = Integer.valueOf(request.getParameter("id"));
		
		RegistroDAO dao = new RegistroDAO();
		Registro gasto = dao.getById(codigoGasto, codigoUsuario);
		
		request.setAttribute("gasto", gasto);
		
		return "forward:gastos/edita-form.jsp";
	}

}
