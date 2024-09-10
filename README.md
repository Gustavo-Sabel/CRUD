# 🚀 Projeto CRUD em Java com PostgreSQL & Postman

Uma aplicação Java que implementa um CRUD (Create, Read, Update, Delete) completo para gerenciar peças, equipamentos, usuários, veículos, manutenção, produção, qualidade e estoque de um sistema de Fábrica de Veículos. A aplicação utilizará um banco de dados (PostgreSQL) para armazenar e gerenciar dados das entidades.

## 🎯 Objetivo
Utilizar os meus estudos com programação em Java na prática em um projeto real e funcional.

---

## 🛠️ Tecnologias Utilizadas

- **Java** (JDK 11+)
- **Postman** (para testar as APIs)

---

## 📂 Estrutura do Projeto

```bash
├── .idea
├── .mvn
│   └── wrapper # Encapsula os tipos primitivos do código
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br/com/crud/projeto/fabrica_veiculo
│   │   │        ├── controller   # Controladores REST
│   │   │        ├── entities     # Entidades JPA e DTOs
│   │   │        ├── repository   # Repositórios JPA
│   │   │        └── FabricaDeVeiculoApplication.java # Inicia a aplicação Spring Boot
│   │   └── resources
│   │       ├── application.properties # Configurações do BD
│   │       └── Documentation
│   │           ├── Collection
│   │           │   └── Requisições CRUD.postman_collection
│   │           ├── JavaDoc # Documentação JavaDoc do CRUD
│   │           ├── DER
│   │           └── DER_Versao2
│   └── test
│       └── java
│           └── br/com/crud/projeto/fabrica_veiculo
│               └── FabricaDeVeiculoApplicationTests.java # Executa testes automatizados
└── target # Armazena os arquivos compilados e artefatos gerados pelo código
```
---

## 🚀 Como Rodar o Projeto

### Pré-requisitos:
- Postman instalado e configurado.
- Java 11+ instalado.

---
## 🏆 Clone o repositório:

```bash
https://github.com/Gustavo-Sabel/CRUD.git
```
---
## 🔥 Endpoints CRUD
Abaixo estão os endpoints disponíveis para manipulação de dados via API REST:

| Método |             Endpoint             |         Descrição          |
|:-------|:--------------------------------:|---------------------------:|
| POST   | (http://localhost:8080/entidade) |  Cria uma nova entidade    |
| GET    | (http://localhost:8080/entidade) |  Lista todas as entidades  |
| GET    |(http://localhost:8080/entidade/3)|   Busca entidade pelo ID   |
| PUT    |(http://localhost:8080/entidade/1)|    Atualiza uma entidade   |
| DELETE | (http://localhost:8080/entidade) |    Deletar uma entidade	   |

---

## ❌ Exemplos de Corpo de Requisição

POST - Criar um novo usuário:
```bash
{
    "nome":"Emerson",
    "email":"Emerson@gmail.com",
    "senha":"emerson1560",
    "perfil":"Emerson de Souza"
}
```
PUT -  Atualizar um usuário existente:
```bash
{
    "nome":"Emerson",
    "email":"Emerson@gmail.com",
    "senha":"emerson1560",
    "perfil":"Emerson de Souza Sabel"
}
```

---
## 🧪 Testando a API com Postman
- Importe a requisição no Postman: Abra o Postman, crie uma nova coleção e adicione os endpoints da API.
- Execute as requisições: Teste as operações CRUD com os métodos POST, GET, PUT e DELETE nos respectivos endpoints.
- Exemplo de JSON: Use os exemplos acima como referência para o corpo das requisições.

---
### ✅ Anotação

- Desenvolvi este software como TCC do curso de Desenvolvimento de Sistemas.
- Criei este repositório para estudar diferentes tipos de commits e também para organizar o código como um todo.
