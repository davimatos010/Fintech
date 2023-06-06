package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.Usuario;

public class SelecionaInvestimento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Integer codigoInvestimento = Integer.valueOf(request.getParameter("id"));
		
		InvestimentoDAO dao = new InvestimentoDAO(); 
				
		Investimento investimento = dao.getById(codigoInvestimento, usuario.getCodigo());
		
		request.setAttribute("investimento", investimento);
		
		return "forward:investimentos/edita-form.jsp";
	}

}
