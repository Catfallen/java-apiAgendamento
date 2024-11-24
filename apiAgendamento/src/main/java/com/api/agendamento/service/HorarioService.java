package com.api.agendamento.service;

import com.api.agendamento.model.Horario;
import com.api.agendamento.repository.HorarioRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> getHorarioById(Integer id) {
        return horarioRepository.findById(id);
    }
    
    public List<String> getHorasByDia(LocalDate dia) {
        return horarioRepository.findHorasByDia(dia);
    }
    
    public Horario createHorario(Horario horario) {
        return horarioRepository.save(horario);
    }
    
    public void inserirHorariosParaDia(LocalDate dia) {
        for (int x = 800; x < 1850; x += 50) {
            String horas = String.format("%04d", x); // Formata o horário (ex: 0800, 0850, ...)
            String a = horas.substring(0, 2);
            String b = horas.substring(2);

            if ("50".equals(b)) {
                b = "30"; // Ajuste de horário para 30 minutos
            }

            String stringab = a + b; // Cria a string de horário com minutos ajustados

            // Inserir horário no banco de dados
            horarioRepository.inserirHorariosDia(dia, stringab);
            System.out.println("Horário " + stringab + " inserido com sucesso para o dia " + dia);
        }
    }
    
    
    
    public Horario updateHorario(Integer id, Horario horario) {
        if (horarioRepository.existsById(id)) {
            horario.setId(id);
            return horarioRepository.save(horario);
        }
        return null; // Ou lançar uma exceção
    }
    @Transactional
    public Integer updateAtivoByDiaAndHoras(LocalDate dia, String horas) {
    	return horarioRepository.updateAtivoByDiaAndHoras(dia, horas);
    }
    

    public boolean deleteHorario(Integer id) {
        if (horarioRepository.existsById(id)) {
            horarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
