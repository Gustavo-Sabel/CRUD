package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Producao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Producao.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Producao.
 */
public interface ProducaoRepository extends JpaRepository<Producao, Long> {
}
