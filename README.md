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

Existem três maneiras de rodar todos os projetos, via script utilitário que deixei para auxiliar no desenvolvimento, manualmente ou via docker-compose.

**Obs: independente da maneira que você queira rodar, será necessário realizar o `build` das aplicações com o comando `gradle build` na raiz de cada aplicação, para poder criar suas imagens, ou seja, será necessário ter o Docker e o Gradle instalado.**

### Rodando tudo com script utiliário

Para rodar tudo com o script, basta executar o comando:

`python build.py`

Para isso, será necessário ter o Python 3 instalado.

O script fará todos os seguintes processos:

* Parará e apagará todos os containers rodando.
* Entrará no diretório de cada uma das 4 APIs e rodará o comando `gradle build` em paralelo para não levar muito tempo realizando sequencialmente.
* Irá aguardar o build de cada API finalizar.
* Assim que todos os builds finalizarem, então irá executar todos os containers novamente.

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

Será possível acessar as aplicações via `Swagger` ou via `Postman`.

#### Collection do Postman

Caso queira executar via `Postman`, basta realizar o download da `Collection` ![disponibilizada aqui](https://github.com/vhnegrisoli/curso-udemy-autenticacao-stateless-stateful-microsservicos/blob/main/Conte%C3%BAdos/Curso%20Autentica%C3%A7%C3%A3o%20Stateless%20e%20Stateful%20em%20Microsservi%C3%A7os.postman_collection.json), e importar em seu `Postman`.

![Collections](https://github.com/vhnegrisoli/curso-udemy-autenticacao-stateless-stateful-microsservicos/blob/main/Conte%C3%BAdos/Collection.png)

#### Swagger

Os acessos de host e porta das aplicações são:

* stateless-auth-api: http://localhost:8080/swagger-ui/index.html
* stateless-any-api: http://localhost:8081/swagger-ui/index.html
* stateful-auth-api: http://localhost:8082/swagger-ui/index.html
* stateful-any-api: http://localhost:8083/swagger-ui/index.html

Exemplos de acesso:

![API 1](https://github.com/vhnegrisoli/curso-udemy-autenticacao-stateless-stateful-microsservicos/blob/main/Conte%C3%BAdos/Swagger%20API%201.png)

![API 2](https://github.com/vhnegrisoli/curso-udemy-autenticacao-stateless-stateful-microsservicos/blob/main/Conte%C3%BAdos/Swagger%20API%202.png)

Os acessos de host e porta dos bancos de dados são:

* stateless-auth-db (PostgreSQL): localhost:5432
* stateful-auth-db (PostgreSQL): localhost:5433
* token-redis (Redis): localhost:6379

## Autor

### Victor Hugo Negrisoli
### Desenvolvedor de Software Back-End
