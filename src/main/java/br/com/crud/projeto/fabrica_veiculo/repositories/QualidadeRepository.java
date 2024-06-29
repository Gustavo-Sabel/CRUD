package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Qualidade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Qualidade.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Qualidade.
 */
public interface QualidadeRepository extends JpaRepository<Qualidade, Long> {
}
