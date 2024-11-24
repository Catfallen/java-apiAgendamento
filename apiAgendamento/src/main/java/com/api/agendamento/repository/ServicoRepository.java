package com.api.agendamento.repository;

import com.api.agendamento.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    // Você pode adicionar consultas personalizadas aqui, se necessário
}
