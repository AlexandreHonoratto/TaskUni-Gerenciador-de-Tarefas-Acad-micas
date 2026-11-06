package TaskUni.service;

import TaskUni.model.Tarefa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GerenciadorTarefas {

    private final List<Tarefa> tarefas =
            new ArrayList<>();

    private Long proximoId = 1L;

    public synchronized void cadastrar(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException(
                "Tarefa obrigatoria"
            );
        }

        tarefa.setId(proximoId++);
        tarefa.setStatus("pendente");
        tarefas.add(tarefa);
    }

    public synchronized List<Tarefa> listar() {
        return new ArrayList<>(tarefas);
    }

    public synchronized Tarefa buscarPorId(Long id) {
        return tarefas.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public synchronized void atualizarStatus(
            Long id, String status) {

        if (!"pendente".equals(status)
                && !"concluida".equals(status)) {
            throw new IllegalArgumentException(
                "Status invalido"
            );
        }

        Tarefa tarefa = buscarPorId(id);

        if (tarefa == null) {
            throw new IllegalArgumentException(
                "Tarefa nao encontrada"
            );
        }

        tarefa.atualizarStatus(status);
    }
}
