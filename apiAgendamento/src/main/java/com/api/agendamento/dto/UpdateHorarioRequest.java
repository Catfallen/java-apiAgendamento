package com.api.agendamento.dto;

import java.time.LocalDate;
import java.util.Date;

public class UpdateHorarioRequest {

    private LocalDate dia;
    private String horas;

    // Getters e Setters
    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
}
