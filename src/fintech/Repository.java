package fintech;

public interface Repository<T> {
    // Método para criar um novo registro no banco de dados
    void create(T entity);

    // Método para recuperar um registro do banco de dados com base em um ID
    T getAll();
}