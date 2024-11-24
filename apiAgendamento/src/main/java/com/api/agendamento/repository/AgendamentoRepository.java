package com.api.agendamento.repository;

import com.api.agendamento.model.Agendamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    // Aqui você pode adicionar consultas customizadas, caso necessário.
	@Query("SELECT a FROM Agendamento a WHERE a.cliente.id = :idCliente")
	List<Agendamento> findByClienteId(@Param("idCliente") Integer idCliente);

}
