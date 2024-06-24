package br.com.crud.projeto.fabrica_veiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Representa uma qualidade no sistema.
 */
@Entity
public class Qualidade {

    @ManyToOne
    @JoinColumn(name = "idProducao", referencedColumnName = "idProducao")
    private Producao producao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idinspecaoqualidade;

    private int dataHora;

    private String resultado;

    private String comentario;

    /**
     * Construtor padrão.
     */
    public Qualidade() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param producao            o objeto Producao associado.
     * @param idinspecaoqualidade o ID da inspeção de qualidade.
     * @param dataHora            a data e hora da inspeção.
     * @param resultado           o resultado da inspeção.
     * @param comentario          o comentário do inspetor.
     */
    public Qualidade(Producao producao, Long idinspecaoqualidade, int dataHora, String resultado, String comentario) {
        this.producao = producao;
        this.idinspecaoqualidade = idinspecaoqualidade;
        this.dataHora = dataHora;
        this.resultado = resultado;
        this.comentario = comentario;
    }

    /**
     * Obtém o objeto Producao associado.
     *
     * @return o objeto Producao.
     */
    public Producao getProducao() {
        return producao;
    }

    /**
     * Define o objeto Producao associado.
     *
     * @param producao o objeto Producao.
     */
    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    /**
     * Obtém o ID da inspeção de qualidade.
     *
     * @return o ID da inspeção de qualidade.
     */
    public Long getIdinspecaoqualidade() {
        return idinspecaoqualidade;
    }

    /**
     * Define o ID da inspeção de qualidade.
     *
     * @param idinspecaoqualidade o ID da inspeção de qualidade.
     */
    public void setIdinspecaoqualidade(Long idinspecaoqualidade) {
        this.idinspecaoqualidade = idinspecaoqualidade;
    }

    /**
     * Obtém a data e hora da inspeção.
     *
     * @return a data e hora da inspeção.
     */
    public int getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da inspeção.
     *
     * @param dataHora a data e hora da inspeção.
     */
    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Obtém o resultado da inspeção.
     *
     * @return o resultado da inspeção.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define o resultado da inspeção.
     *
     * @param resultado o resultado da inspeção.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtém o comentário do inspetor.
     *
     * @return o comentário do inspetor.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Define o comentário do inspetor.
     *
     * @param comentario o comentário do inspetor.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Verifica se dois objetos Qualidade são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qualidade qualidade = (Qualidade) o;

        if (dataHora != qualidade.dataHora) return false;
        if (!producao.equals(qualidade.producao)) return false;
        if (!Objects.equals(idinspecaoqualidade, qualidade.idinspecaoqualidade))
            return false;
        if (!Objects.equals(resultado, qualidade.resultado)) return false;
        return Objects.equals(comentario, qualidade.comentario);
    }

    /**
     * Calcula o código hash do objeto Qualidade.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        int result = producao.hashCode();
        result = 31 * result + (idinspecaoqualidade != null ? idinspecaoqualidade.hashCode() : 0);
        result = 31 * result + dataHora;
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentario != null ? comentario.hashCode() : 0);
        return result;
    }

    /**
     * Retorna uma representação em string do objeto Qualidade.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Qualidade{" +
                "producao=" + producao +
                ", idinspecaoqualidade=" + idinspecaoqualidade +
                ", dataHora=" + dataHora +
                ", resultado='" + resultado + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
