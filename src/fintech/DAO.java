package fintech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private Connection connection;
    private final String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL"; // Substitua pela URL do seu banco de dados Oracle
    private final String dbUser = "system";
    private final String dbPassword = "root";

    public DAO() {
    }

    // Método para abrir a conexão com o banco de dados
    public void openConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Carrega o driver JDBC
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao abrir a conexão com o banco de dados: " + e.getMessage());
        }
    }

    // Método para fechar a conexão com o banco de dados
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    
    public Connection getConnection() {
    	return this.connection;
    }
}
