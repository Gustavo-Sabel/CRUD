package br.com.crud.projeto.fabrica_veiculo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa uma manutenção no sistema.
 */
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManutencao;
    private LocalDateTime dataHoraIncio;
    private LocalDateTime dataHoraFim;
    private String descricao;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    private Equipamento equipamento;

    /**
     * Construtor padrão.
     */
    public Manutencao() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param idManutencao o ID da manutenção.
     * @param equipamento o equipamento associado à manutenção.
     * @param dataHoraIncio a data e hora de início da manutenção.
     * @param dataHoraFim a data e hora de término da manutenção.
     * @param descricao a descrição da manutenção.
     * @param estado o estado da manutenção.
     */
    public Manutencao(Long idManutencao, Equipamento equipamento, LocalDateTime dataHoraIncio, LocalDateTime dataHoraFim, String descricao, String estado) {
        this.idManutencao = idManutencao;
        this.equipamento = equipamento;
        this.dataHoraIncio = dataHoraIncio;
        this.dataHoraFim = dataHoraFim;
        this.descricao = descricao;
        this.estado = estado;
    }

    /**
     * Obtém o ID da manutenção.
     *
     * @return o ID da manutenção.
     */
    public Long getIdManutencao() {
        return idManutencao;
    }

    /**
     * Define o ID da manutenção.
     *
     * @param idManutencao o novo ID da manutenção.
     */
    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    /**
     * Obtém o equipamento associado à manutenção.
     *
     * @return o equipamento associado.
     */
    public Equipamento getEquipamento() {
        return equipamento;
    }

    /**
     * Define o equipamento associado à manutenção.
     *
     * @param equipamento o novo equipamento associado.
     */
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    /**
     * Obtém a data e hora de início da manutenção.
     *
     * @return a data e hora de início.
     */
    public LocalDateTime getDataHoraIncio() {
        return dataHoraIncio;
    }

    /**
     * Define a data e hora de início da manutenção.
     *
     * @param dataHoraIncio a nova data e hora de início.
     */
    public void setDataHoraIncio(LocalDateTime dataHoraIncio) {
        this.dataHoraIncio = dataHoraIncio;
    }

    /**
     * Obtém a data e hora de término da manutenção.
     *
     * @return a data e hora de término.
     */
    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    /**
     * Define a data e hora de término da manutenção.
     *
     * @param dataHoraFim a nova data e hora de término.
     */
    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    /**
     * Obtém a descrição da manutenção.
     *
     * @return a descrição da manutenção.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da manutenção.
     *
     * @param descricao a nova descrição da manutenção.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o estado da manutenção.
     *
     * @return o estado da manutenção.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o estado da manutenção.
     *
     * @param estado o novo estado da manutenção.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Verifica se dois objetos Manutenção são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manutencao that = (Manutencao) o;

        if (!idManutencao.equals(that.idManutencao)) return false;
        if (!Objects.equals(dataHoraIncio, that.dataHoraIncio)) return false;
        if (!Objects.equals(dataHoraFim, that.dataHoraFim)) return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (!Objects.equals(estado, that.estado)) return false;
        return Objects.equals(equipamento, that.equipamento);
    }

    /**
     * Calcula o código hash do objeto Manutenção.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        int result = idManutencao.hashCode();
        result = 31 * result + (dataHoraIncio != null ? dataHoraIncio.hashCode() : 0);
        result = 31 * result + (dataHoraFim != null ? dataHoraFim.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (equipamento != null ? equipamento.hashCode() : 0);
        return result;
    }

    /**
     * Retorna uma representação em string do objeto Manutenção.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Manutencao{" +
                "equipamento=" + equipamento +
                ", idManutencao=" + idManutencao +
                ", dataHoraIncio=" + dataHoraIncio +
                ", dataHoraFim=" + dataHoraFim +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
