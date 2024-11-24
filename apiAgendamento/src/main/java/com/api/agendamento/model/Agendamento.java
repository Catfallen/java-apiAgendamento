package com.api.agendamento.model;
import jakarta.persistence.*;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento_id_seq")
    @SequenceGenerator(name = "agendamento_id_seq", sequenceName = "agendamento_idagendamento_seq", allocationSize = 1)
    @Column(name = "idagendamento")
    private Integer idagendamento;

    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;  // Relacionamento com a entidade Cliente

    @ManyToOne
    @JoinColumn(name = "idhorario", nullable = false)
    private Horario horario;  // Relacionamento com a entidade Horario

    @Column(name = "servicos")
    private String servicos;

    // Construtor padrão
    public Agendamento() {}

    // Construtor completo
    public Agendamento(Cliente cliente, Horario horario, String servicos) {
        this.cliente = cliente;
        this.horario = horario;
        this.servicos = servicos;
    }

    // Getters e Setters
    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }
}
