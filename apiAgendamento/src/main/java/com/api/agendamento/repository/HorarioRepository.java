package com.api.agendamento.repository;

import com.api.agendamento.model.Horario;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer>,HorarioRepositoryCustom {
    // Você pode adicionar consultas personalizadas aqui, se necessário
	@Query("SELECT h.horas FROM Horario h WHERE h.ativo = 0 AND h.dia = :dia")
    List<String> findHorasByDia(@Param("dia") LocalDate dia);
	
	
	@Transactional
    @Modifying
    @Query("INSERT INTO Horario (dia, horas, ativo) VALUES (:dia, :horas, 0)")
    void inserirHorariosDia(LocalDate dia, String horas);
}
