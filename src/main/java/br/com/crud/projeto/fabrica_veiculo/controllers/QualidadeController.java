package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Qualidade;
import br.com.crud.projeto.fabrica_veiculo.repositories.QualidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de qualidade.
 */
@RestController
@RequestMapping("/qualidades")
public class QualidadeController {

    @Autowired
    private QualidadeRepository qualidadeRepository;

    /**
     * Obtém todos os registros de qualidade.
     *
     * @return Uma lista contendo todos os registros de qualidade.
     */
    @GetMapping
    public List<Qualidade> getAllQualidade() {
        return qualidadeRepository.findAll();
    }

    /**
     * Obtém um registro de qualidade pelo seu ID.
     *
     * @param id O ID do registro de qualidade.
     * @return ResponseEntity contendo o registro de qualidade encontrado, se existir.
     *         Retorna ResponseEntity.notFound() se nenhum registro com o ID especificado for encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Qualidade> getQualidadeById(@PathVariable Long id) {
        Optional<Qualidade> qualidadeBuscado = qualidadeRepository.findById(id);
        return qualidadeBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo registro de qualidade.
     *
     * @param qualidade O novo registro de qualidade a ser criado. Deve ser enviado no corpo da requisição (RequestBody).
     * @return O registro de qualidade criado, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Qualidade createQualidade(@RequestBody Qualidade qualidade) {
        return qualidadeRepository.save(qualidade);
    }

    /**
     * Atualiza um registro de qualidade existente.
     *
     * @param id                             O ID do registro de qualidade a ser atualizado.
     * @param qualidadeComDadosAtualizados    Os novos dados do registro de qualidade a serem atualizados.
     * @return ResponseEntity contendo o registro de qualidade atualizado, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhum registro com o ID especificado for encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Qualidade> updateQualidade(@PathVariable Long id,
                                                     @RequestBody Qualidade qualidadeComDadosAtualizados) {
        Optional<Qualidade> qualidadeExistente = qualidadeRepository.findById(id);
        if (qualidadeExistente.isPresent()) {
            qualidadeComDadosAtualizados.setIdinspecaoqualidade(id);
            return ResponseEntity.ok(qualidadeRepository.save(qualidadeComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um registro de qualidade pelo seu ID.
     *
     * @param id O ID do registro de qualidade a ser excluído.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se o registro foi excluído com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhum registro com o ID especificado for encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualidade(@PathVariable Long id) {
        Optional<Qualidade> qualidadeParaDeletar = qualidadeRepository.findById(id);
        if (qualidadeParaDeletar.isPresent()) {
            qualidadeRepository.delete(qualidadeParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
