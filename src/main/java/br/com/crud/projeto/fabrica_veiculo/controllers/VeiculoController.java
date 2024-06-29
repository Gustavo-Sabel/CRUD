package br.com.crud.projeto.fabrica_veiculo.controllers;

import br.com.crud.projeto.fabrica_veiculo.entities.Veiculo;
import br.com.crud.projeto.fabrica_veiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de veículos.
 */
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    /**
     * Obtém todos os veículos cadastrados.
     *
     * @return Uma lista contendo todos os veículos.
     */
    @GetMapping
    public List<Veiculo> getAllVeiculo() {
        return veiculoRepository.findAll();
    }

    /**
     * Obtém um veículo pelo seu ID (chassi).
     *
     * @param chassi O ID (chassi) do veículo a ser buscado.
     * @return ResponseEntity contendo o veículo encontrado, se existir.
     *         Retorna ResponseEntity.notFound() se nenhum veículo com o ID especificado for encontrado.
     */
    @GetMapping("/{chassi}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable String chassi) {
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(chassi);
        return veiculoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo veículo.
     *
     * @param veiculo O veículo a ser criado. Deve ser enviado no corpo da requisição (RequestBody).
     * @return O veículo criado, incluindo o chassi gerado automaticamente.
     */
    @PostMapping
    public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    /**
     * Atualiza um veículo existente.
     *
     * @param chassi                      O ID (chassi) do veículo a ser atualizado.
     * @param veiculoComDadosAtualizados  Os novos dados do veículo a serem atualizados.
     * @return ResponseEntity contendo o veículo atualizado, se a atualização for bem-sucedida.
     *         Retorna ResponseEntity.notFound() se nenhum veículo com o ID especificado for encontrado.
     */
    @PutMapping("/{chassi}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable String chassi,
                                                 @RequestBody Veiculo veiculoComDadosAtualizados) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(chassi);
        if (veiculoExistente.isPresent()) {
            veiculoComDadosAtualizados.setChassi(chassi);
            return ResponseEntity.ok(veiculoRepository.save(veiculoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um veículo pelo seu ID (chassi).
     *
     * @param chassi O ID (chassi) do veículo a ser excluído.
     * @return ResponseEntity indicando o sucesso ou falha da operação de exclusão.
     *         Retorna ResponseEntity.noContent() se o veículo foi excluído com sucesso.
     *         Retorna ResponseEntity.notFound() se nenhum veículo com o ID especificado for encontrado.
     */
    @DeleteMapping("/{chassi}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable String chassi) {
        Optional<Veiculo> veiculoParaDeletar = veiculoRepository.findById(chassi);
        if (veiculoParaDeletar.isPresent()) {
            veiculoRepository.delete(veiculoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
