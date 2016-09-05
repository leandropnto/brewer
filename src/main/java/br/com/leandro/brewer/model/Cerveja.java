package br.com.leandro.brewer.model;

import br.com.leandro.brewer.validation.SKU;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Modelo para representação da cerveja
 * Created by Leandro on 31/08/2016.
 */
@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @SKU
    @NotBlank(message = "SKU é obrigatório")
    private String sku;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "9999999.99", message = "O valor da cerveja deve ser menor que R$ 9.999.999,99")
    private BigDecimal valor;

    @NotNull(message = "O teor alcóolico é obrigatório")
    @DecimalMax(value = "100.0", message = "o valor do teor alcóolico dever menor que 100")
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcoolico;

    @DecimalMax(value = "100.0", message = "A comissão dever ser igual ou menor que 100")
    private BigDecimal comissao;

    @Max(value = 9999, message = "A quantidade em estoque deve ser menor que 9.999")
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @NotNull(message = "A origem é obrigatória")
    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull(message = "O sabor é obrigatório")
    @Enumerated(EnumType.STRING)
    private Sabor sabor;


    @NotNull(message = "O estilo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cerveja other = (Cerveja) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
