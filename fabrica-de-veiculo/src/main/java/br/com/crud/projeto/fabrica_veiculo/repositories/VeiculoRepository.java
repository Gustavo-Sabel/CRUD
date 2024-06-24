package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Veiculo.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Veiculo.
 */
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
