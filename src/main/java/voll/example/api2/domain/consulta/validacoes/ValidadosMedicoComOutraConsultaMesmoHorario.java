package voll.example.api2.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import voll.example.api2.domain.consulta.ConsultaRepository;
import voll.example.api2.domain.consulta.DadosAgendamentoConsulta;
import voll.example.api2.domain.consulta.ValidacaoException;

@Component
public class ValidadosMedicoComOutraConsultaMesmoHorario implements ValidadorAgendamentoConsulta {
	
	@Autowired
	private ConsultaRepository consulta;	

	public void validar(DadosAgendamentoConsulta dados) {
		var medicoPossuiOutraConsultaMesmoHorario = consulta.existsByMedicosIdAndData(dados.idMedico(), dados.data());
		
		if(medicoPossuiOutraConsultaMesmoHorario) {
			throw new ValidacaoException("Medico já possui consulta agendada nesse mesmo horário.");
		}
	}

}
