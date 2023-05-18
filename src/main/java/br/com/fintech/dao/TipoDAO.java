package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.entities.Tipo;

public class TipoDAO {
	private Connection connection;

	public void insert(Tipo tipo) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_FINTECH_TIPO (cd_tipo, nm_tipo) VALUES (SQ_TIPO.nextval , ?)";

		try {
			connection = OracleDBConnection.getConnection();

			stmt = connection.prepareStatement(sql);

			stmt.setString(1, tipo.getNome());

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


	public List<Tipo> selectAll() {
		List<Tipo> list = new ArrayList<Tipo>();
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_FINTECH_TIPO");
			res = stmt.executeQuery();

			while(res.next()) {
				
				int codigo = res.getInt("cd_tipo");
				String nome = res.getString("nm_tipo");
				
				Tipo tipo = new Tipo(codigo, nome);

				list.add(tipo);
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


	public Tipo selectById(int codigoTipo) {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Tipo resTipo = null;

		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT cd_tipo, nm_tipo FROM T_FINTECH_TIPO "
					+ "WHERE cd_tipo = "+ codigoTipo);
			res = stmt.executeQuery();

			if(res.next()) {
				
				int codigo = res.getInt("cd_tipo");
				String nome = res.getString("nm_tipo");
				
				resTipo = new Tipo(codigo, nome);

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
		return resTipo;
	}


	public void update(Tipo tipo) {
		PreparedStatement stmt = null;

		try {
			connection = OracleDBConnection.getConnection();
			String sql = "UPDATE T_FINTECH_TIPO"
					+ "  SET"
					+ "  nm_tipo = ?"
					+ "WHERE cd_tipo = ?";

			stmt = connection.prepareStatement(sql);


			stmt.setString(1, tipo.getNome());
			stmt.setInt(2, tipo.getCodigo());

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


	public void delete(int codigoTipo) {
		PreparedStatement stmt = null;
		try {
			connection = OracleDBConnection.getConnection();
			String sql = "DELETE FROM T_FINTECH_TIPO WHERE cd_tipo = " + codigoTipo;
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
