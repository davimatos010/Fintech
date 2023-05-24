package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;

public class SelecionaReceita implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Refatorar
		int codigoUsuario = 1;
		
		Integer codigoReceita = Integer.valueOf(request.getParameter("id"));
		
		RegistroDAO dao = new RegistroDAO();
		Registro receita = dao.getById(codigoReceita, codigoUsuario);
		
		request.setAttribute("registro", receita);
		
		
		return "forward:receitas/edita-form.jsp";
	}

}
