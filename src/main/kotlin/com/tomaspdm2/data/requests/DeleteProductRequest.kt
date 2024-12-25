package com.tomaspdm2.data.requests

data class DeleteProductRequest (
    val id: String
        )

/*Forma estruturada de passar as informações necessárias (no caso o ID) usado para a função
deleteProductById no ficheiro CompanyDatabase.kt*/