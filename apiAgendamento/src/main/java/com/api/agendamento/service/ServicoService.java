package com.api.agendamento.service;

import com.api.agendamento.model.Servico;
import com.api.agendamento.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> getServicoById(Integer id) {
        return servicoRepository.findById(id);
    }

    public Servico createServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico updateServico(Integer id, Servico servico) {
        if (servicoRepository.existsById(id)) {
            servico.setId(id);
            return servicoRepository.save(servico);
        }
        return null; // Ou lançar uma exceção
    }

    public boolean deleteServico(Integer id) {
        if (servicoRepository.existsById(id)) {
            servicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
