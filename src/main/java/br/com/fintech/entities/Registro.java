package br.com.fintech.entities;

import java.time.LocalDateTime;

public class Registro {
	int codigo;
	Usuario usuario;
	double valor;
	LocalDateTime dataRegistro = LocalDateTime.now();
	Tipo tipo;
	String descricao;
	String categoria;
	
	public Registro(Usuario usuario, double valor, LocalDateTime dataRegistro, 
			Tipo tipo, String descricao, String categoria) {
		this.usuario = usuario;
		this.valor = valor;
		this.dataRegistro = dataRegistro;
		this.tipo = tipo;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	
	public Registro() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
