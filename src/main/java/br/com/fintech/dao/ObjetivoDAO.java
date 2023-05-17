package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.model.Objetivo;
import br.com.fintech.model.Usuario;

public class ObjetivoDAO {
	private Connection connection;
	private Usuario usuario;
	
	public ObjetivoDAO() {
		this.usuario = new Usuario(0, null, null, null, null, 'T');
	}
	
	public void insert(Objetivo objetivo) {
		PreparedStatement stmt = null;
		
		try {
			connection = OracleDBConnection.getConnection();
			String sql = 
					"INSERT INTO T_FINTECH_OBJETIVO(cd_objetivo, cd_usuario, nm_objetivo, vl_final, vl_inicial, dt_final_objetivo, ds_objetivo)"
					+ "VALUES(SQ_OBJETIVO.nextval, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, objetivo.getUsuario().getCodigo());
			stmt.setString(2, objetivo.getNome());
			stmt.setDouble(3, objetivo.getValorFinal());
			stmt.setDouble(4, objetivo.getValorInicial());
			stmt.setDate(5, objetivo.getDataFinal());
			stmt.setString(6, objetivo.getDescricao());
			
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
	
	public List<Objetivo> selectAll() {
		
		List<Objetivo> list = new ArrayList<Objetivo>();
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_FINTECH_OBJETIVO");
			res = stmt.executeQuery();
			
			while(res.next()) {
				Usuario usuario = new Usuario(res.getInt("cd_usuario"), null, null, null, null, 'T');
				
				int codigo = res.getInt("cd_objetivo");
				String nome = res.getString("nm_objetivo");
				double valorInicial = res.getDouble("vl_inicial");
				double valorFinal = res.getDouble("vl_final");
				Date dataFinal = res.getDate("dt_final_objetivo");
				String descricao = res.getString("ds_objetivo");
				
				Objetivo objetivo = new Objetivo(codigo, usuario, nome, valorFinal);
				objetivo.setValorInicial(valorInicial);
				objetivo.setDataFinal(dataFinal);
				objetivo.setDescricao(descricao);
				
				list.add(objetivo);
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
	
	public Objetivo selectById(int codigoObjetivo, int codigoUsuario) {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Objetivo resObjetivo = null;
		
		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_FINTECH_OBJETIVO WHERE cd_objetivo = " + codigoObjetivo 
					+ " AND cd_usuario = " + codigoUsuario);
			res = stmt.executeQuery();
			
			if(res.next()) {
				this.usuario.setCodigo(res.getInt("cd_usuario"));
				
				int codigo = res.getInt("cd_objetivo");
				Usuario usuario = this.usuario;
				String nome = res.getString("nm_objetivo");
				double valorInicial = res.getDouble("vl_inicial");
				double valorFinal = res.getDouble("vl_final");
				Date dataFinal = res.getDate("dt_final_objetivo");
				String descricao = res.getString("ds_objetivo");
				
				resObjetivo = new Objetivo(codigo, usuario, nome, valorFinal);
				resObjetivo.setValorInicial(valorInicial);
				resObjetivo.setDataFinal(dataFinal);
				resObjetivo.setDescricao(descricao);
				
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
		return resObjetivo;
	}
	
	public void update (Objetivo objetivo) {
		PreparedStatement stmt = null;
		
		try {
			connection = OracleDBConnection.getConnection();
			String sql = "UPDATE T_FINTECH_OBJETIVO "
					+ "SET nm_objetivo = ?, vl_final = ?, vl_inicial = ?, dt_final_objetivo = ?, ds_objetivo = ? "
					+ "WHERE cd_objetivo = ? AND cd_usuario = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, objetivo.getNome());
			stmt.setDouble(2, objetivo.getValorFinal());
			stmt.setDouble(3, objetivo.getValorInicial());
			stmt.setDate(4, objetivo.getDataFinal());
			stmt.setString(5, objetivo.getDescricao());
			stmt.setInt(6, objetivo.getCodigo());
			stmt.setInt(7, objetivo.getUsuario().getCodigo());
			
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
	
	public void delete(int codigoObjetivo, int codigoUsuario) {
		PreparedStatement stmt = null;
		try {
			connection = OracleDBConnection.getConnection();
			String sql = "DELETE FROM T_FINTECH_OBJETIVO WHERE cd_objetivo = " + codigoObjetivo + " AND cd_usuario = " + codigoUsuario;
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
