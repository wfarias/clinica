package voll.example.api2.domain.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import voll.example.api2.domain.consulta.validacoes.ValidadorAgendamentoConsulta;
import voll.example.api2.domain.medico.MedicoRepository;
import voll.example.api2.domain.medico.Medicos;
import voll.example.api2.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
        
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do Médico informado não existe");
        };

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do Paciente informado não existe");
        };
        
        validadores.forEach(v -> v.validar(dados));

        var medico = escolherMedico(dados);
        
        if (medico == null) throw new ValidacaoException("Não existe medico disponivel nesta data");
        
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null,medico,paciente,dados.data());
        consultaRepository.save(consulta);
        
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medicos escolherMedico(DadosAgendamentoConsulta dados) {
    	
    	if(dados.idMedico() != null) {
    		return medicoRepository.getReferenceById(dados.idMedico());
    	} 
    	
    	if(dados.especialidade() == null) {
    		throw new  ValidacaoException("Especialidade é obrigatória quando médico for escolhido!");
    	}
    	
    	return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(),dados.data());
    }

    
}
