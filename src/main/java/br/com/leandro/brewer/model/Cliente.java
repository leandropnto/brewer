package br.com.leandro.brewer.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Leandro on 31/01/2017.
 */
@Entity
@Table(name = "cliente")
@Access(AccessType.FIELD)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;
    @Column(name = "cpf_cnpj")
    private String cpfOuCnpj;
    private String telefone;
    private String email;
    @Embedded
    private Endereco endereco;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return codigo != null ? codigo.equals(cliente.codigo) : cliente.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
