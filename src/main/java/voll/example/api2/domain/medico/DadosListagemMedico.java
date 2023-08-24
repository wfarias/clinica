package voll.example.api2.domain.medico;

public record DadosListagemMedico(Long id,String nome, String email, String crm, Especialidade especialidade) {

  public  DadosListagemMedico(Medicos medicos){
            this(medicos.getId(),medicos.getNome(),medicos.getEmail(),medicos.getCrm(),medicos.getEspecialidade());
    }

}
