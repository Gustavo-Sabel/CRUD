package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Manutencao;
import br.com.crud.projeto.fabrica_veiculo.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de manutenções.
 */
@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    /**
     * Obtém todas as manutenções cadastradas.
     *
     * @return Uma lista contendo todas as manutenções cadastradas.
     */
    @GetMapping
    public List<Manutencao> getAllManutencoes() {
        return manutencaoRepository.findAll();
    }

    /**
     * Obtém uma manutenção pelo seu ID.
     *
     * @param id O ID da manutenção desejada.
     * @return ResponseEntity contendo a manutenção encontrada, se existir.
     *         Retorna ResponseEntity.notFound() se nenhuma manutenção com o ID especificado for encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getManutencaoById(@PathVariable Long id) {
        Optional<Manutencao> manutencaoBuscada = manutencaoRepository.findById(id);
        return manutencaoBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova manutenção.
     *
     * @param manutencao A nova manutenção a ser criada. Deve ser enviada no corpo da requisição (RequestBody).
     * @return A manutenção criada, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Manutencao createManutencao(@RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    /**
     * Atualiza uma manutenção existente.
     *
     * @param id                        O ID da manutenção a ser atualizada.
     * @param manutencaoAtualizar       Os novos dados da manutenção a serem atualizados.
     * @return ResponseEntity contendo a manutenção atualizada, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhuma manutenção com o ID especificado for encontrada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> updateManutencao(@PathVariable Long id,
                                                       @RequestBody Manutencao manutencaoAtualizar) {
        Optional<Manutencao> manutencaoExistente = manutencaoRepository.findById(id);
        if (manutencaoExistente.isPresent()) {
            manutencaoAtualizar.setIdManutencao(id);
            return ResponseEntity.ok(manutencaoRepository.save(manutencaoAtualizar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma manutenção pelo seu ID.
     *
     * @param id O ID da manutenção a ser excluída.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se a manutenção foi excluída com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhuma manutenção com o ID especificado for encontrada.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManutencao(@PathVariable Long id) {
        Optional<Manutencao> manutencaoParaDeletar = manutencaoRepository.findById(id);
        if (manutencaoParaDeletar.isPresent()) {
            manutencaoRepository.delete(manutencaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
