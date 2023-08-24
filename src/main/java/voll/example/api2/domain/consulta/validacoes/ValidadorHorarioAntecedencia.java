package voll.example.api2.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import voll.example.api2.domain.consulta.DadosAgendamentoConsulta;
import voll.example.api2.domain.consulta.ValidacaoException;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {


	public void validar(DadosAgendamentoConsulta dados) {
	
		var dataConsulta = dados.data();
		var agora = LocalDateTime.now();
		var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();
		
		if(diferencaEmMinutos < 30) {
			throw new ValidacaoException("Consulta deve ser agendada com antecedência minima de 30 minutos");
		}
	}
}
