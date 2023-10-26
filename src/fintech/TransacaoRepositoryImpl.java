package fintech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TransacaoRepositoryImpl implements Repository<TransacaoDAO>{
	private Connection conn;

	@Override
	public void create(TransacaoDAO transacao, Connection connection) {
		PreparedStatement stmt = null;
		DAO dao = new DAO();
		try {
			conn = connection;
			String sql = "INSERT INTO transacao(ID, TIPO, VALOR, DATA_CRIACAO, DATA_VENCIMENTO, USUARIO_ID) "
					+ "VALUES (seq_transacao.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, transacao.getTipo());
			stmt.setDouble(2, transacao.getValor());
			java.sql.Date dataCriacao = new java.sql.Date(transacao.getData_criacao().getTimeInMillis());
			stmt.setDate(3, dataCriacao);
			java.sql.Date dataVenc = new java.sql.Date(transacao.getData_criacao().getTimeInMillis());
			stmt.setDate(4, dataVenc);
			stmt.setInt(5, transacao.getUsuario());
			
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso!");

		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro de inserção SQL - tabela transacao");
		} catch(Exception e) {
			System.out.println("Erro ao inserir registros " + e.getMessage());
		}
		
	}

	@Override
	public TransacaoDAO getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
