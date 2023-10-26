package fintech.DAOs;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {
    // Método para criar um novo registro no banco de dados
    void create(T entity, Connection connection);

    // Método para recuperar um registro do banco de dados com base em um ID
    List<T> getAll(Connection connection);
}