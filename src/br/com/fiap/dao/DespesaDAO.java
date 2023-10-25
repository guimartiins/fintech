package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.Despesa;
import br.com.fiap.jdbc.EmpresaDBManager;

public class DespesaDAO {
    
    private Connection conexao;
  
    public List<Despesa> listar() {
        //Cria uma lista de despesa
        List<Despesa> lista = new ArrayList<Despesa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	conexao = EmpresaDBManager.obterConexao();
        	stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA");
        	rs = stmt.executeQuery();
      
        //Percorre todos os registros encontrados
        while (rs.next()) {
        	int id_despesa = rs.getInt("ID_DESPESA");
        	int id_usuario = rs.getInt("ID_USUARIO");
        	String tipo = rs.getString("TIPO");
        	int valor = rs.getInt("VALOR");
        	java.sql.Date data = rs.getDate("DATA_CRIACAO");
            Calendar dataCriacao = Calendar.getInstance();
            dataCriacao.setTimeInMillis(data.getTime());
        	        	
            //Cria um objeto Colaborador com as informações encontradas
            Despesa despesa = new Despesa(id_despesa, id_usuario, tipo, valor, dataCriacao);
            //Adiciona o colaborador na lista
            lista.add(despesa);
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
