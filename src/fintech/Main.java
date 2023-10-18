package fintech;

public class Main {	
    public static void main(String[] args) {
        DAO dao = new DAO();
        
        // Abrir a conexão
        dao.openConnection();
        

        // Realizar operações no banco de dados
        // Façam o código aqui e não removam a criação da conexão e nem o fechamento dela :)
        
        // Fechar a conexão
        dao.closeConnection();
    }

}
