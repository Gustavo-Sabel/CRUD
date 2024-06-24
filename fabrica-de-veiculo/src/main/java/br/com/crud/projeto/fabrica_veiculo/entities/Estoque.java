package br.com.crud.projeto.fabrica_veiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Representa um estoque no sistema.
 */
@Entity
public class Estoque {

    @ManyToOne
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca peca;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;
    private int quantidadedisponivelEstoque;

    /**
     * Construtor padrão.
     */
    public Estoque() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param peca                     o ID da peça.
     * @param idEstoque                o ID do estoque.
     * @param quantidadedisponivelEstoque a quantidade disponível no estoque.
     */
    public Estoque(Peca peca, Long idEstoque, int quantidadedisponivelEstoque) {
        this.peca = peca;
        this.idEstoque = idEstoque;
        this.quantidadedisponivelEstoque = quantidadedisponivelEstoque;
    }

    /**
     * Obtém a peça.
     *
     * @return a peça.
     */
    public Peca getPeca() {
        return peca;
    }

    /**
     * Define a peça.
     *
     * @param peca a nova peça.
     */
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    /**
     * Obtém o ID do estoque.
     *
     * @return o ID do estoque.
     */
    public Long getIdEstoque() {
        return idEstoque;
    }

    /**
     * Define o ID do estoque.
     *
     * @param idEstoque o novo ID do estoque.
     */
    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    /**
     * Obtém a quantidade disponível no estoque.
     *
     * @return a quantidade disponível no estoque.
     */
    public int getQuantidadedisponivelEstoque() {
        return quantidadedisponivelEstoque;
    }

    /**
     * Define a quantidade disponível no estoque.
     *
     * @param quantidadedisponivelEstoque a nova quantidade disponível no estoque.
     */
    public void setQuantidadedisponivelEstoque(int quantidadedisponivelEstoque) {
        this.quantidadedisponivelEstoque = quantidadedisponivelEstoque;
    }

    /**
     * Verifica se dois objetos Estoque são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        if (quantidadedisponivelEstoque != estoque.quantidadedisponivelEstoque) return false;
        if (!Objects.equals(peca, estoque.peca)) return false;
        return Objects.equals(idEstoque, estoque.idEstoque);
    }

    /**
     * Calcula o código hash do objeto Estoque.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        int result = peca != null ? peca.hashCode() : 0;
        result = 31 * result + (idEstoque != null ? idEstoque.hashCode() : 0);
        result = 31 * result + quantidadedisponivelEstoque;
        return result;
    }

    /**
     * Retorna uma representação em string do objeto Estoque.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Estoque{" +
                "peca=" + peca +
                ", idEstoque=" + idEstoque +
                ", quantidadedisponivelEstoque=" + quantidadedisponivelEstoque +
                '}';
    }
}
