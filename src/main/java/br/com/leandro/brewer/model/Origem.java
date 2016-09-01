package br.com.leandro.brewer.model;

/**
 * Created by Leandro on 01/09/2016.
 */

public enum Origem  {


    NACIONAL("Nacional"), INTERNACIONAL("Internacional");

    private final String descricao;

    Origem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
