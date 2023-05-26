package br.com.fintech.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.data.OracleDBConnection;
import br.com.fintech.entities.Usuario;
import br.com.fintech.utils.Cryptographer;
import br.com.fintech.utils.DateParser;

public class UsuarioDAO {
	private static Connection connection;

	private static String getSalt(String login) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "SELECT cd_salt FROM T_FINTECH_USUARIO WHERE ds_email = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);

			rs = stmt.executeQuery();

			if(rs.next()) {
				return rs.getString("cd_salt");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;


	}

	public Usuario validate(String login, String senha) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String salt = UsuarioDAO.getSalt(login); 

		if (salt == null) {
			salt = ".";
		}; 

		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "SELECT * FROM T_FINTECH_USUARIO WHERE ds_email = ? AND cd_senha = ?";

			Cryptographer password = Cryptographer.cryptographWithSalt(senha, salt);

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, password.getEncryptedPassword());

			rs = stmt.executeQuery();

			if(rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setCodigo(rs.getInt("cd_usuario"));
				usuario.setNome(rs.getString("nm_usuario"));
				usuario.setEmail(rs.getString("ds_email"));
				usuario.setDataNascimento(DateParser.SQLToLocalDate(rs.getDate("dt_nasc")));
				usuario.setGenero(rs.getString("tp_genero"));

				return usuario;
			} 

		} catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
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
		return null;
	}

	public void insert(Usuario usuario) {
		PreparedStatement stmt = null;
		Date dataNascimento = DateParser.localDateToSQL(usuario.getDataNascimento());

		try {
			connection = OracleDBConnection.getInstance().getConnection();

			String sql = "INSERT INTO T_FINTECH_USUARIO (cd_usuario, nm_usuario, ds_email, "
					+ "cd_senha, dt_nasc, tp_genero, cd_salt)"
					+ " VALUES (SQ_USUARIO.nextval, ?, ?, ?, ?, ?, ?)";

			stmt = connection.prepareStatement(sql);

			Cryptographer encrypt = Cryptographer.cryptographWithSalt(usuario.getSenha());

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, encrypt.getEncryptedPassword());
			stmt.setDate(4, dataNascimento);
			stmt.setString(5, usuario.getGenero());
			stmt.setString(6, encrypt.getSalt());

			stmt.executeUpdate();
			System.out.println("Usuário cadastrado");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
