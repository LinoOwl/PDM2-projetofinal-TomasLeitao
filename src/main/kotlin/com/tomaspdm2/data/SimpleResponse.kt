package com.tomaspdm2.data

data class SimpleResponse<T>(
    val status: Boolean,
    val message: String,
    val data: T
)
/*Estrutura da resposta dada quando usa-se o postman ou outro software/forma para testar a API
os valores são implementados no ficheiro ProductRoute.kt*/