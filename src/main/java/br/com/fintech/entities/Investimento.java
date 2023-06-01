package br.com.fintech.entities;

import java.time.LocalDate;

public class Investimento {
	Integer codigo;
	Usuario usuario;
	double valor;
	double taxa;
	String instituicaoFinanceira;
	Tipo tipo;
	LocalDate dataInicio;
	LocalDate dataFinal;
	String descricao;

	public Investimento(Usuario usuario, double valor, double taxa, String instituicaoFinanceira, 
			Tipo tipo, LocalDate dataInicio, LocalDate dataFinal, String descricao) {
		this.usuario = usuario;
		this.valor = valor;
		this.taxa = taxa;
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
	}
	
	public Investimento() {};

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}


