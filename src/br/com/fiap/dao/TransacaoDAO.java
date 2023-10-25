package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.Transacao;
import br.com.fiap.jdbc.EmpresaDBManager;

public class TransacaoDAO {
    
    private Connection conexao;
  
    public List<Transacao> listar() {
        //Cria uma lista de transacao
        List<Transacao> lista = new ArrayList<Transacao>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	conexao = EmpresaDBManager.obterConexao();
        	stmt = conexao.prepareStatement("SELECT * FROM TRANSACAO");
        	rs = stmt.executeQuery();
      
        //Percorre todos os registros encontrados
        while (rs.next()) {
        	int id_transacao = rs.getInt("ID_TRANSACAO");
        	int id_usuario = rs.getInt("ID_USUARIO");
        	String tipo = rs.getString("TIPO");
        	int valor = rs.getInt("VALOR");
        	java.sql.Date data = rs.getDate("DATA_CRIACAO");
            Calendar dataCriacao = Calendar.getInstance();
            dataCriacao.setTimeInMillis(data.getTime());
            java.sql.Date data2 = rs.getDate("DATA_VENCIMENTO");
            Calendar dataVencimento = Calendar.getInstance();
            dataVencimento.setTimeInMillis(data2.getTime());
        	        	
            //Cria um objeto Colaborador com as informações encontradas
            Transacao transacao = new Transacao(id_transacao, id_usuario, tipo, valor, dataCriacao, dataVencimento);
            //Adiciona o colaborador na lista
            lista.add(transacao);
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
