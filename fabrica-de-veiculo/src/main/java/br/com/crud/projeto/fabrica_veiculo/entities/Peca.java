package br.com.crud.projeto.fabrica_veiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Representa uma peça no sistema.
 */
@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeca;
    private String nomePeca;
    private String descricaoPeca;

    @JsonIgnore
    @OneToMany(mappedBy = "peca")
    private List<Estoque> listaDeEstoque;

    /**
     * Construtor padrão.
     */
    public Peca() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param idPeca          o ID da peça.
     * @param nomePeca        a identificação da peça.
     * @param descricaoPeca   a descrição da peça.
     * @param listaDeEstoque  a lista de estoques associados à peça.
     */
    public Peca(Long idPeca, String nomePeca, String descricaoPeca, List<Estoque> listaDeEstoque) {
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.descricaoPeca = descricaoPeca;
        this.listaDeEstoque = listaDeEstoque;
    }

    /**
     * Obtém o ID da peça.
     *
     * @return o ID da peça.
     */
    public Long getIdPeca() {
        return idPeca;
    }

    /**
     * Define o ID da peça.
     *
     * @param idPeca o novo ID da peça.
     */
    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    /**
     * Obtém a identificação da peça.
     *
     * @return a identificação da peça.
     */
    public String getNomePeca() {
        return nomePeca;
    }

    /**
     * Define a identificação da peça.
     *
     * @param nomePeca a nova identificação da peça.
     */
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    /**
     * Obtém a descrição da peça.
     *
     * @return a descrição da peça.
     */
    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    /**
     * Define a descrição da peça.
     *
     * @param descricaoPeca a nova descrição da peça.
     */
    public void setDescricaoPeca(String descricaoPeca) {
        this.descricaoPeca = descricaoPeca;
    }

    /**
     * Obtém a lista de estoques associados à peça.
     *
     * @return a lista de estoques.
     */
    public List<Estoque> getListaDeEstoque() {
        return listaDeEstoque;
    }

    /**
     * Define a lista de estoques associados à peça.
     *
     * @param listaDeEstoque a nova lista de estoques.
     */
    public void setListaDeEstoque(List<Estoque> listaDeEstoque) {
        this.listaDeEstoque = listaDeEstoque;
    }

    /**
     * Verifica se dois objetos Peca são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peca peca = (Peca) o;

        if (!idPeca.equals(peca.idPeca)) return false;
        if (!Objects.equals(nomePeca, peca.nomePeca)) return false;
        if (!Objects.equals(descricaoPeca, peca.descricaoPeca))
            return false;
        return Objects.equals(listaDeEstoque, peca.listaDeEstoque);
    }

    /**
     * Calcula o código hash do objeto Peca.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        int result = idPeca.hashCode();
        result = 31 * result + (nomePeca != null ? nomePeca.hashCode() : 0);
        result = 31 * result + (descricaoPeca != null ? descricaoPeca.hashCode() : 0);
        result = 31 * result + (listaDeEstoque != null ? listaDeEstoque.hashCode() : 0);
        return result;
    }

    /**
     * Retorna uma representação em string do objeto Peca.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Peca{" +
                "idPeca=" + idPeca +
                ", nomePeca='" + nomePeca + '\'' +
                ", descricaoPeca='" + descricaoPeca + '\'' +
                ", listaDeEstoque=" + listaDeEstoque +
                '}';
    }
}
