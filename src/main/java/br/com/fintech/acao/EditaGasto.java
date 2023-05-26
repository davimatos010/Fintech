package br.com.fintech.acao;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;
import br.com.fintech.entities.Tipo;
import br.com.fintech.entities.Usuario;
import br.com.fintech.utils.DateParser;

public class EditaGasto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Registro gasto = new Registro();
		
		Tipo tipo = new Tipo();
		tipo.setCodigo(2);
		
		gasto.setUsuario(usuario);
		
		gasto.setTipo(tipo);
		
		Integer codigo = Integer.valueOf(request.getParameter("id"));
		gasto.setCodigo(codigo);
		
		LocalDateTime dataRegistro = DateParser.StringToLocalDateTime(request.getParameter("dataRegistro"), "yyyy-MM-dd");
		gasto.setDataRegistro(dataRegistro);
		
		Double valor = Double.valueOf(request.getParameter("valor"));
		gasto.setValor(valor);
		
		String categoria = request.getParameter("categoria");
		gasto.setCategoria(categoria);
		
		String descricao = request.getParameter("descricao");
		gasto.setDescricao(descricao);
		
		RegistroDAO dao = new RegistroDAO();
		dao.update(gasto);
		
		return "redirect:entrada?acao=ListaGastos";
	}

}
