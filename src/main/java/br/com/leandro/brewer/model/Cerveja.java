package br.com.leandro.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Modelo para representação da cerveja
 * Created by Leandro on 31/08/2016.
 */
public class Cerveja implements Serializable {

    @NotBlank(message = "SKU é obrigatório")
    private String sku;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
    private String descricao;

    public Cerveja() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
