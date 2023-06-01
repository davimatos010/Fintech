package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.Tipo;
import br.com.fintech.entities.Usuario;
import br.com.fintech.utils.DateParser;

public class InvestimentoDAO {
	private Connection connection;
	
	private Investimento handleQuery(ResultSet res) throws SQLException {
		Investimento investimento = new Investimento();
		
		investimento.setCodigo(res.getInt("cd_investimento"));
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(res.getInt("cd_usuario"));
		investimento.setUsuario(usuario);
		
		investimento.setValor(res.getDouble("vl_investimento"));
		investimento.setTaxa(res.getDouble("vl_taxa"));
		investimento.setInstituicaoFinanceira(res.getString("nm_inst_financ"));
		
		Tipo tipo = new Tipo();
		tipo.setCodigo(res.getInt("cd_tipo"));
		investimento.setTipo(tipo);
		
		LocalDate dataInicio = DateParser.SQLToLocalDate(res.getDate("dt_inicio_investimento"));
		investimento.setDataInicio(dataInicio);
		
		LocalDate dataFinal = DateParser.SQLToLocalDate(res.getDate("dt_final_investimento"));
		investimento.setDataFinal(dataFinal);
		
		investimento.setDescricao(res.getString("ds_investimento"));
		
		return investimento;
	}
	
	public void insert (Investimento investimento) {
		PreparedStatement stmt = null;
		Date dataInicio = DateParser.localDateToSQL(investimento.getDataInicio());
		Date dataFinal = DateParser.localDateToSQL(investimento.getDataFinal());
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "INSERT INTO T_FINTECH_INVESTIMENTO (cd_investimento, cd_usuario, "
					+ "vl_investimento, vl_taxa, nm_inst_financ, cd_tipo, dt_inicio_investimento, "
					+ "dt_final_investimento, ds_investimento) "
					+ "VALUES(SQ_INVESTIMENTO.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, investimento.getUsuario().getCodigo());
			stmt.setDouble(2, investimento.getValor());
			stmt.setDouble(3, investimento.getTaxa());
			stmt.setString(4, investimento.getInstituicaoFinanceira());
			stmt.setInt(5, investimento.getTipo().getCodigo());
			stmt.setDate(6, dataInicio);
			stmt.setDate(7, dataFinal);
			stmt.setString(8, investimento.getDescricao());
			
			stmt.executeUpdate();
			System.out.println("Investimento incluído no bd");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Investimento> listAllFromUser (Integer codigoUsuario) {
		PreparedStatement stmt = null;
		ResultSet res = null;
		List<Investimento> investimentos = new ArrayList<Investimento>();
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "SELECT cd_investimento, cd_usuario, vl_investimento, vl_taxa, "
					+ "nm_inst_financ, cd_tipo, dt_inicio_investimento, dt_final_investimento, "
					+ "ds_investimento FROM T_FINTECH_INVESTIMENTO WHERE cd_usuario = ? "
					+ "ORDER BY dt_inicio_investimento DESC";
			
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigoUsuario);
			
			res = stmt.executeQuery();
			
			while(res.next()) {
				Investimento investimento = this.handleQuery(res);
				investimentos.add(investimento);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();				
				}
				if(res != null) {
					res.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return investimentos;
	}
	
	public Investimento getById (Integer codigoInvestimento, Integer codigoUsuario) {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Investimento investimento = null;
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "SELECT cd_investimento, cd_usuario, vl_investimento, vl_taxa, nm_inst_financ, "
					+ "cd_tipo, dt_inicio_investimento, dt_final_investimento, ds_investimento "
					+ "FROM T_FINTECH_INVESTIMENTO WHERE cd_usuario = ? "
					+ "AND cd_investimento = ?";
			
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigoUsuario);
			stmt.setInt(2, codigoInvestimento);
			
			res = stmt.executeQuery();
			
			if(res.next()) {
				investimento = this.handleQuery(res);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();				
				}
				if(res != null) {
					res.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return investimento;
	}
	
	public void Update (Investimento investimento) {
		PreparedStatement stmt = null;
		Date dataInicio = DateParser.localDateToSQL(investimento.getDataInicio());
		Date dataFinal = DateParser.localDateToSQL(investimento.getDataFinal());
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "UPDATE T_FINTECH_INVESTIMENTO SET vl_investimento = ?, vl_taxa = ?, "
					+ "nm_inst_financ = ?, cd_tipo = ?, dt_inicio_investimento = ?, "
					+ "dt_final_investimento = ?, ds_investimento = ? WHERE cd_investimento = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setDouble(1, investimento.getValor());
			stmt.setDouble(2, investimento.getTaxa());
			stmt.setString(3, investimento.getInstituicaoFinanceira());
			stmt.setInt(4, investimento.getTipo().getCodigo());
			stmt.setDate(5, dataInicio);
			stmt.setDate(6, dataFinal);
			stmt.setString(7, investimento.getDescricao());
			stmt.setInt(8, investimento.getCodigo());
			
			stmt.executeUpdate();
			System.out.println("Investimento atualizado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Delete (Integer codigoInvestimento, Integer codigoUsuario) {
		PreparedStatement stmt = null;
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "DELETE FROM T_FINTECH_INVESTIMENTO "
					+ "WHERE cd_usuario = ? AND cd_investimento = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			System.out.println("Investimento removido");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
