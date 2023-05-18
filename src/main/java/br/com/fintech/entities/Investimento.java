package br.com.fintech.entities;

import java.sql.Date;

public class Investimento {
	int codigo;
	Usuario usuario;
	double valor;
	double taxa;
	String instituicaoFinanceira;
	Tipo tipo;
	Date dataInicio;
	Date dataFinal;
	String descricao;

	public Investimento(int codigo, Usuario usuario, double valor, double taxa, String instituicaoFinanceira, Tipo tipo, Date dataInicio) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.valor = valor;
		this.taxa = taxa;
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
	}

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}


