package com.fat.pweb2.gestaofesta.repository;

import com.fat.pweb2.gestaofesta.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

    @Query(
            value = "SELECT c FROM Convidado c ORDER BY c.nome DESC"
    )
    List<Convidado> findAll();

}
