package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VPS04.JDBC.ConnectionDB;

import entity.UsuarioADM;

public class UsuarioAdmDAO {

	
	Connection conn;

	public UsuarioAdmDAO() {
		conn = ConnectionDB.getConnection();
	}
	
	
	
	public UsuarioADM buscarADM(int nif, String senha) {

		String sql = "SELECT * FROM administrador " + "WHERE NIF = ? AND senha = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, nif);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				UsuarioADM adm = new UsuarioADM();

				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getInt("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getInt("telefone"));

				return adm;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public boolean inserirADM(UsuarioADM adm) {

		// PERGUNTAR SE TEM QUE COLOCAR O ID TAMBEM ALI NO INSERT INTO

		String sql = " INSERT INTO administrador (NIF, email, nome, senha, " + " telefone)"
				+ " VALUES (?, ?, ?, ?, ?) ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, adm.getNIF());
			ps.setString(2, adm.getEmail());
			ps.setString(3, adm.getNome());
			ps.setString(4, adm.getSenha());
			ps.setInt(5, adm.getTelefone());

			if (ps.executeUpdate() == 1) {
				System.out.println("Usu�rio adm cadastrado ");
			} else {
				System.out.println("Problemas ao cadastrar usu�rio adm");
			}
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	
	
	
	
}