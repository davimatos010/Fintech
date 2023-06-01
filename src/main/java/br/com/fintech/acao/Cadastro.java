package br.com.fintech.acao;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.entities.Usuario;
import br.com.fintech.utils.DateParser;

public class Cadastro implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		String generoForm = request.getParameter("genero");
		String genero = null;
		
		if(generoForm.equals("Masculino")) {
			genero = "M";
		} else if (generoForm.equals("Feminino")) {
			genero = "F";
		} else {
			genero = "O";
		}
		
		LocalDate dataNascimento = 
				DateParser.StringToLocalDate(request.getParameter("dataNascimento"), "yyyy-MM-dd");  
		
		Usuario usuario = new Usuario(nome, email, senha, dataNascimento, genero);
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.insert(usuario);
		
		return "redirect:entrada?acao=LoginForm";
	}

}
