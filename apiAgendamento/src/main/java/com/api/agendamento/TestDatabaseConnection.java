
package com.api.agendamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/web"; // URL do banco de dados
        String user = "postgres"; // Nome de usuário
        String password = "markim"; // Senha

        try {
            // Estabelecendo a conexão
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
                connection.close(); // Fechando a conexão
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
