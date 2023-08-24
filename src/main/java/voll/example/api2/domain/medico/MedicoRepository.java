package voll.example.api2.domain.medico;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicoRepository extends JpaRepository<Medicos,Long> {

    Page<Medicos> findAllByAtivoTrue(Pageable paginacao);
    
    @Query("""
            select m from Medicos m
            where m.ativo = true
            and m.especialidade = :especialidade
            and m.id not in(
                select c.medicos.id from Consulta c
                where
                c.data = :data
            )
            order by rand()
            limit 1
        """)
    Medicos escolherMedicoAleatorioLivreNaData(Especialidade especialidade,LocalDateTime data);
    
    
    @Query("""
            select m.ativo
            from Medicos m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
    
}
