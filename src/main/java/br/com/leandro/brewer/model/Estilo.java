package br.com.leandro.brewer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lpinto on 01/09/2016.
 */
@Entity
@Table(name = "estilo")
public class Estilo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;

    @OneToMany(mappedBy = "estilo")
    private List<Cerveja> cervejas;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cerveja> getCervejas() {
        return cervejas;
    }

    public void setCervejas(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estilo estilo = (Estilo) o;

        return codigo.equals(estilo.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
