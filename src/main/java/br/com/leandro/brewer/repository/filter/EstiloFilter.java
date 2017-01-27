package br.com.leandro.brewer.repository.filter;

/**
 * Created by Leandro on 27/01/2017.
 */
public class EstiloFilter {

    private String nome;

    public EstiloFilter() {
    }

    public EstiloFilter(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
