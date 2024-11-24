package com.api.agendamento.controller;

import com.api.agendamento.dto.UpdateHorarioRequest;
import com.api.agendamento.model.Horario;
import com.api.agendamento.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;


@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioService.getAllHorarios();
    }

    @GetMapping("/{id}")
    public Optional<Horario> getHorarioById(@PathVariable Integer id) {
        return horarioService.getHorarioById(id);
    }
    
    @GetMapping("/horas/{dia}")
    public List<String> getHorasByDia(@PathVariable String dia) {
    	LocalDate data = LocalDate.parse(dia);
        return horarioService.getHorasByDia(data);
    }
    
    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioService.createHorario(horario);
    }
    
    @PostMapping("/{dia}")
    public ResponseEntity<String> inserirHorarios(@PathVariable String dia) {
        try {
            // Converte a string do parâmetro para LocalDate
            LocalDate data = LocalDate.parse(dia);
            
            // Chama o serviço para inserir os horários
            horarioService.inserirHorariosParaDia(data);
            
            return ResponseEntity.ok("Horários inseridos com sucesso para o dia " + dia);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Formato de data inválido. Use o formato: yyyy-MM-dd");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao inserir horários: " + e.getMessage());
        }
    }
    

    @PutMapping("/{id}")
    public Horario updateHorario(@PathVariable Integer id, @RequestBody Horario horario) {
        return horarioService.updateHorario(id, horario);
    }

    @DeleteMapping("/{id}")
    public boolean deleteHorario(@PathVariable Integer id) {
        return horarioService.deleteHorario(id);
    }
    
    
    @PutMapping
    public Integer updateAtivoByDiaAndHoras(@RequestBody UpdateHorarioRequest updateRequest) {
        return horarioService.updateAtivoByDiaAndHoras(updateRequest.getDia(), updateRequest.getHoras());
    }

    
}
