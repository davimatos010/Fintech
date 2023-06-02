package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.entities.Dashboard;
import br.com.fintech.entities.Registro;
import br.com.fintech.entities.Usuario;
import br.com.fintech.utils.DateParser;

public class DashboardDAO {
	private Connection connection;
	
	public Dashboard makeDashboard(Integer codigoUsuario) {
		PreparedStatement stmt = null;
		Dashboard dashboard = null;
		ResultSet res = null;
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			
			String sql = "SELECT G.cd_usuario, G.cd_gasto, G.vl_gasto, G.dt_gasto, G.ds_gasto, "
					+ "SG.sm_gastos, R.cd_recebimento, R.vl_recebimento, R.dt_recebimento, "
					+ "R.ds_recebimento, SR.sm_recebimentos, SI.sm_investimentos "
					+ "FROM (SELECT cd_gasto, vl_gasto, dt_gasto, ds_gasto, cd_usuario "
					+ "FROM (SELECT cd_registro AS cd_gasto, vl_registro AS vl_gasto, "
					+ "dt_registro AS dt_gasto, ds_categoria AS ds_gasto, cd_usuario "
					+ "FROM T_FINTECH_REGISTRO WHERE cd_usuario = ? AND cd_tipo = 2 "
					+ "ORDER BY dt_registro DESC) WHERE ROWNUM = 1) G "
					+ "LEFT JOIN (SELECT cd_recebimento, vl_recebimento, dt_recebimento, "
					+ "ds_recebimento, cd_usuario FROM (SELECT cd_registro AS cd_recebimento, "
					+ "vl_registro AS vl_recebimento, dt_registro AS dt_recebimento, "
					+ "ds_registro AS ds_recebimento, cd_usuario FROM T_FINTECH_REGISTRO "
					+ "WHERE cd_usuario = ? AND cd_tipo = 1 ORDER BY dt_registro DESC) WHERE ROWNUM = 1)"
					+ " R ON G.cd_usuario = R.cd_usuario LEFT JOIN "
					+ "(SELECT SUM(vl_registro) AS sm_gastos, cd_usuario "
					+ "FROM T_FINTECH_REGISTRO WHERE cd_usuario = ? AND cd_tipo = 2 GROUP BY cd_usuario)"
					+ " SG ON G.cd_usuario = SG.cd_usuario "
					+ "LEFT JOIN (SELECT SUM(vl_registro) AS sm_recebimentos, cd_usuario "
					+ "FROM T_FINTECH_REGISTRO WHERE cd_usuario = ? AND cd_tipo = 1 "
					+ "GROUP BY cd_usuario) SR ON G.cd_usuario = SR.cd_usuario "
					+ "LEFT JOIN (SELECT SUM(vl_investimento) AS sm_investimentos, cd_usuario "
					+ "FROM T_FINTECH_INVESTIMENTO WHERE cd_usuario = ? "
					+ "GROUP BY cd_usuario) SI ON G.cd_usuario = SI.cd_usuario";
			
			stmt = connection.prepareStatement(sql);
			
			for(int i = 1; i <= 5; i++) {
				stmt.setInt(i, codigoUsuario);
			}
			
			res = stmt.executeQuery();
			
			if(res.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setCodigo(codigoUsuario);
				
				Registro ultimoGasto = new Registro();
				ultimoGasto.setCodigo(res.getInt("cd_gasto"));
				ultimoGasto.setValor(res.getDouble("vl_gasto"));
				ultimoGasto.setCategoria(res.getString("ds_gasto"));
				
				if(res.getDate("dt_gasto") != null) {
					ultimoGasto.setDataRegistro(DateParser.SQLToLocalDateTime(res.getDate("dt_gasto")));
				}
				
				Registro ultimoRecebimento = new Registro();
				ultimoRecebimento.setCodigo(res.getInt("cd_recebimento"));
				ultimoRecebimento.setValor(res.getDouble("vl_recebimento"));
				ultimoRecebimento.setDescricao(res.getString("ds_recebimento"));
				
				if(res.getDate("dt_recebimento") != null) {
					ultimoRecebimento.setDataRegistro(DateParser.SQLToLocalDateTime(res.getDate("dt_recebimento")));
				}
				dashboard = new Dashboard(usuario, ultimoGasto, ultimoRecebimento, 
						res.getDouble("sm_gastos"), res.getDouble("sm_recebimentos"), 
						res.getDouble("sm_investimentos"));
				
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
		return dashboard;
	}
}
