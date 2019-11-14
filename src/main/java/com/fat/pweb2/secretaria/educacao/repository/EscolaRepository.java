package com.fat.pweb2.secretaria.educacao.repository;

import com.fat.pweb2.secretaria.educacao.model.Escola;
import com.fat.pweb2.secretaria.educacao.repository.projection.NomeEscolaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

    @Query(value = "SELECT count(e) from Escola e")
    Long listarQuantidadeEscolas();

    List<NomeEscolaProjection> findByNomeIs(String nome);
}
