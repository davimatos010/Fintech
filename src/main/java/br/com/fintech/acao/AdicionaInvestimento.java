package br.com.fintech.acao;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.Tipo;
import br.com.fintech.entities.Usuario;
import br.com.fintech.utils.DateParser;

public class AdicionaInvestimento implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Investimento investimento = new Investimento();
		
		investimento.setUsuario(usuario);
		
		Double valor = Double.valueOf(request.getParameter("valor"));
		
		investimento.setValor(valor);
		
		Double taxa = Double.valueOf(request.getParameter("taxa"));
		
		investimento.setTaxa(taxa);
		
		investimento.setInstituicaoFinanceira(request.getParameter("instituicaoFinanceira"));
		
		Tipo tipo = new Tipo();
		tipo.setNome(request.getParameter("tipo"));
		
		if(tipo.getNome().equals("Renda Variável")) {
			tipo.setCodigo(4);
		} else {
			tipo.setCodigo(3);
		}
		
		investimento.setTipo(tipo);
		
		LocalDate dataInicio = DateParser.StringToLocalDate(request.getParameter("dataInicio"), "yyyy-MM-dd");
		investimento.setDataInicio(dataInicio);
		
		LocalDate dataFinal = DateParser.StringToLocalDate(request.getParameter("dataFinal"), "yyyy-MM-dd");
		investimento.setDataFinal(dataFinal);
		
		investimento.setDescricao(request.getParameter("descricao"));
		
		InvestimentoDAO dao = new InvestimentoDAO();
		dao.insert(investimento);
		
		
		return "redirect:entrada?acao=ListaInvestimentos";
	}

}
