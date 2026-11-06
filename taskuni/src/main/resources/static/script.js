
const formulario = document.getElementById("formTarefa");
const lista = document.getElementById("listaTarefas");
const mensagem = document.getElementById("mensagem");

async function listarTarefas() {
    try {
        const resposta = await fetch("/tarefas");

        if (!resposta.ok) {
            throw new Error("Erro ao consultar tarefas");
        }

        const tarefas = await resposta.json();
        lista.replaceChildren();

        if (tarefas.length === 0) {
            lista.textContent = "Nenhuma tarefa cadastrada.";
            return;
        }

        tarefas.forEach(tarefa => {
            const div = document.createElement("div");
            div.className = "tarefa";

            const titulo = document.createElement("h3");
            titulo.textContent = tarefa.titulo;

            const detalhes = document.createElement("p");
            detalhes.textContent =
                `${tarefa.disciplina} | Prazo: ${tarefa.prazo}`;

            const status = document.createElement("p");
            status.textContent = `Status: ${tarefa.status}`;

            div.append(titulo, detalhes, status);

            if (tarefa.status === "pendente") {
                const botao = document.createElement("button");
                botao.textContent = "Concluir";

                botao.addEventListener("click", async () => {
                    try {
                        const resposta = await fetch(
                            `/tarefas/${tarefa.id}/status`,
                            {
                                method: "PATCH",
                                headers: {
                                    "Content-Type": "application/json"
                                },
                                body: JSON.stringify({
                                    status: "concluida"
                                })
                            }
                        );

                        if (!resposta.ok) {
                            throw new Error("Erro ao concluir tarefa");
                        }

                        await listarTarefas();
                    } catch (erro) {
                        mensagem.textContent = erro.message;
                    }
                });

                div.appendChild(botao);
            }

            lista.appendChild(div);
        });
    } catch (erro) {
        mensagem.textContent = erro.message;
    }
}

formulario.addEventListener("submit", async evento => {
    evento.preventDefault();

    const tarefa = {
        titulo: document.getElementById("titulo").value,
        descricao: document.getElementById("descricao").value,
        disciplina: document.getElementById("disciplina").value,
        prazo: document.getElementById("prazo").value
    };

    try {
        const resposta = await fetch("/tarefas", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(tarefa)
        });

        if (!resposta.ok) {
            throw new Error("Não foi possível cadastrar");
        }

        formulario.reset();
        mensagem.textContent = "Tarefa cadastrada!";
        await listarTarefas();
    } catch (erro) {
        mensagem.textContent = erro.message;
    }
});

listarTarefas();
