package com.api.agendamento.dto;

import java.time.LocalDate;

public class AgendamentoDTO {
    private Integer idagendamento;
    private Integer idcliente;
    private String nomeCliente; // Novo campo para detalhar
    private Integer idhorario;
    private LocalDate diaHorario; // Novo campo para detalhar
    private String servicos;

    // Construtor, getters e setters
    public AgendamentoDTO(Integer idagendamento, Integer idcliente, String nomeCliente, Integer idhorario, LocalDate diaHorario, String servicos) {
        this.idagendamento = idagendamento;
        this.idcliente = idcliente;
        this.nomeCliente = nomeCliente;
        this.idhorario = idhorario;
        this.diaHorario = diaHorario;
        this.servicos = servicos;
    }

	public Integer getIdagendamento() {
		return idagendamento;
	}

	public void setIdagendamento(Integer idagendamento) {
		this.idagendamento = idagendamento;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(Integer idhorario) {
		this.idhorario = idhorario;
	}

	public LocalDate getDiaHorario() {
		return diaHorario;
	}

	public void setDiaHorario(LocalDate diaHorario) {
		this.diaHorario = diaHorario;
	}

	public String getServicos() {
		return servicos;
	}

	public void setServicos(String servicos) {
		this.servicos = servicos;
	}

    // Getters e Setters
}
