package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Peca;
import br.com.crud.projeto.fabrica_veiculo.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de peças.
 */
@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaRepository pecaRepository;

    /**
     * Obtém todas as peças cadastradas.
     *
     * @return Uma lista contendo todas as peças cadastradas.
     */
    @GetMapping
    public List<Peca> getAllPeca() {
        return pecaRepository.findAll();
    }

    /**
     * Obtém uma peça pelo seu ID.
     *
     * @param id O ID da peça desejada.
     * @return ResponseEntity contendo a peça encontrada, se existir.
     *         Retorna ResponseEntity.notFound() se nenhuma peça com o ID especificado for encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Peca> getPecaById(@PathVariable Long id) {
        Optional<Peca> pecaBuscada = pecaRepository.findById(id);
        return pecaBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova peça.
     *
     * @param peca A nova peça a ser criada. Deve ser enviada no corpo da requisição (RequestBody).
     * @return A peça criada, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Peca createPeca(@RequestBody Peca peca) {
        return pecaRepository.save(peca);
    }

    /**
     * Atualiza uma peça existente.
     *
     * @param id                          O ID da peça a ser atualizada.
     * @param pecaComDadosAtualizados     Os novos dados da peça a serem atualizados.
     * @return ResponseEntity contendo a peça atualizada, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhuma peça com o ID especificado for encontrada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Peca> updatePeca(@PathVariable Long id,
                                           @RequestBody Peca pecaComDadosAtualizados) {
        Optional<Peca> pecaExistente = pecaRepository.findById(id);
        if (pecaExistente.isPresent()) {
            pecaComDadosAtualizados.setIdPeca(id);
            return ResponseEntity.ok(pecaRepository.save(pecaComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma peça pelo seu ID.
     *
     * @param id O ID da peça a ser excluída.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se a peça foi excluída com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhuma peça com o ID especificado for encontrada.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Peca> pecaParaDeletar = pecaRepository.findById(id);
        if (pecaParaDeletar.isPresent()) {
            pecaRepository.delete(pecaParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
