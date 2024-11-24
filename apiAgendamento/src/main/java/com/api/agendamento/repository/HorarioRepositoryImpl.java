package com.api.agendamento.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Repository
public class HorarioRepositoryImpl implements HorarioRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(HorarioRepositoryImpl.class);

    private final EntityManager entityManager;

    // Construtor para injeção de dependência do EntityManager
    public HorarioRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para atualizar o campo 'ativo' e retornar o ID do registro atualizado
    @Transactional
    public Integer updateAtivoByDiaAndHoras(LocalDate dia, String horas) {
        // Adicionando log para verificar os valores das variáveis 'dia' e 'horas'
        logger.info("Atualizando horário. Dia: {}, Horas: {}", dia, horas);
        
        String sql = "UPDATE horarios SET ativo = 1 WHERE dia = :dia AND horas = :horas RETURNING id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("dia", dia);
        query.setParameter("horas", horas);
        
        // Executando a consulta e pegando o resultado
        try {
            Object result = query.getSingleResult();
            Integer id = (Integer) result;
            logger.info("Horário atualizado com sucesso. ID retornado: {}", id);
            return id;
        } catch (Exception e) {
            // Caso ocorra erro, logar o erro
            logger.error("Erro ao atualizar horário para Dia: {} e Horas: {}", dia, horas, e);
            return null;
        }
    }
}
