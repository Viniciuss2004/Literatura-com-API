# 📚 LiterAlura - Catálogo de Livros com API do Projeto Gutendex

Neste projeto, desenvolvi um catálogo de livros que consome dados diretamente da API [Gutendex](https://gutendex.com/), permitindo buscar, filtrar e armazenar livros e autores em um banco de dados relacional usando Spring Boot e JPA.

## 🚀 Funcionalidades

- 🔍 **Busca de livros** por título ou nome do autor.
- 💾 **Armazenamento** de livros e autores no banco de dados.
- 📜 **Listagem** dos livros salvos no banco.
- ✍️ **Listagem** dos autores salvos.
- 📆 **Filtragem** de autores por ano de nascimento e falecimento.
- 🌍 **Filtragem** de livros por idioma.

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Postgres
- Jackson (para manipulação de JSON)
- API HTTP Client (Java 11+)
- Maven

## 🧠 Conceitos Aplicados

- Integração com API externa via HTTP
- Consumo e conversão de dados JSON com Jackson
- Uso de `@Record` para DTOs
- Relacionamento ManyToMany entre entidades
- Repositórios com queries customizadas (JPQL)
- Uso de boas práticas de organização e responsabilidade de classes

## 📁 Estrutura do Projeto

```bash
br.com.alura.Literatura.com.API
├── controller/
├── dto/
├── main/
├── model/
├── repository/
├── service/
└── LiteraturaComApiApplication.java
