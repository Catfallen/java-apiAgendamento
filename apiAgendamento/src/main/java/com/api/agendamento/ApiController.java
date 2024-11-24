package com.api.agendamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
@RestController
public class ApiController {

    private final DataSource dataSource;

    public ApiController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/test-connection")
    public String testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Conexão bem-sucedida!";
        } catch (SQLException e) {
            return "Erro na conexão: " + e.getMessage();
        }
    }
}