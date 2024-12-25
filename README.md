# PDM2-projetofinal

This project was created using the [Ktor Project Generator](https://start.ktor.io).

Here are some useful links to get you started:

- [Ktor Documentation](https://ktor.io/docs/home.html)
- [Ktor GitHub page](https://github.com/ktorio/ktor)
- The [Ktor Slack chat](https://app.slack.com/client/T09229ZC6/C0A974TJ9). You'll need to [request an invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up) to join.
- [MongoDB Documentation](https://www.mongodb.com/pt-br/docs/)

## tecnologias usadas no projeto
>intellij IDEA

>MongoDB(conexão a base de dados)

>KMongo(lib para integração MongoDB em Kotlin)

>Ktor(Framework)

>Postman(para testar a API)

## em caso de erro na conexão com a base mande um email para "tomas.leitao@my.istec.pt" para deixar a base de dados aberta a todos endereços IP

# Setup 

1-faça Download e abra o projeto no intellij IDEA

2-Assim que gradle acabar o seu processo, deve iniciar o projeto, a melhor maneira de Iniciar o projeto é clicando no gradle na aba a direita e seguir o caminho de projetofinal-Tasks-application-e doubleclick em run mas pode iniciar pelo ficheiro Application.kt

3-Use o postman para testar a API, usando um JSON como body

>body example

{
"name": "",
"category": "",
"price": "",
"id": "" 
}

# Paths para testar a API


## Encontrar um produto 

GET "http://127.0.0.1:8080/get-product"

é necessário um id de um item na base de dados

>body example

{ 
"id": "676c4152fc3c5b528b4752c3"
}

outros ID-676c41a3fc3c5b528b4752c7;     676c41c6fc3c5b528b4752c8;       676c41ecfc3c5b528b4752ca.


## Criar um produto 

POST "http://127.0.0.1:8080/create-update-product"

necessita de json com name, category e price preenchidos numa String exemplo "name": "tomas", a String em id deve estar vazia, o código ira criar um id para o produto.

>body example

{
"name": "",
"category": "",
"price": "",
"id": "" 
}


## Editar um produto 

POST "http://127.0.0.1:8080/create-update-product"

é necessário um id de um item na base de dados, junto com name, category e price preenchidos numa String.

>body example

{ 
"name": "",
"category": "",
"price": "",
"id": "676c4152fc3c5b528b4752c3"
}

outros ID-676c41a3fc3c5b528b4752c7;      676c41c6fc3c5b528b4752c8;      676c41ecfc3c5b528b4752ca.

use o mesmo ID para o produto que editou e tente fazer GET "http://127.0.0.1:8080/get-product" desse ID e ver que alterou.


## Eliminar um produto 

POST "http://127.0.0.1:8080/delete-product"

é necessário um id de um item na base de dados

>body example

{ 
"id": "676c4152fc3c5b528b4752c3"
}

outros ID-676c41a3fc3c5b528b4752c7;      676c41c6fc3c5b528b4752c8;      676c41ecfc3c5b528b4752ca.

use o mesmo ID e tente GET "http://127.0.0.1:8080/get-product", o produto não deve mais existir

# Pode tentar eliminar ou editar ou ver produtos usando ID que não existem ou não utilizar nenhum ID para testar se a API consegue responder de maneira adequada


## Se quiser usar a sua base de dados instale MongoDB compass e siga este tutorial "https://www.youtube.com/watch?v=RffGopDsAok", depois copie o URL e altere a ConnectionString da variavel client em CompanyDatabase.



