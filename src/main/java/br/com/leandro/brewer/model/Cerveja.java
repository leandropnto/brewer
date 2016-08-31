package br.com.leandro.brewer.model;

import java.io.Serializable;

/**
 * Modelo para representação da cerveja
 * Created by Leandro on 31/08/2016.
 */
public class Cerveja implements Serializable {

    private String sku;
    private String nome;

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
}
