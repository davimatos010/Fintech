package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.entities.Registro;
import br.com.fintech.entities.Tipo;
import br.com.fintech.entities.Usuario;

public class RegistroDAO {
	private Connection connection;
	private Usuario usuario;
	private Tipo tipo;

	public RegistroDAO () {
		this.usuario = new Usuario(0, null, null, null, null, 'T');
		this.tipo = new Tipo(0, null);
	}

	public void insert(Registro registro) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_FINTECH_REGISTRO "
				+ "(cd_registro, cd_usuario, vl_registro, dt_registro, cd_tipo, ds_categoria, ds_registro) "
				+ "VALUES (SQ_REGISTRO.nextval, ?, ?, ?, ?, ?, ?)";

		try {
			connection = OracleDBConnection.getConnection();

			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, registro.getUsuario().getCodigo());
			stmt.setDouble(2, registro.getValor());
			stmt.setDate(3, registro.getDataRegistro());
			stmt.setInt(4, registro.getTipo().getCodigo());
			stmt.setString(5, registro.getCategoria());
			stmt.setString(6, registro.getDescricao());

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


	public List<Registro> selectAll() {
		List<Registro> list = new ArrayList<Registro>();
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM T_FINTECH_REGISTRO");
			res = stmt.executeQuery();

			while(res.next()) {
				Usuario usuario = new Usuario(res.getInt("cd_usuario"), null, null, null, null, 'T');
				Tipo tipo = new Tipo(res.getInt("cd_tipo"), null);

				int codigo = res.getInt("cd_registro");
				double valor = res.getDouble("vl_registro");
				Date data = res.getDate("dt_registro");
				String categoria = res.getString("ds_categoria");
				String descricao = res.getString("ds_registro");


				Registro registro = new Registro(codigo, usuario, valor, data, tipo);
				registro.setCategoria(categoria);
				registro.setDescricao(descricao);

				list.add(registro);
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

	public Registro selectById(int codigoRegistro, int codigoUsuario) {
		PreparedStatement stmt = null;
		ResultSet res = null;
		Registro resRegistro = null;

		try {
			connection = OracleDBConnection.getConnection();
			stmt = connection.prepareStatement("SELECT cd_registro, cd_usuario, vl_registro, "
					+ "dt_registro, cd_tipo, ds_categoria, ds_registro "
					+ "FROM T_FINTECH_REGISTRO "
					+ "WHERE cd_usuario = " + codigoUsuario  
					+ " AND cd_registro = " +  codigoRegistro);
			res = stmt.executeQuery();

			if(res.next()) {
				this.usuario.setCodigo(res.getInt("cd_usuario"));
				this.tipo.setCodigo(res.getInt("cd_tipo"));

				int codigo = res.getInt("cd_registro");
				Usuario usuario = this.usuario;
				Tipo tipo = this.tipo;
				double valor = res.getDouble("vl_registro");
				Date data = res.getDate("dt_registro");
				String categoria = res.getString("ds_categoria");
				String descricao = res.getString("ds_registro");

				resRegistro = new Registro(codigo, usuario, valor, data, tipo);
				resRegistro.setCategoria(categoria);
				resRegistro.setDescricao(descricao);

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
		return resRegistro;
	}

	public void update(Registro registro) {
		PreparedStatement stmt = null;

		try {
			connection = OracleDBConnection.getConnection();
			String sql = "UPDATE T_FINTECH_REGISTRO "
					+ "SET "
					+ "vl_registro = ?, "
					+ "dt_registro = ?, "
					+ "ds_categoria = ?, "
					+ "ds_registro = ? "
					+ "WHERE cd_registro = ?";

			stmt = connection.prepareStatement(sql);


			stmt.setDouble(1, registro.getValor());
			stmt.setDate(2, registro.getDataRegistro());
			stmt.setString(3, registro.getCategoria());
			stmt.setString(4, registro.getDescricao());
			stmt.setInt(5, registro.getCodigo());

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

	public void delete (int codigoRegistro, int codigoUsuario) {
		PreparedStatement stmt = null;
		try {
			connection = OracleDBConnection.getConnection();
			String sql = "DELETE FROM T_FINTECH_REGISTRO WHERE cd_registro = " + codigoRegistro 
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

