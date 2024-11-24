package com.api.agendamento.controller;

import com.api.agendamento.model.Servico;
import com.api.agendamento.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.getAllServicos();
    }

    @GetMapping("/{id}")
    public Optional<Servico> getServicoById(@PathVariable Integer id) {
        return servicoService.getServicoById(id);
    }

    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.createServico(servico);
    }

    @PutMapping("/{id}")
    public Servico updateServico(@PathVariable Integer id, @RequestBody Servico servico) {
        return servicoService.updateServico(id, servico);
    }

    @DeleteMapping("/{id}")
    public boolean deleteServico(@PathVariable Integer id) {
        return servicoService.deleteServico(id);
    }
}
