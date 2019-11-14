package com.fat.pweb2.secretaria.educacao.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface NomeEscolaProjection {

    @Value("#{target.nome}")
    String getNome();
}
