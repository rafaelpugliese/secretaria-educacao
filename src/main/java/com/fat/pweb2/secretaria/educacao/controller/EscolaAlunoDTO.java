package com.fat.pweb2.secretaria.educacao.controller;

import com.fat.pweb2.secretaria.educacao.model.Aluno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
public class EscolaAlunoDTO {

    @Valid
    private Aluno aluno = new Aluno();

    private Long idEscola;
}
