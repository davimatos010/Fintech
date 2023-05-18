package br.com.fintech.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.RegistroDAO;
import br.com.fintech.entities.Registro;

public class Test implements Acao {

	
		@Override
		public String executa(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			System.out.println("teste");
			
			RegistroDAO dao = new RegistroDAO();
			
			List<Registro> registros = dao.selectAll();
			
			for (Registro registro : registros) {
				System.out.println(registro.getDescricao());
			}
			return null;
		}

	}

