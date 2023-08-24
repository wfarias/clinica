package voll.example.api2.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import voll.example.api2.domain.consulta.DadosAgendamentoConsulta;
import voll.example.api2.domain.consulta.ValidacaoException;
import voll.example.api2.domain.medico.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {
	
	@Autowired
	private MedicoRepository medico;
	
	public void validar(DadosAgendamentoConsulta dados) {
		
		if(dados.idMedico() == null) {
			return;
		}
		
		var medicoEstaAtivo = medico.findAtivoById(dados.idMedico());
		
		if(!medicoEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com medico selecionado");
		}
	
	
	}
}
