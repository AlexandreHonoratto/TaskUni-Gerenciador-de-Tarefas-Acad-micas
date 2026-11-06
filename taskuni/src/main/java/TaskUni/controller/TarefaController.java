package TaskUni.controller;

import TaskUni.model.Tarefa;
import TaskUni.service.GerenciadorTarefas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final GerenciadorTarefas gerenciador;

    public TarefaController(
            GerenciadorTarefas gerenciador) {
        this.gerenciador = gerenciador;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return gerenciador.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(
            @PathVariable Long id) {

        Tarefa tarefa = gerenciador.buscarPorId(id);

        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> cadastrar(
            @RequestBody Tarefa tarefa) {

        if (tarefa.getTitulo() == null
                || tarefa.getTitulo().isBlank()
                || tarefa.getDisciplina() == null
                || tarefa.getDisciplina().isBlank()
                || tarefa.getPrazo() == null) {
            return ResponseEntity.badRequest().build();
        }

        gerenciador.cadastrar(tarefa);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tarefa);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> dados) {

        if (gerenciador.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            gerenciador.atualizarStatus(
                id, dados.get("status")
            );

            return ResponseEntity.ok(
                gerenciador.buscarPorId(id)
            );

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .badRequest()
                .body(Map.of("erro", e.getMessage()));
        }
    }
}
