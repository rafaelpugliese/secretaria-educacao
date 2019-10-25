package com.fat.pweb2.gestaofesta.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Bebida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Informe o tipo de bebida.")
    private String tipo;

    @NotEmpty(message = "Informe o nome da bebida.")
    private String nome;

    @ManyToMany(mappedBy = "listaBebida")
    private Set<Convidado> listaConvidado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Convidado> getListaConvidado() {
        return listaConvidado;
    }

    public void setListaConvidado(Set<Convidado> listaConvidado) {
        this.listaConvidado = listaConvidado;
    }
}
