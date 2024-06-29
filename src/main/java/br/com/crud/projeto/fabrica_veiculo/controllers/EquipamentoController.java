package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Equipamento;
import br.com.crud.projeto.fabrica_veiculo.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de equipamentos.
 */
@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    /**
     * Obtém todos os equipamentos cadastrados.
     *
     * @return Uma lista contendo todos os equipamentos cadastrados.
     */
    @GetMapping
    public List<Equipamento> getAllEquipamentos() {
        return equipamentoRepository.findAll();
    }

    /**
     * Obtém um equipamento pelo seu ID.
     *
     * @param id O ID do equipamento desejado.
     * @return ResponseEntity contendo o equipamento encontrado, se existir.
     *         Retorna ResponseEntity.notFound() se nenhum equipamento com o ID especificado for encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable Long id) {
        Optional<Equipamento> equipamentoBuscado = equipamentoRepository.findById(id);
        return equipamentoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo equipamento.
     *
     * @param equipamento O novo equipamento a ser criado. Deve ser enviado no corpo da requisição (RequestBody).
     * @return O equipamento criado, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Equipamento createEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    /**
     * Atualiza um equipamento existente.
     *
     * @param id                        O ID do equipamento a ser atualizado.
     * @param equipamentoAtualizado Os novos dados do equipamento a serem atualizados.
     * @return ResponseEntity contendo o equipamento atualizado, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhum equipamento com o ID especificado for encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> updateEquipamento(@PathVariable Long id,
                                                         @RequestBody Equipamento equipamentoAtualizado) {
        Optional<Equipamento> equipamentoExistente = equipamentoRepository.findById(id);
        if (equipamentoExistente.isPresent()) {
            equipamentoAtualizado.setIdEquipamento(id);
            return ResponseEntity.ok(equipamentoRepository.save(equipamentoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um equipamento pelo seu ID.
     *
     * @param id O ID do equipamento a ser excluído.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se o equipamento foi excluído com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhum equipamento com o ID especificado for encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipamento(@PathVariable Long id) {
        Optional<Equipamento> equipamentoParaDeletar = equipamentoRepository.findById(id);
        if (equipamentoParaDeletar.isPresent()) {
            equipamentoRepository.delete(equipamentoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
