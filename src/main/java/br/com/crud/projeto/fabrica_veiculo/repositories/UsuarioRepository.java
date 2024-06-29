package br.com.crud.projeto.fabrica_veiculo.repositories;

import br.com.crud.projeto.fabrica_veiculo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para a entidade Usuario.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD básicos para a entidade Usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
