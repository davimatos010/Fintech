package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.RegistroDAO;

public class DeletaGasto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer cd_registro = Integer.valueOf(request.getParameter("id"));
		
		//Refactor
		int cd_usuario = 1;
		
		RegistroDAO dao = new RegistroDAO();
		
		dao.delete(cd_registro, cd_usuario);
		
		return "redirect:entrada?acao=ListaGastos";
	}

}
