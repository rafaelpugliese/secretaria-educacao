package com.fat.pweb2.gestaofesta.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class TipoGravata implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe a cor da gravata.")
    private String cor;

    @NotBlank(message = "Informe o tamanho da gravata.")
    @Size(min = 1, max = 1, message = "As opções para o tamanho da gravata são P, M e G.")
    private String tamanho;

//    @OneToMany(mappedBy = "tipoGravata", fetch = FetchType.EAGER)
//    private Set<Convidado> convidados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
