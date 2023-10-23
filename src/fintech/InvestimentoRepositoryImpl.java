package fintech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvestimentoRepositoryImpl implements Repository<InvestimentoDAO>{
	private Connection conn;

	@Override
	public void create(InvestimentoDAO investimento) {
		PreparedStatement stmt = null;
		DAO dao = new DAO();
		try {
			conn = dao.openConnection();
			String sql = "INSERT INTO INVESTIMENTO(ID, TIPO, VALOR, DATA_CRIACAO, DATA_VENCIMENTO, USUARIO_ID) "
					+ "VALUES(seq_investimento.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, investimento.getTipo());
			stmt.setDouble(2, investimento.getValor());
			java.sql.Date dataCriacao = new java.sql.Date(investimento.getData_criacao().getTimeInMillis());
			stmt.setDate(3, dataCriacao);
			java.sql.Date dataVencimento = new java.sql.Date(investimento.getData_vencimento().getTimeInMillis());
			stmt.setDate(4, dataVencimento);
			stmt.setInt(5, investimento.getUsuario());
			
			stmt.executeUpdate();
			
			System.out.println("Sucesso ao inserir dados");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro SQL");
		} catch(Exception e) {
			System.out.println("Erro ao inserir dados - tabela investimento " + e.getMessage());
		}
	}

	@Override
	public InvestimentoDAO getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
