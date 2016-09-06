package br.com.leandro.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsável pelo mapeamento para a entidade estilo na base de dados.
 * @author Leandro
 * @version 1.0
 * Created by lpinto on 01/09/2016.
 */
@Entity
@Table(name = "estilo")
public class Estilo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 1, max = 15, message = "O tamanho do nome deve estar entre 1 e 15")
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
}
