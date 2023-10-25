package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.Usuario;
import br.com.fiap.jdbc.EmpresaDBManager;

public class UsuarioDAO {
    
    private Connection conexao;
  
    public List<Usuario> listar() {
        //Cria uma lista de colaboradores
        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	conexao = EmpresaDBManager.obterConexao();
        	stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
        	rs = stmt.executeQuery();
      
        //Percorre todos os registros encontrados
        while (rs.next()) {
        	int id_usuario = rs.getInt("ID_USUARIO");
        	String nome = rs.getString("NOME");
        	String email = rs.getString("EMAIL");
        	String telefone = rs.getString("TELEFONE");
        	String cargo = rs.getString("CARGO");
        	String funcao = rs.getString("FUNCAO");
        	java.sql.Date data = rs.getDate("DATA_NASCIMENTO");
            Calendar dataNascimento = Calendar.getInstance();
            dataNascimento.setTimeInMillis(data.getTime());
        	double salario = rs.getDouble("SALARIO");
        	int administrador = rs.getInt("ADMINISTRADOR");
        	String senha = rs.getString("SENHA");
            
            //Cria um objeto Colaborador com as informações encontradas
            Usuario usuario = new Usuario(id_usuario, nome, email, telefone, cargo, funcao, dataNascimento, salario, administrador, senha);
            //Adiciona o colaborador na lista
            lista.add(usuario);
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
