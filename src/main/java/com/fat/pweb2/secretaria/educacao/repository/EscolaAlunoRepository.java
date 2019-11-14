package com.fat.pweb2.secretaria.educacao.repository;

import com.fat.pweb2.secretaria.educacao.model.EscolaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaAlunoRepository extends JpaRepository<EscolaAluno, Long> {

    @Query(value = "select count(*) from escola_aluno where id_escola  = :idEscola", nativeQuery = true)
    Long listarQuantidadeAlunosSQL(@Param("idEscola") Long idEscola);

    Long countByEscola_Id(Long escola_id);


    @Query(value = "select count(ea) from EscolaAluno ea where ea.escola.id = :idEscola")
    Long contarPorIdEscolaJPQL(@Param("idEscola") Long escola_id);
}
