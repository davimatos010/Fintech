package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.entities.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
				
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuarioValidado = dao.validate(login, senha);
		
		if(usuarioValidado != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuarioValidado);
			
			return "redirect:entrada?acao=Dashboard";
		} 
		
		return "redirect:entrada?acao=LoginForm";
	}

}
