package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.model.Investimento;
import br.com.fintech.model.Tipo;
import br.com.fintech.model.Usuario;

public class InvestimentoDAO {
	private Connection connection;
	private Usuario usuario;
	private Tipo tipo;
	
	public InvestimentoDAO () {
		this.usuario = new Usuario(0, null, null, null, null, 'T');
		this.tipo = new Tipo(0, null);
	}

	public void insert(Investimento investimento) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_FINTECH_INVESTIMENTO (cd_investimento, cd_usuario, vl_investimento, vl_taxa, "
				+ "nm_inst_financ, cd_tipo, dt_inicio_investimento, dt_final_investimento, ds_investimento)"
				+ "VALUES(SQ_INVESTIMENTO.nextval, ?, ?, ?, "
				+ "?, ?, ?, ?, ?)";

		try {
			connection = OracleDBConnection.getConnection();

			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, investimento.getUsuario().getCodigo());
			stmt.setDouble(2, investimento.getValor());
			stmt.setDouble(3, investimento.getTaxa());
			stmt.setString(4, investimento.getInstituicaoFinanceira());
			stmt.setInt(5, investimento.getTipo().getCodigo());
			stmt.setDate(6, investimento.getDataInicio());
			stmt.setDate(7, investimento.getDataFinal());
			stmt.setString(8, investimento.getDescricao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	public List<Investimento> selectAll() {
		List<Investimento> list = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_FINTECH_INVESTIMENTO");
			res = stmt.executeQuery();

			while(res.next()) {
				Usuario usuario = new Usuario(res.getInt("cd_usuario"), null, null, null, null, 'T');
				Tipo tipo = new Tipo(res.getInt("cd_investimento"), null);

				int codigo = res.getInt("cd_investimento");
				
				double valor = res.getDouble("vl_investimento");
				double taxa = res.getDouble("vl_taxa");
				String instituicaoFinanceira = res.getString("nm_inst_financ");
				Date dataInicio = res.getDate("dt_inicio_investimento");
				Date dataFinal = res.getDate("dt_final_investimento");
				String descricao = res.getString("ds_investimento");


				Investimento investimento = new Investimento(codigo, usuario, valor, taxa, instituicaoFinanceira, tipo, dataInicio);
				investimento.setDataFinal(dataFinal);
				investimento.setDescricao(descricao);

				list.add(investimento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				res.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	public Investimento selectById(int cd_investimento, int cd_usuario) {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Investimento resInvestimento = null;

		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT cd_investimento, cd_usuario, vl_investimento, "
					+ "vl_taxa, nm_inst_financ, cd_tipo, dt_inicio_investimento, dt_final_investimento, ds_investimento "
					+ "FROM T_FINTECH_INVESTIMENTO WHERE cd_usuario = " + cd_usuario + " AND cd_investimento = " + cd_investimento);
			res = stmt.executeQuery();

			if(res.next()) {
				this.usuario.setCodigo(res.getInt("cd_usuario"));
				this.tipo.setCodigo(res.getInt("cd_tipo"));

				int codigo = res.getInt("cd_investimento");
				Usuario usuario = this.usuario;
				double valor = res.getDouble("vl_investimento");
				double taxa = res.getDouble("vl_taxa");
				String instituicaoFinanceira = res.getString("nm_inst_financ");
				Tipo tipo = this.tipo;
				Date dataInicio = res.getDate("dt_inicio_investimento");
				Date dataFinal = res.getDate("dt_final_investimento");
				String descricao = res.getString("ds_investimento");


				resInvestimento = new Investimento(codigo, usuario, valor, taxa, instituicaoFinanceira, tipo, dataInicio);
				resInvestimento.setDataFinal(dataFinal);
				resInvestimento.setDescricao(descricao);

			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				res.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resInvestimento;
	}


	public void update(Investimento investimento) {
		PreparedStatement stmt = null;

		try {
			connection = OracleDBConnection.getConnection();
			String sql = "UPDATE T_FINTECH_INVESTIMENTO "
					+ "SET "
					+ "vl_investimento = ?, " 
					+ "vl_taxa = ?, " 
					+ "nm_inst_financ = ?, " 
					+ "cd_tipo = ?, " 
					+ "dt_inicio_investimento = ?, " 
					+ "dt_final_investimento = ?, " 
					+ "ds_investimento = ? "
					+ "WHERE cd_investimento = ?";

			stmt = connection.prepareStatement(sql);

			stmt.setDouble(1, investimento.getValor());
			stmt.setDouble(2, investimento.getTaxa());
			stmt.setString(3, investimento.getInstituicaoFinanceira());
			stmt.setInt(4, investimento.getTipo().getCodigo());
			stmt.setDate(5, investimento.getDataInicio());
			stmt.setDate(6, investimento.getDataFinal());
			stmt.setString(7, investimento.getDescricao());
			stmt.setInt(8, investimento.getCodigo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	public void delete(int codigoInvestimento, int codigoUsuario) {
		PreparedStatement stmt = null;
		try {
			connection = OracleDBConnection.getConnection();
			String sql = "DELETE FROM T_FINTECH_INVESTIMENTO WHERE cd_investimento = " + codigoInvestimento 
					+ " AND cd_usuario = " + codigoUsuario;
			stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
