package voll.example.api2.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
	
	public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedicos().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
