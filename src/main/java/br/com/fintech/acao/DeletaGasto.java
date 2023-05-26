package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Usuario;

public class DeletaGasto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer cd_registro = Integer.valueOf(request.getParameter("id"));
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		RegistroDAO dao = new RegistroDAO();
		
		dao.delete(cd_registro, usuario.getCodigo());
		
		return "redirect:entrada?acao=ListaGastos";
	}

}
