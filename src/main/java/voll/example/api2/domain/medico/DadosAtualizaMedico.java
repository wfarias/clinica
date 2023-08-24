package voll.example.api2.domain.medico;

import jakarta.validation.constraints.NotNull;
import voll.example.api2.domain.endereco.DadosEndereco;

public record DadosAtualizaMedico(

@NotNull
Long id, String nome,

String telefone,
DadosEndereco endereco ) {

}
