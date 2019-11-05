package com.fat.pweb2.secretaria.educacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class EscolaAluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola_aluno")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_escola", referencedColumnName = "id_escola", nullable = false)
    private Escola escola;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno", nullable = false)
    private Aluno aluno;
}
