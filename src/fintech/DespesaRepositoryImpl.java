package fintech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Despesa{
	
}

public class DespesaRepositoryImpl implements Repository<DespesaDAO>{
	private Connection conn;

	@Override
	public void create(DespesaDAO despesa) {
		PreparedStatement stmt = null;
		DAO dao = new DAO();
		try {
			conn = dao.openConnection();
			String sql = "INSERT INTO despesa(ID, TIPO, VALOR, DATA_CRIACAO, USUARIO_ID) "
					+ "VALUES(seq_despesa.NEXTVAL, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, despesa.getTipo());
			stmt.setDouble(2, despesa.getValor());
			java.sql.Date date = new java.sql.Date(despesa.getData_criacao().getTimeInMillis());
			stmt.setDate(3, date);
			stmt.setInt(4, despesa.getUsuario());
			
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro de inserção SQL - tabela despesa ");
		} catch(Exception e) {
			System.out.println("Erro ao inserir dados na tabela despesa " + e.getMessage());
		}
	}

	@Override
	public DespesaDAO getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
