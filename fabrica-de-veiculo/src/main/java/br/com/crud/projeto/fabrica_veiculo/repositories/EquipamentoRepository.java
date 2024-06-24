package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Equipamento.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Equipamento.
 */
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
