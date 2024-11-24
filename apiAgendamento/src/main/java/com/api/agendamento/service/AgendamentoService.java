package com.api.agendamento.service;

import com.api.agendamento.dto.AgendamentoDTO;
import com.api.agendamento.model.Agendamento;
import com.api.agendamento.model.Cliente;
import com.api.agendamento.model.Horario;
import com.api.agendamento.repository.AgendamentoRepository;
import com.api.agendamento.repository.ClienteRepository;
import com.api.agendamento.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HorarioRepository horarioRepository;
    
 // Método para listar todos os agendamentos por ID do cliente
    public List<AgendamentoDTO> listarAgendamentosPorCliente(Integer idCliente) {
        List<Agendamento> agendamentos = agendamentoRepository.findByClienteId(idCliente);
        return agendamentos.stream()
                .map(agendamento -> new AgendamentoDTO(
                        agendamento.getIdagendamento(),
                        agendamento.getCliente().getId(),
                        agendamento.getCliente().getNome(),      // Detalhe adicional do cliente
                        agendamento.getHorario().getId(),
                        agendamento.getHorario().getDia(),      // Detalhe adicional do horário
                        agendamento.getServicos()
                ))
                .collect(Collectors.toList());
    }

    
    
    
    
    
    // Método para criar um novo agendamento
    public AgendamentoDTO criarAgendamento(AgendamentoDTO agendamentoDTO) {
        // Buscar cliente e horário pelo ID
        Optional<Cliente> clienteOpt = clienteRepository.findById(agendamentoDTO.getIdcliente());
        Optional<Horario> horarioOpt = horarioRepository.findById(agendamentoDTO.getIdhorario());

        // Verificar se o cliente e o horário existem
        if (!clienteOpt.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        if (!horarioOpt.isPresent()) {
            throw new RuntimeException("Horário não encontrado");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(clienteOpt.get());
        agendamento.setHorario(horarioOpt.get());
        agendamento.setServicos(agendamentoDTO.getServicos());

        // Salvar agendamento
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);

        return new AgendamentoDTO(
                agendamentoSalvo.getIdagendamento(),
                agendamentoSalvo.getCliente().getId(),
                agendamentoSalvo.getCliente().getNome(),      // Detalhe adicional do cliente
                agendamentoSalvo.getHorario().getId(),
                agendamentoSalvo.getHorario().getDia(),      // Detalhe adicional do horário
                agendamentoSalvo.getServicos()
        );
    }

    // Método para listar todos os agendamentos
    public List<AgendamentoDTO> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream()
                .map(agendamento -> new AgendamentoDTO(
                        agendamento.getIdagendamento(),
                        agendamento.getCliente().getId(),
                        agendamento.getCliente().getNome(),      // Detalhe adicional do cliente
                        agendamento.getHorario().getId(),
                        agendamento.getHorario().getDia(),      // Detalhe adicional do horário
                        agendamento.getServicos()
                ))
                .collect(Collectors.toList());
    }

    // Método para buscar um agendamento por ID
    public AgendamentoDTO buscarAgendamentoPorId(Integer id) {
        Optional<Agendamento> agendamentoOpt = agendamentoRepository.findById(id);
        if (agendamentoOpt.isPresent()) {
            Agendamento agendamento = agendamentoOpt.get();
            return new AgendamentoDTO(
                    agendamento.getIdagendamento(),
                    agendamento.getCliente().getId(),
                    agendamento.getCliente().getNome(),         // Detalhe adicional do cliente
                    agendamento.getHorario().getId(),
                    agendamento.getHorario().getDia(),         // Detalhe adicional do horário
                    agendamento.getServicos()
            );
            
        } else {
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    // Método para excluir um agendamento por ID
    public void excluirAgendamento(Integer id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado para exclusão");
        }
        agendamentoRepository.deleteById(id);
    }
}
