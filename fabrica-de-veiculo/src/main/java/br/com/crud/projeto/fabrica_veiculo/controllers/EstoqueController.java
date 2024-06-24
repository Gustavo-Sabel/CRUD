package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Estoque;
import br.com.crud.projeto.fabrica_veiculo.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de estoque.
 */
@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    /**
     * Obtém todos os registros de estoque.
     *
     * @return Uma lista contendo todos os registros de estoque cadastrados.
     */
    @GetMapping
    public List<Estoque> getAllEstoque() {
        return estoqueRepository.findAll();
    }

    /**
     * Obtém um registro de estoque pelo seu ID.
     *
     * @param id O ID do registro de estoque desejado.
     * @return ResponseEntity contendo o registro de estoque encontrado, se existir.
     *         Retorna ResponseEntity.notFound() se nenhum registro de estoque com o ID especificado for encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
        Optional<Estoque> estoqueBuscado = estoqueRepository.findById(id);
        return estoqueBuscado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo registro de estoque.
     *
     * @param estoque O novo registro de estoque a ser criado. Deve ser enviado no corpo da requisição (RequestBody).
     * @return O registro de estoque criado, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    /**
     * Atualiza um registro de estoque existente.
     *
     * @param id                        O ID do registro de estoque a ser atualizado.
     * @param estoqueComDadosAtualizados Os novos dados do registro de estoque a serem atualizados.
     * @return ResponseEntity contendo o registro de estoque atualizado, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhum registro de estoque com o ID especificado for encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable Long id,
                                                 @RequestBody Estoque estoqueComDadosAtualizados) {
        Optional<Estoque> estoqueExistente = estoqueRepository.findById(id);
        if (estoqueExistente.isPresent()) {
            estoqueComDadosAtualizados.setIdEstoque(id);
            return ResponseEntity.ok(estoqueRepository.save(estoqueComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um registro de estoque pelo seu ID.
     *
     * @param id O ID do registro de estoque a ser excluído.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se o registro de estoque foi excluído com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhum registro de estoque com o ID especificado for encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        Optional<Estoque> estoqueParaDeletar = estoqueRepository.findById(id);
        if (estoqueParaDeletar.isPresent()) {
            estoqueRepository.delete(estoqueParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
