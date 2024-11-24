package com.api.agendamento.controller;

import com.api.agendamento.dto.AgendamentoDTO;
import com.api.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    @GetMapping("/cliente/{idCliente}")
    public List<AgendamentoDTO> listarAgendamentosPorCliente(@PathVariable Integer idCliente) {
        return agendamentoService.listarAgendamentosPorCliente(idCliente);
    }
    // Endpoint para criar um novo agendamento
    @PostMapping
    public ResponseEntity<AgendamentoDTO> criarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        try {
            AgendamentoDTO agendamentoCriado = agendamentoService.criarAgendamento(agendamentoDTO);
            return new ResponseEntity<>(agendamentoCriado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);  // Retorna 400 em caso de erro
        }
    }

    // Endpoint para listar todos os agendamentos
    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> listarAgendamentos() {
        List<AgendamentoDTO> agendamentos = agendamentoService.listarAgendamentos();
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }

    // Endpoint para buscar um agendamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> buscarAgendamentoPorId(@PathVariable Integer id) {
        try {
            AgendamentoDTO agendamento = agendamentoService.buscarAgendamentoPorId(id);
            return new ResponseEntity<>(agendamento, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Retorna 404 caso não encontre
        }
    }
    
    // Endpoint para excluir um agendamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable Integer id) {
        try {
            agendamentoService.excluirAgendamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Retorna 204 em caso de sucesso
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna 404 caso não encontre
        }
    }
}
