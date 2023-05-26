package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;
import br.com.fintech.entities.Usuario;

public class SelecionaReceita implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Integer codigoReceita = Integer.valueOf(request.getParameter("id"));
		
		RegistroDAO dao = new RegistroDAO();
		Registro receita = dao.getById(codigoReceita, usuario.getCodigo());
		
		request.setAttribute("registro", receita);
		
		
		return "forward:receitas/edita-form.jsp";
	}

}
