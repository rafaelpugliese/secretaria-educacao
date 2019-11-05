package com.fat.pweb2.secretaria.educacao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Escola implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola")
    private Long id;

    @NotBlank(message = "Informe o nome da escola.")
    @Size(min = 3, max = 50, message = "O nome deve possuir mais que 3 e menos que 50 caracteres")
    @Column(unique = true)
    private String nome;

    @NotNull(message = "Informe o endereço da escola.")
    private String endereco;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private Set<EscolaAluno> listaEscolaAluno;


}
