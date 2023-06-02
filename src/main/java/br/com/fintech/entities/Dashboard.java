package br.com.fintech.entities;

public class Dashboard {
	private Usuario usuario;
	private Registro ultimoGasto;
	private Registro ultimoRecebimento;
	private double somaGastos;
	private double somaRecebimentos;
	private double somaInvestimentos;
	private double saldo;
	
	public Dashboard(Usuario usuario, Registro ultimoGasto, Registro ultimoRecebimento, 
			double somaGastos, double somaRecebimentos, double somaInvestimentos) {
		this.usuario = usuario;
		this.ultimoGasto = ultimoGasto;
		this.ultimoRecebimento = ultimoRecebimento;
		this.somaGastos = somaGastos;
		this.somaRecebimentos = somaRecebimentos;
		this.somaInvestimentos = somaInvestimentos;
		this.saldo = this.somaRecebimentos - this.somaGastos;
	}
	
	public Dashboard() {}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Registro getUltimoGasto() {
		return ultimoGasto;
	}

	public void setUltimoGasto(Registro ultimoGasto) {
		this.ultimoGasto = ultimoGasto;
	}

	public Registro getUltimoRecebimento() {
		return ultimoRecebimento;
	}

	public void setUltimoRecebimento(Registro ultimoRecebimento) {
		this.ultimoRecebimento = ultimoRecebimento;
	}

	public double getSomaGastos() {
		return somaGastos;
	}

	public void setSomaGastos(double somaGastos) {
		this.somaGastos = somaGastos;
	}

	public double getSomaRecebimentos() {
		return somaRecebimentos;
	}

	public void setSomaRecebimentos(double somaRecebimentos) {
		this.somaRecebimentos = somaRecebimentos;
	}

	public double getSomaInvestimentos() {
		return somaInvestimentos;
	}

	public void setSomaInvestimentos(double somaInvestimentos) {
		this.somaInvestimentos = somaInvestimentos;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
