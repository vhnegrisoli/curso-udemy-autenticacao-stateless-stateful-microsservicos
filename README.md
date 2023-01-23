# Projeto: Curso Udemy - Autenticação Stateful e Stateles em Microsserviços

Repositório contendo o projeto desenvolvido do curso Autenticação Stateful e Stateles em Microsserviços, ministrado por mim para a plataforma Udemy.

## Tecnologias

* **Java 17**
* **Spring Boot 3**
* **API REST**
* **PostgreSQL (Container e Heroku Postgres)**
* **Docker**
* **docker-compose**
* **JWT**

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

### Executando os projetos

Existem duas maneiras de rodar todos os projetos, manualmente ou via docker-compose.

**Obs: independente da maneira que você queira rodar, será necessário realizar o `build` das aplicações com o comando `gradle build` na raiz de cada aplicação, para poder criar suas imagens.**

#### Execução das aplicações manualmente

Para rodar as aplicações, será necessário ter instalado:

* Docker
* Java 17
* Gradle 7.6 ou superior

Para rodar as aplicações, você pode rodar diretamente via IDE, ou também, pode executar o comando: `gradle bootRun` na raiz de cada aplicação. Realizar o build antes.

### Execução dos containers

Para executar tudo, basta executar o arquivo `docker-compose.yml`
com o comando:

`docker-compose up --build -d`

Lembrando que será necessário realizar o build das aplicações na primeira vez que for executar o docker-compose, ou a cada nova alteração, para que seja sempre construída uma imagem com as últimas alterações.

### Acessando as aplicações

Será possível acessar as aplicações via `Swagger`.

Os acessos de host e porta das aplicações são:

* stateless-auth-api: http://localhost:8080/swagger-ui/index.html
* stateless-any-api: http://localhost:8081/swagger-ui/index.html
* stateful-auth-api: http://localhost:8082/swagger-ui/index.html
* stateful-any-api: http://localhost:8083/swagger-ui/index.html

Os acessos de host e porta dos bancos de dados são:

* stateless-auth-db (PostgreSQL): localhost:5432
* stateful-auth-db (PostgreSQL): localhost:5433
* token-redis (Redis): localhost:6379

## Autor

### Victor Hugo Negrisoli
### Desenvolvedor de Software Back-End
