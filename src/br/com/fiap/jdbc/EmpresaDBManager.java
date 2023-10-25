package br.com.fiap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpresaDBManager {

  public static Connection obterConexao() {
    Connection conexao = null;
    try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");

    	conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
    			"rm550629","040990");
      	System.out.println("Conexão efetuada com sucesso");
    } catch (ClassNotFoundException e) {
        System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
    } catch (SQLException e) {
        System.err.println("Erro ao abrir a conexão com o banco de dados: " + e.getMessage());
    }
    return conexao;
  }

}
