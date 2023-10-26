package fintech;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;

import fintech.DAOs.DespesaDAO;
import fintech.DAOs.InvestimentoDAO;
import fintech.DAOs.TransacaoDAO;
import fintech.models.Despesa;
import fintech.models.Investimento;
import fintech.models.Transacao;

public class Main {	
    public static void main(String[] args) {
        DBManager dBManager = new DBManager();
        
        // Abrir a conexão
        dBManager.openConnection();
        Connection connection = dBManager.getConnection(); 
        
        DespesaDAO despesaDAO = new DespesaDAO();
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        InvestimentoDAO investimentoDAO = new InvestimentoDAO();

        for(int i = 0; i < 5; i++) {
            Despesa despesa = new Despesa("Conta", 1200, Calendar.getInstance(), i);
            despesaDAO.create(despesa, connection);

            Transacao transacao = new Transacao("Emprestimo", 2000, Calendar.getInstance(), Calendar.getInstance(), i);
            transacaoDAO.create(transacao, connection);

            Investimento investimento = new Investimento("Tesouro Direto", 2000, Calendar.getInstance(), Calendar.getInstance(), i);
            investimentoDAO.create(investimento, connection);
        }

        List<Despesa> despesas = despesaDAO.getAll(connection);
        System.out.println(despesas.toString());

        List<Transacao> transacoes = transacaoDAO.getAll(connection);
        System.out.println(transacoes.toString());
        
        List<Investimento> investimentos = investimentoDAO.getAll(connection);
        System.out.println(investimentos.toString());
        // Fechar a conexão
        dBManager.closeConnection();
    }

}
