package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Manutencao.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Manutencao.
 */
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
