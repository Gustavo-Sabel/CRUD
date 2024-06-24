package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Peca.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Peca.
 */
public interface PecaRepository extends JpaRepository<Peca, Long> {
}
