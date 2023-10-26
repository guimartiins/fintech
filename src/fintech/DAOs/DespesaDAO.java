package fintech.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fintech.models.Despesa;

public class DespesaDAO implements DAO<Despesa> {
	public void create(Despesa despesa, Connection connection) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO despesa(TIPO, VALOR, DATA_CRIACAO, USUARIO_ID) "
					+ "VALUES(?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, despesa.getTipo());
			stmt.setDouble(2, despesa.getValor());
			java.sql.Date date = new java.sql.Date(despesa.getDataCriacao().getTimeInMillis());
			stmt.setDate(3, date);
			stmt.setInt(4, despesa.getUsuarioID());
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucesso");
		}
		catch(Exception e) {
			System.out.println("Erro ao inserir dados na tabela despesa " + e.getMessage());
		}
	}

	public List<Despesa> getAll(Connection connection) {
		List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesa";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                double valor = resultSet.getDouble("valor");
                Calendar dataCriacao = Calendar.getInstance();
				dataCriacao.setTimeInMillis(resultSet.getTimestamp("data_criacao").getTime());
				int usuarioID = resultSet.getInt("usuario_id");
                Despesa despesa = new Despesa(id, tipo, valor, dataCriacao, usuarioID);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
			System.out.println("Erro ao listar Despesas " + e.getMessage());
        }
        
        return despesas;
    }

}
