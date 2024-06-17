
# API Java Spring Boot - CRUD de Publicação

Esta é uma API Java Spring Boot para gerenciar uma tabela de Publicação, documentada usando Swagger. A API oferece operações CRUD (Create, Read, Update, Delete) para a tabela Publicação.

## Funcionalidades

* Criar um novo post
* Listar todos os posts
* Buscar um post pelo ID
* Atualizar um post existente
* Deletar um post pelo ID

## Documentação da API

#### Cria uma publicação

```http
  POST /publicacoes
```

#### Retorna todos as publicações

```http
  GET /publicacoes
```

#### Retorna uma publicação desejada

```http
  GET /publicacoes/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. O ID da publicação |

#### Atualiza Publicação

```http
  PUT /publicacoes/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. O ID da publicação |

#### Deleta uma Publicação

```http
  DELETE /publicacoes/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. O ID da publicação |


## Stack utilizada


* Java 17
* Spring Boot 3.2.5
* Spring Data JPA
* Hibernate
* MySQL 
* Swagger
* Maven


## Como executar

1. **Clone o repositório**

```sh
    git clone https://github.com/Hanami-Staff/SQUAD-10.git
    cd SQUAD-10
```

2. **Configure o arquivo application.properties**
```sh

    spring.datasource.url=jdbc:mysql://localhost:3306/blogHanami?createDatabaseIfNotExist=true&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
3. **Execute utilizando o Maven**

```sh 
    ./mvnw spring-boot:run
```

4. **Acesse a documentação do Swagger**

```sh
    http://localhost:8080/swagger-ui/index.html

```
## Licença


Este projeto está licenciado sob a licença [MIT](https://choosealicense.com/licenses/mit/).

