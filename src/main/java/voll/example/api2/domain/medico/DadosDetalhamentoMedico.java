package voll.example.api2.domain.medico;

import voll.example.api2.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone,Especialidade especialidade, Endereco endereco){

    public DadosDetalhamentoMedico(Medicos medicos){

        this(medicos.getId(),medicos.getNome(),medicos.getEmail(),medicos.getCrm(),
             medicos.getTelefone(),medicos.getEspecialidade(),medicos.getEndereco());
    }
}
