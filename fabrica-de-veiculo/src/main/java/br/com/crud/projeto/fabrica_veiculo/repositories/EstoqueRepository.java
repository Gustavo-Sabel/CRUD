package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Estoque.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Estoque.
 */
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
