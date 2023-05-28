package br.com.fintech.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class LoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = req.getSession();
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm") 
				|| paramAcao.equals("CadastroForm") || paramAcao.equals("Cadastro"));
		
		if(acaoProtegida && usuarioNaoLogado) {
			res.sendRedirect("redirect:entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}



}
