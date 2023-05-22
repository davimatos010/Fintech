package br.com.fintech.entities;

public class Tipo {
	private int codigo;
	private String nome;


	public Tipo(String nome) {
		this.nome = nome;
	}
	
	public Tipo () {}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}

