package voll.example.api2.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import voll.example.api2.domain.consulta.ConsultaRepository;
import voll.example.api2.domain.consulta.DadosAgendamentoConsulta;
import voll.example.api2.domain.consulta.ValidacaoException;

@Component
public class ValidadosPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoConsulta{
	
	@Autowired
	private ConsultaRepository consulta;
	
	public void validar(DadosAgendamentoConsulta dados) {
		
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);
		var pacientePossuiOutraConsultaNoDia = consulta.existsByPacienteIdAndDataBetween(dados.idPaciente(),primeiroHorario,ultimoHorario);
		
		if(pacientePossuiOutraConsultaNoDia) {
			throw new ValidacaoException("Paciente já possui uma consulta agendada neste dia");
		}
		
	}

}
