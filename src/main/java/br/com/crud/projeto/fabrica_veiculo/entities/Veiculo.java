package br.com.crud.projeto.fabrica_veiculo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Representa um veículo no sistema.
 */
@Entity
public class Veiculo {

    @Id
    private String chassi;

    private String modelo;

    private int ano;

    private String cor;

    /**
     * Construtor padrão.
     */
    public Veiculo() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param chassi o chassi do veículo.
     * @param modelo o modelo do veículo.
     * @param ano    o ano de fabricação do veículo.
     * @param cor    a cor do veículo.
     */
    public Veiculo(String chassi, String modelo, int ano, String cor) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    /**
     * Obtém o chassi do veículo.
     *
     * @return o chassi do veículo.
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * Define o chassi do veículo.
     *
     * @param chassi o chassi do veículo.
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * Obtém o modelo do veículo.
     *
     * @return o modelo do veículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do veículo.
     *
     * @param modelo o modelo do veículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém o ano de fabricação do veículo.
     *
     * @return o ano de fabricação do veículo.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o ano de fabricação do veículo.
     *
     * @param ano o ano de fabricação do veículo.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Obtém a cor do veículo.
     *
     * @return a cor do veículo.
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor do veículo.
     *
     * @param cor a cor do veículo.
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Verifica se dois objetos Veiculo são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return ano == veiculo.ano &&
                Objects.equals(chassi, veiculo.chassi) &&
                Objects.equals(modelo, veiculo.modelo) &&
                Objects.equals(cor, veiculo.cor);
    }

    /**
     * Calcula o código hash do objeto Veiculo.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(chassi, modelo, ano, cor);
    }

    /**
     * Retorna uma representação em string do objeto Veiculo.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Veiculo{" +
                "chassi='" + chassi + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                '}';
    }
}
