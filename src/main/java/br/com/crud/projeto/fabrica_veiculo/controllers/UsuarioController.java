package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Usuario;
import br.com.crud.projeto.fabrica_veiculo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de usuários.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtém todos os usuários cadastrados.
     *
     * @return Uma lista contendo todos os usuários.
     */
    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtém um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return ResponseEntity contendo o usuário encontrado, se existir.
     *         Retorna ResponseEntity.notFound() se nenhum usuário com o ID especificado for encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        return usuarioBuscado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo usuário.
     *
     * @param usuario O usuário a ser criado. Deve ser enviado no corpo da requisição (RequestBody).
     * @return O usuário criado, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param id                 O ID do usuário a ser atualizado.
     * @param usuarioAtualizar   Os novos dados do usuário a serem atualizados.
     * @return ResponseEntity contendo o usuário atualizado, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhum usuário com o ID especificado for encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,
                                                 @RequestBody Usuario usuarioAtualizar) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuarioAtualizar.setIdusuario(id);
            return ResponseEntity.ok(usuarioRepository.save(usuarioAtualizar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser excluído.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se o usuário foi excluído com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhum usuário com o ID especificado for encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioParaDeletar = usuarioRepository.findById(id);
        if (usuarioParaDeletar.isPresent()) {
            usuarioRepository.delete(usuarioParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
