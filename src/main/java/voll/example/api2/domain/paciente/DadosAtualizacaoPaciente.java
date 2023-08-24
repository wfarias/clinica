package voll.example.api2.domain.paciente;

import jakarta.validation.constraints.NotNull;
import voll.example.api2.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
