package com.fat.pweb2.gestaofesta.model;

import com.fat.pweb2.gestaofesta.model.validators.DataNascimento;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Convidado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe o nome do convidado.")
    @Size(min = 3, max = 50, message = "O nome deve possuir mais que 3 e menos que 50 caracteres")
    @Column(unique = true)
    private String nome;

    @NotNull(message = "Informe a data de nascimento do convidado")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DataNascimento
    private Date dataNascimento;

    @NotNull(message = "Informe a quantidade de acompanhantes.")
    private Integer qtdAcompanhantes;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_gravata_id", referencedColumnName = "id", nullable = false)
    private TipoGravata tipoGravata;

    @ManyToMany
    @JoinTable(
            name = "convidado_bebida",
            joinColumns = @JoinColumn(name = "convidado_id"),
            inverseJoinColumns = @JoinColumn(name = "bebida_id")
    )
    private Set<Bebida> listaBebida;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdAcompanhantes() {
        return qtdAcompanhantes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtdAcompanhantes(Integer qtdAcompanhantes) {

        this.qtdAcompanhantes = qtdAcompanhantes;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoGravata getTipoGravata() {
        return tipoGravata;
    }

    public void setTipoGravata(TipoGravata tipoGravata) {
        this.tipoGravata = tipoGravata;
    }

    public Set<Bebida> getListaBebida() {
        return listaBebida;
    }

    public void setListaBebida(Set<Bebida> listaBebida) {
        this.listaBebida = listaBebida;
    }
}
