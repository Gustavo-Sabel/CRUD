package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Producao;
import br.com.crud.projeto.fabrica_veiculo.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de produção.
 */
@RestController
@RequestMapping("/producoes")
public class ProducaoController {

    @Autowired
    private ProducaoRepository producaoRepository;

    /**
     * Obtém todos os registros de produção.
     *
     * @return Uma lista contendo todos os registros de produção.
     */
    @GetMapping
    public List<Producao> getAllProducao() {
        return producaoRepository.findAll();
    }

    /**
     * Obtém um registro de produção pelo seu ID.
     *
     * @param id O ID do registro de produção.
     * @return ResponseEntity contendo o registro de produção encontrado, se existir.
     *         Retorna ResponseEntity.notFound() se nenhum registro com o ID especificado for encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producao> getProducaoById(@PathVariable Long id) {
        Optional<Producao> producaoBuscado = producaoRepository.findById(id);
        return producaoBuscado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo registro de produção.
     *
     * @param producao O novo registro de produção a ser criado. Deve ser enviado no corpo da requisição (RequestBody).
     * @return O registro de produção criado, incluindo o ID gerado automaticamente.
     */
    @PostMapping
    public Producao createProducao(@RequestBody Producao producao) {
        return producaoRepository.save(producao);
    }

    /**
     * Atualiza um registro de produção existente.
     *
     * @param id                            O ID do registro de produção a ser atualizado.
     * @param producaoComDadosAtualizados    Os novos dados do registro de produção a serem atualizados.
     * @return ResponseEntity contendo o registro de produção atualizado, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhum registro com o ID especificado for encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producao> updateProducao(@PathVariable Long id,
                                                   @RequestBody Producao producaoComDadosAtualizados) {
        Optional<Producao> producaoExistente = producaoRepository.findById(id);
        if (producaoExistente.isPresent()) {
            producaoComDadosAtualizados.setIdProducao(id);
            return ResponseEntity.ok(producaoRepository.save(producaoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um registro de produção pelo seu ID.
     *
     * @param id O ID do registro de produção a ser excluído.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se o registro foi excluído com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhum registro com o ID especificado for encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducao(@PathVariable Long id) {
        Optional<Producao> producaoParaDeletar = producaoRepository.findById(id);
        if (producaoParaDeletar.isPresent()) {
            producaoRepository.delete(producaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
