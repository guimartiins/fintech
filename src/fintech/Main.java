package fintech;

import java.util.Calendar;

public class Main {	
    public static void main(String[] args) {
        DAO dao = new DAO();
        
        // Abrir a conexão
        dao.openConnection();
        System.out.println("conn " + dao.getConnection());

        //inserção de dados 
        
        //tabela usuários
        UsuarioDAO user = new UsuarioDAO(0, "vanessa", "vanessa@gmail.com", "senha8585@#", "Desenvolvedor", 2400, 1);
        UsuarioRepositoryImpl repositoryUsuario = new UsuarioRepositoryImpl();
        //repositoryUsuario.create(user);
        
        //tabela despesa
        DespesaDAO despesa = new DespesaDAO(0, "Conta", 1200, Calendar.getInstance(), 1);
        DespesaRepositoryImpl repositoryDespesa = new DespesaRepositoryImpl();
        //repositoryDespesa.create(despesa);
        
        //tabela transacao
        Calendar dataVenc = Calendar.getInstance();
        dataVenc.set(2023, Calendar.OCTOBER, 21);
        TransacaoDAO transacao = new TransacaoDAO(0, "Renda variavel", 1200,  Calendar.getInstance(), dataVenc, 1);
        TransacaoRepositoryImpl repositoryTransacao = new TransacaoRepositoryImpl();
        //repositoryTransacao.create(transacao);
        
        //tabela investimento
        InvestimentoDAO investimento = new InvestimentoDAO(0, "Renda variavel", 2533, Calendar.getInstance(), dataVenc, 1);
        InvestimentoRepositoryImpl repositoryInvestimento = new InvestimentoRepositoryImpl();
        repositoryInvestimento.create(investimento);
        
        // Fechar a conexão
        dao.closeConnection();
        
       
    }

}
