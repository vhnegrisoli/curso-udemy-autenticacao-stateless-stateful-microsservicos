# Projeto: Curso Udemy - Autenticação Stateful e Stateles em Microsserviços

Repositório contendo o projeto desenvolvido do curso Autenticação Stateful e Stateles em Microsserviços, ministrado por mim para a plataforma Udemy.

## Tecnologias

* **Java 17**
* **Spring Boot**
* **API REST**
* **PostgreSQL (Container e Heroku Postgres)**
* **Docker**
* **docker-compose**
* **JWT**
* **Spring Cloud OpenFeign**

## Arquitetura Proposta

No curso, desenvolveremos a seguinte aquitetura:

### Autenticação Stateless

![Arquitetura Stateless](https://github.com/vhnegrisoli/curso-udemy-autenticacao-stateless-stateful-microsservicos/blob/main/Conte%C3%BAdos/Stateless%20Auth%20JWT.png)

### Autenticação Stateful

![Arquitetura Stateful](https://github.com/vhnegrisoli/curso-udemy-autenticacao-stateless-stateful-microsservicos/blob/main/Conte%C3%BAdos/Stateful%20Auth.png)

* Serão desenvolvidos 2 projetos, o projeto `stateless` e o projeto `stateful`.
* Cada projeto terá 2 aplicações, totalizando 4 APIs.
* Em cada projeto, teremos a API de Auth, responsável por gerar o token.
* Em cada projeto, teremos a API chamada Any, responsável por retornar uma informação, qualquer, que irá apenas simular um microsserviço aleatório que precisa validar o token.
* Na arquitetura `stateful`, será utilizado o banco de dados NoSQL Redis para armazenar os tokens.

### Execução das aplicações

Para rodar as aplicações, será necessário ter instalado:

* Docker
* Java 17
* Gradle 7.6 ou superior

Para rodar as aplicações, você pode rodar diretamente via IDE, ou também, pode executar o comando: `gradle bootRun` na raiz de cada aplicação.

### Execução dos containers

Para executar o PostgreSQL e o Redis, basta executar o arquivo `docker-compose.yml`
com o comando:

`docker-compose up --build -d`

## Autor

### Victor Hugo Negrisoli
### Desenvolvedor de Software Back-End
