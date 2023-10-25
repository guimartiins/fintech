package br.com.fiap.main;


import java.util.List;

import br.com.fiap.bean.Despesa;
import br.com.fiap.bean.Investimento;
import br.com.fiap.bean.Transacao;
import br.com.fiap.bean.Usuario;
import br.com.fiap.dao.DespesaDAO;
import br.com.fiap.dao.InvestimentoDAO;
import br.com.fiap.dao.TransacaoDAO;
import br.com.fiap.dao.UsuarioDAO;

public class Main {

  public static void main(String[] args) {

	  //Retorna todos os dados da tabela Investimento
	  InvestimentoDAO invDao = new InvestimentoDAO();	  
	  List<Investimento> listaInvest = invDao.listar();	 
	  
	  for (Investimento investItem : listaInvest) {
		  System.out.println(investItem.getId() + " | " + investItem.getUsuario_id() + " | " + investItem.getTipo() + " | " + investItem.getValor() + " | " + investItem.getDataCriacao().getTime() + " | " + investItem.getDataVencimento().getTime());
	  }
	  
	  //Retorna todos os dados da tabela Usuario
	  UsuarioDAO userDao = new UsuarioDAO();	  
	  List<Usuario> listaUsuario = userDao.listar();	 
	  
	  for (Usuario userItem : listaUsuario) {
		  System.out.println(userItem.getId_usuario() + " | " + userItem.getNome() + " | " + userItem.getEmail() + " | " + userItem.getTelefone() + " | " + userItem.getCargo() + " | " + userItem.getFuncao() + " | " + userItem.getDataNascimento().getTime() + " | " + userItem.getSalario() + " | " + userItem.getAdministrador() + " | " + userItem.getSenha());
	  }
	  
	  //Retorna todos os dados da tabela Despesa
	  DespesaDAO despDao = new DespesaDAO();	  
	  List<Despesa> listaDespesa = despDao.listar();	 
	  
	  for (Despesa despItem : listaDespesa) {
		  System.out.println(despItem.getId_despesa() + " | " + despItem.getUsuario_id() + " | " + despItem.getTipo() + " | " + despItem.getValor() + " | " + despItem.getDataCriacao().getTime());
	  }
	  
	//Retorna todos os dados da tabela Transacao
	  TransacaoDAO tranDao = new TransacaoDAO();	  
	  List<Transacao> listaTransacao = tranDao.listar();	 
	  
	  for (Transacao tranItem : listaTransacao) {
		  System.out.println(tranItem.getId_transacao() + " | " + tranItem.getUsuario_id() + " | " + tranItem.getTipo() + " | " + tranItem.getValor() + " | " + tranItem.getDataCriacao().getTime() + " | " + tranItem.getDataVencimento().getTime());
	  }
    
  }

}
