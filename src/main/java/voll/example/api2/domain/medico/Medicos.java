package voll.example.api2.domain.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import voll.example.api2.domain.endereco.Endereco;


@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medicos {
    

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco; 
    private Boolean ativo;

    public Medicos(DadosCadastroMedico dados) {
        this.nome          = dados.nome();
        this.email         = dados.email();
        this.crm           = dados.crm();
        this.telefone      = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco      = new Endereco(dados.endereco());
        this.ativo         = true;
    }

    public void atualizarInformacoes(DadosAtualizaMedico dados) {
        if(dados.nome() != null)
            this.nome = dados.nome();
    }

    public void excluir() {
        this.ativo = false;
    }
}
