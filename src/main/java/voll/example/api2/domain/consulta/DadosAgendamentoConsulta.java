package voll.example.api2.domain.consulta;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import voll.example.api2.domain.medico.Especialidade;

public record DadosAgendamentoConsulta(

    @JsonAlias("medico_id") Long idMedico,

    @NotNull
    @JsonAlias({"paciente_id","id_paciente"})
    Long idPaciente,

    @NotNull
    @Future
    LocalDateTime data,
    
    Especialidade especialidade ) {

}
