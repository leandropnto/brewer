package br.com.leandro.brewer.model;

/**
 * Created by lpinto on 01/09/2016.
 */
public enum Sabor {

    ADOCICADA("Adocicada"),
    AMARGA("Amarga"),
    FORTE("Forte"),
    FRUTADA("Frutada"),
    SUAVE("Suave");

    private final String descricao;

    Sabor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
