package br.com.crud.projeto.fabrica_veiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Representa uma produção no sistema.
 */
@Entity
public class Producao {

    @JsonIgnore
    @OneToMany(mappedBy = "producao")
    private List<Qualidade> listaDeQualidade;

    @ManyToOne
    @JoinColumn(name = "idPeca", referencedColumnName = "idPeca")
    private Peca peca;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    private LocalDateTime datahoraProducao;
    private int quantidadeproduzidaProducao;
    private String estadoProducao;

    /**
     * Construtor padrão.
     */
    public Producao() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param listaDeQualidade            a lista de objetos Qualidade associados a esta produção.
     * @param peca                        o objeto Peca associado a esta produção.
     * @param idProducao                  o ID da produção.
     * @param datahoraProducao            a data e hora da produção.
     * @param quantidadeproduzidaProducao a quantidade produzida nesta produção.
     * @param estadoProducao              o estado da produção.
     */
    public Producao(List<Qualidade> listaDeQualidade, Peca peca, Long idProducao, LocalDateTime datahoraProducao, int quantidadeproduzidaProducao, String estadoProducao) {
        this.listaDeQualidade = listaDeQualidade;
        this.peca = peca;
        this.idProducao = idProducao;
        this.datahoraProducao = datahoraProducao;
        this.quantidadeproduzidaProducao = quantidadeproduzidaProducao;
        this.estadoProducao = estadoProducao;
    }

    /**
     * Obtém a lista de objetos Qualidade associados a esta produção.
     *
     * @return a lista de objetos Qualidade.
     */
    public List<Qualidade> getListaDeQualidade() {
        return listaDeQualidade;
    }

    /**
     * Define a lista de objetos Qualidade associados a esta produção.
     *
     * @param listaDeQualidade a lista de objetos Qualidade.
     */
    public void setListaDeQualidade(List<Qualidade> listaDeQualidade) {
        this.listaDeQualidade = listaDeQualidade;
    }

    /**
     * Obtém o objeto Peca associado a esta produção.
     *
     * @return o objeto Peca.
     */
    public Peca getPeca() {
        return peca;
    }

    /**
     * Define o objeto Peca associado a esta produção.
     *
     * @param peca o objeto Peca.
     */
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    /**
     * Obtém o ID da produção.
     *
     * @return o ID da produção.
     */
    public Long getIdProducao() {
        return idProducao;
    }

    /**
     * Define o ID da produção.
     *
     * @param idProducao o ID da produção.
     */
    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
    }

    /**
     * Obtém a data e hora da produção.
     *
     * @return a data e hora da produção.
     */
    public LocalDateTime getDatahoraProducao() {
        return datahoraProducao;
    }

    /**
     * Define a data e hora da produção.
     *
     * @param datahoraProducao a data e hora da produção.
     */
    public void setDatahoraProducao(LocalDateTime datahoraProducao) {
        this.datahoraProducao = datahoraProducao;
    }

    /**
     * Obtém a quantidade produzida nesta produção.
     *
     * @return a quantidade produzida.
     */
    public int getQuantidadeproduzidaProducao() {
        return quantidadeproduzidaProducao;
    }

    /**
     * Define a quantidade produzida nesta produção.
     *
     * @param quantidadeproduzidaProducao a quantidade produzida.
     */
    public void setQuantidadeproduzidaProducao(int quantidadeproduzidaProducao) {
        this.quantidadeproduzidaProducao = quantidadeproduzidaProducao;
    }

    /**
     * Obtém o estado da produção.
     *
     * @return o estado da produção.
     */
    public String getEstadoProducao() {
        return estadoProducao;
    }

    /**
     * Define o estado da produção.
     *
     * @param estadoProducao o estado da produção.
     */
    public void setEstadoProducao(String estadoProducao) {
        this.estadoProducao = estadoProducao;
    }

    /**
     * Verifica se dois objetos Produção são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producao producao = (Producao) o;

        if (quantidadeproduzidaProducao != producao.quantidadeproduzidaProducao) return false;
        if (!Objects.equals(listaDeQualidade, producao.listaDeQualidade)) return false;
        if (!Objects.equals(peca, producao.peca)) return false;
        if (!idProducao.equals(producao.idProducao)) return false;
        if (!Objects.equals(datahoraProducao, producao.datahoraProducao)) return false;
        return Objects.equals(estadoProducao, producao.estadoProducao);
    }

    /**
     * Calcula o código hash do objeto Produção.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        int result = listaDeQualidade != null ? listaDeQualidade.hashCode() : 0;
        result = 31 * result + (peca != null ? peca.hashCode() : 0);
        result = 31 * result + idProducao.hashCode();
        result = 31 * result + (datahoraProducao != null ? datahoraProducao.hashCode() : 0);
        result = 31 * result + quantidadeproduzidaProducao;
        result = 31 * result + (estadoProducao != null ? estadoProducao.hashCode() : 0);
        return result;
    }

    /**
     * Retorna uma representação em string do objeto Produção.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Producao{" +
                "listaDeQualidade=" + listaDeQualidade +
                ", peca=" + peca +
                ", idProducao=" + idProducao +
                ", datahoraProducao=" + datahoraProducao +
                ", quantidadeproduzidaProducao=" + quantidadeproduzidaProducao +
                ", estadoProducao='" + estadoProducao + '\'' +
                '}';
    }
}
