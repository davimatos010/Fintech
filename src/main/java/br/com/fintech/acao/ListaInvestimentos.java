package br.com.fintech.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.Usuario;

public class ListaInvestimentos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		InvestimentoDAO dao = new InvestimentoDAO();
		
		List<Investimento> investimentos = dao.listAllFromUser(usuario.getCodigo());
		
		request.setAttribute("investimentos", investimentos);
		
		return "forward:investimentos/lista-table.jsp";
	}

}
