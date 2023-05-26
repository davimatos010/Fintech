package br.com.fintech.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;
import br.com.fintech.entities.Usuario;

public class ListaGastos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		
		RegistroDAO dao = new RegistroDAO();
		
		List<Registro> registros = dao.listAllFromUser(usuario.getCodigo());
		
		request.setAttribute("registros", registros);
		
		return "forward:gastos/lista-table.jsp";
	}

}
