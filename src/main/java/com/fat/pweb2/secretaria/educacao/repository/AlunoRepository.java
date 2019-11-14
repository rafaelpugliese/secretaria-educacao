package com.fat.pweb2.secretaria.educacao.repository;

import com.fat.pweb2.secretaria.educacao.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
