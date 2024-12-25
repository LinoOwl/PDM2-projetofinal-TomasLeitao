# PDM2-projetofinal

## tecnologias usadas no projeto
>intellij IDEA

>MongoDB(conexão a base de dados)

>KMongo(lib para integração MongoDB em Kotlin)

>Ktor(Framework)

>Postman(para testar a API)


# Setup 

1-Abra o projeto no intellij IDEA

2-A melhor maneira de Iniciar o projeto é clicando no gradle na aba a direita e seguir o caminho de projetofinal-Tasks-application-e doubleclick em run.
mas pode iniciar pelo ficheiro Application.kt

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


