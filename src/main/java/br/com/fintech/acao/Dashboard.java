package br.com.fintech.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.DashboardDAO;
import br.com.fintech.entities.Usuario;

public class Dashboard implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		DashboardDAO dao = new DashboardDAO();
		
		br.com.fintech.entities.Dashboard dashboard = dao.makeDashboard(usuario.getCodigo());
		
		request.setAttribute("dashboard", dashboard);
		
		return "forward:dashboard/dashboard-table.jsp";
	}

}
