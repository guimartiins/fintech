package fintech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuarioRepositoryImpl implements Repository<UsuarioDAO>{
	private Connection conn;

	@Override
	public void create(UsuarioDAO usuario) {
		PreparedStatement stmt = null;
		DAO dao = new DAO();
		try {
			conn = dao.openConnection();
			String sql = "INSERT INTO usuario(ID, NOME, EMAIL, SENHA, CARGO, SALARIO, ADMINISTRADOR) "
					+ "VALUES (seq_usuario.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getCargo());
			stmt.setDouble(5, usuario.getSalario());
			stmt.setInt(6, usuario.getAdministrador());
			
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso!");

		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro de inserção SQL - tabela usuario");
		} catch(Exception e) {
			System.out.println("Erro ao inserir registros " + e.getMessage());
		}
		
		
		
	}

	@Override
	public UsuarioDAO getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
