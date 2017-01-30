package br.com.leandro.brewer.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Leandro on 29/01/2017.
 */
@Entity
@Table(name = "estado")
@Access(AccessType.FIELD)
public class Estado implements Serializable {


    @Id
    private Integer codigo;
    private String nome;
    private String sigla;

    protected Estado() {
    }

    public Estado(Integer codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        if (!codigo.equals(estado.codigo)) return false;
        return nome != null ? nome.equals(estado.nome) : estado.nome == null;
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
