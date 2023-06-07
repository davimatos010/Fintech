package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.entities.Usuario;

public class DeletaInvestimento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer cd_investimento = Integer.valueOf(request.getParameter("id"));
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Integer cd_usuario = usuario.getCodigo();
		
		
		InvestimentoDAO dao = new InvestimentoDAO();
		
		dao.Delete(cd_investimento, cd_usuario);
		
		return "redirect:entrada?acao=ListaInvestimentos";
	}

}
