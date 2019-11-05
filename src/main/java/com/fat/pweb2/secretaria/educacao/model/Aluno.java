package com.fat.pweb2.secretaria.educacao.model;

import com.fat.pweb2.secretaria.educacao.model.validators.DataNascimento;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    @NotEmpty(message = "Informe o nome do Aluno.")
    private String nome;

    @OneToOne(mappedBy = "aluno")
    private EscolaAluno escolaAluno;

    @NotNull(message = "Informe a data de nascimento do aluno")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DataNascimento
    private Date dataNascimento;

}
