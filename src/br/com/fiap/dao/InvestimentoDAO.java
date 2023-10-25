package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.Investimento;
import br.com.fiap.jdbc.EmpresaDBManager;

public class InvestimentoDAO {
    
    private Connection conexao;
  
    public List<Investimento> listar() {
        //Cria uma lista da tabela investimento
        List<Investimento> lista = new ArrayList<Investimento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	conexao = EmpresaDBManager.obterConexao();
        	stmt = conexao.prepareStatement("SELECT * FROM TAB_INVESTIMENTO");
        	rs = stmt.executeQuery();
      
        //Percorre todos os registros encontrados
        while (rs.next()) {
        	int id = rs.getInt("ID");
        	int usuario_id = rs.getInt("USUARIO_ID");
        	String tipo = rs.getString("TIPO");
            double valor = rs.getDouble("VALOR");
            java.sql.Date data = rs.getDate("DATA_CRIACAO");
            Calendar dataCriacao = Calendar.getInstance();
            dataCriacao.setTimeInMillis(data.getTime());
            
            java.sql.Date data2 = rs.getDate("DATA_VENCIMENTO");
            Calendar dataVencimento = Calendar.getInstance();
            dataVencimento.setTimeInMillis(data2.getTime());
            
            //Cria um objeto Investimento com as informações encontradas
            Investimento investimento = new Investimento(id, usuario_id, tipo, valor, dataCriacao, dataVencimento);
            //Adiciona o Investimento na lista
            lista.add(investimento);
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }finally {
          try {
            stmt.close();
            rs.close();
            conexao.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
        return lista;
      }
    
    
  }
