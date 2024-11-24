package com.api.agendamento.controller;

import com.api.agendamento.model.Cliente;
import com.api.agendamento.service.ClienteService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para obter todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Endpoint para obter cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable Integer id) {
        return clienteService.getClienteById(id);
    }

    // Endpoint para criar um novo cliente
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    // Endpoint para deletar um cliente
    @DeleteMapping("/{id}")
    public boolean deleteCliente(@PathVariable Integer id) {
        return clienteService.deleteCliente(id);
    }
}