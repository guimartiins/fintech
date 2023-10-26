package fintech.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fintech.models.Investimento;

public class InvestimentoDAO implements DAO<Investimento> {

	public void create(Investimento investimento, Connection connection) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO investimento(TIPO, VALOR, DATA_CRIACAO, DATA_VENCIMENTO, USUARIO_ID) "
					+ "VALUES (?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, investimento.getTipo());
			stmt.setDouble(2, investimento.getValor());
			java.sql.Date dataCriacao = new java.sql.Date(investimento.getDataCriacao().getTimeInMillis());
			stmt.setDate(3, dataCriacao);
			java.sql.Date dataVenc = new java.sql.Date(investimento.getDataVencimento().getTimeInMillis());
			stmt.setDate(4, dataVenc);
			stmt.setInt(5, investimento.getUsuarioID());
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso");
		}
		catch(Exception e) {
			System.out.println("Erro ao inserir dados na tabela despesa " + e.getMessage());
		}
	}

	public List<Investimento> getAll(Connection connection) {
		List<Investimento> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM investimento";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                double valor = resultSet.getDouble("valor");
                Calendar dataCriacao = Calendar.getInstance();
				dataCriacao.setTimeInMillis(resultSet.getTimestamp("data_criacao").getTime());
                Calendar dataVencimento = Calendar.getInstance();
				dataCriacao.setTimeInMillis(resultSet.getTimestamp("data_vencimento").getTime());
				int usuarioID = resultSet.getInt("usuario_id");
                Investimento investimento = new Investimento(id, tipo, valor, dataCriacao, dataVencimento, usuarioID);
                investimentos.add(investimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
			System.out.println("Erro ao listar Despesas " + e.getMessage());
        }
        
        return investimentos;
    }

  }