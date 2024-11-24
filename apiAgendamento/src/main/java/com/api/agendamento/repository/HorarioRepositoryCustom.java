package com.api.agendamento.repository;

import java.time.LocalDate;
import java.util.Date;

public interface HorarioRepositoryCustom {
	Integer updateAtivoByDiaAndHoras(LocalDate dia, String horas);
}
