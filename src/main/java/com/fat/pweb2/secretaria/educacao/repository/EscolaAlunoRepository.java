package com.fat.pweb2.secretaria.educacao.repository;

import com.fat.pweb2.secretaria.educacao.model.EscolaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaAlunoRepository extends JpaRepository<EscolaAluno, Long> {
}
