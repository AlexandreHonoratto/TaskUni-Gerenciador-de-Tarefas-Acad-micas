# TaskUni — Gerenciador de Tarefas Acadêmicas

## 📚 Sobre o projeto

O **TaskUni** é uma aplicação web desenvolvida para facilitar a organização e o acompanhamento de tarefas acadêmicas.

O sistema permite que estudantes cadastrem atividades, consultem seus prazos de entrega e acompanhem o andamento de seus trabalhos e estudos em um único ambiente.

O projeto foi desenvolvido utilizando Java e Spring Boot no backend, com uma interface web construída em HTML, CSS e JavaScript.

## 🎯 Problema que o projeto resolve

Estudantes universitários frequentemente precisam lidar com diversas atividades, trabalhos, provas e prazos de entrega. A falta de organização pode dificultar o acompanhamento dessas responsabilidades e ocasionar esquecimentos ou atrasos.

O TaskUni busca solucionar esse problema por meio de uma plataforma simples e intuitiva que centraliza as tarefas acadêmicas e facilita seu gerenciamento.

## 👥 Público-alvo

O sistema é destinado a estudantes universitários que desejam organizar suas atividades acadêmicas, acompanhar prazos e controlar o status de suas tarefas.

## ⚙️ Requisitos funcionais implementados

A primeira versão do TaskUni contempla três requisitos funcionais:

- **RF01 — Cadastro de tarefas:** permite cadastrar tarefas com título, descrição, disciplina e prazo de entrega.
- **RF02 — Consulta de tarefas:** permite visualizar as tarefas cadastradas e suas respectivas informações.
- **RF03 — Atualização de status:** permite marcar tarefas pendentes como concluídas.

As três funcionalidades foram verificadas por meio da interface web.

## 🛠️ Tecnologias utilizadas

- **Java:** linguagem utilizada no desenvolvimento do backend.
- **Spring Boot 4.1.2:** framework utilizado na construção da aplicação e da API REST.
- **Maven:** gerenciamento de dependências e construção do projeto Java.
- **HTML5:** estruturação das páginas da aplicação.
- **CSS3:** estilização e organização visual da interface.
- **JavaScript:** implementação das interações e comunicação com a API REST.
- **Git e GitHub:** controle de versão e armazenamento do código-fonte.
- **Visual Studio Code:** ambiente utilizado no desenvolvimento.

## 🏗️ Estrutura do projeto

A aplicação está organizada em três componentes principais:

- **Model — Tarefa:** representa uma tarefa acadêmica, incluindo identificador, título, descrição, disciplina, prazo e status.
- **Service — GerenciadorTarefas:** contém a lógica de gerenciamento das tarefas, incluindo cadastro, consulta e atualização de status.
- **Controller — TarefaController:** disponibiliza os recursos da aplicação por meio de uma API REST.

O frontend utiliza HTML, CSS e JavaScript para apresentar as informações e permitir a interação com o sistema.

## 🔗 API REST

A aplicação disponibiliza os seguintes endpoints:

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/tarefas` | Lista as tarefas cadastradas |
| GET | `/tarefas/{id}` | Consulta uma tarefa pelo identificador |
| POST | `/tarefas` | Cadastra uma nova tarefa |
| PATCH | `/tarefas/{id}/status` | Atualiza o status de uma tarefa |

A API utiliza JSON para a comunicação entre frontend e backend.

## ▶️ Como executar o projeto

### Pré-requisitos

- JDK 17 ou versão compatível.
- Git, para clonar o repositório.
- Navegador web.
- Conexão com a internet na primeira execução, para baixar as dependências do Maven.

### Executando no Windows

**1.** Clone o repositório do GitHub ou baixe seus arquivos.

**2.** Abra a pasta do projeto no Visual Studio Code.

**3.** No terminal, entre na subpasta da aplicação:

```powershell
cd taskuni
```

**4.** Execute o Spring Boot:

```powershell
.\mvnw.cmd spring-boot:run
```

**5.** Aguarde a mensagem de inicialização do servidor.

**6.** Abra o navegador e acesse:

http://localhost:8080/

A interface do TaskUni estará disponível para utilização.

## 🧪 Testes

O projeto possui um teste automatizado de inicialização do contexto Spring Boot.

Para executar os testes no Windows:

```powershell
.\mvnw.cmd test
```

Durante o desenvolvimento, a execução do Maven apresentou `BUILD SUCCESS`, sem falhas no teste automatizado existente.

Também foram realizados testes manuais de cadastro, consulta e atualização do status das tarefas pela interface web.

## 📊 Diagrama UML

O projeto utiliza um diagrama de classes UML para representar a estrutura orientada a objetos da aplicação.

O diagrama apresenta as classes `Tarefa` e `GerenciadorTarefas`, seus atributos, métodos e o relacionamento de gerenciamento das tarefas.

![Diagrama UML do TaskUni](Diagrama%20UML%20TaskUni.png)

## 📌 Escopo e limitações

A primeira versão do TaskUni contempla as funcionalidades essenciais de cadastro, consulta e atualização de status.

Atualmente, as tarefas são armazenadas em memória durante a execução da aplicação. Isso significa que os dados são perdidos quando o servidor é reiniciado.

A implementação de persistência em banco de dados e outras melhorias poderá ser considerada em versões futuras, conforme os requisitos acadêmicos e a disponibilidade da equipe.

## 👨‍💻 Integrantes do grupo

- Alexandre Gonçalves Honorato
- Heloísa Laura Marques Melo
- Luiz Antônio de Sousa Neto
- Deivid Alves Silva

## 🎓 Contexto acadêmico

Projeto desenvolvido para a disciplina **Programação para Internet**, como atividade prática do segundo bimestre.

O desenvolvimento contempla conceitos de programação orientada a objetos, organização de classes, construção de APIs REST e integração entre frontend e backend.